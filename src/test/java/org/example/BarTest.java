package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    @Test
    void testAddBoisson() {
        Bar bar = new Bar();
        Boisson coca = new Boisson("Coca");
        Boisson whisky = new Boisson("Whisky", 40.0f);

        // Ajouter une boisson sans alcool
        bar.add(coca);
        assertEquals(1, bar.getBoissonFroide().size());
        assertTrue(bar.getBoissonFroide().contains(coca));

        // Ajouter une boisson alcoolisée
        bar.add(whisky);
        assertEquals(1, bar.getBoissonAlcoolisee().size());
        assertTrue(bar.getBoissonAlcoolisee().contains(whisky));
    }

    @Test
    void testAddCocktail() {
        Bar bar = new Bar();
        Cocktail mojito = new Cocktail("Mojito");
        mojito.add("Menthe", 10.0);
        mojito.add("Citron", 20.0);

        // Ajouter un cocktail sans alcool
        bar.add(mojito);
        assertEquals(1, bar.getCocktailSansAlcool().size());
        assertTrue(bar.getCocktailSansAlcool().contains(mojito));
    }

    @Test
    void testServBoisson() {
        Bar bar = new Bar();
        Boisson coca = new Boisson("Coca");
        Boisson whisky = new Boisson("Whisky", 40.0f);

        // Ajouter des boissons
        bar.add(coca);
        bar.add(whisky);

        // Servir une boisson sans alcool
        Boisson servedCoca = (Boisson) bar.serv("Coca");
        assertNotNull(servedCoca);
        assertEquals("Coca", servedCoca.getNom());
        assertEquals(0, bar.getBoissonFroide().size()); // La boisson a été retirée

        // Servir une boisson alcoolisée
        Boisson servedWhisky = (Boisson) bar.serv("Whisky");
        assertNotNull(servedWhisky);
        assertEquals("Whisky", servedWhisky.getNom());
        assertEquals(0, bar.getBoissonAlcoolisee().size()); // La boisson a été retirée
    }

    @Test
    void testServCocktail() {
        Bar bar = new Bar();
        Cocktail mojito = new Cocktail("Mojito");
        mojito.add("Menthe", 10.0);
        mojito.add("Citron", 20.0);

        // Ajouter un cocktail
        bar.add(mojito);

        // Servir un cocktail
        Cocktail servedMojito = (Cocktail) bar.serv("Mojito");
        assertNotNull(servedMojito);
        assertEquals("Mojito", servedMojito.getNom());
        assertEquals(0, bar.getCocktailSansAlcool().size()); // Le cocktail a été retiré
    }

    @Test
    void testServNonExistent() {
        Bar bar = new Bar();
        Boisson coca = new Boisson("Coca");
        bar.add(coca);

        // Essayer de servir une boisson qui n'existe pas
        Object served = bar.serv("Eau");
        assertNull(served); // Doit retourner null
    }

    @Test
    void testToString() {
        Bar bar = new Bar();
        Boisson coca = new Boisson("Coca");
        Boisson whisky = new Boisson("Whisky", 40.0f);
        Cocktail mojito = new Cocktail("Mojito");
        mojito.add("Menthe", 10.0);
        mojito.add("Citron", 20.0);

        // Ajouter des boissons et un cocktail
        bar.add(coca);
        bar.add(whisky);
        bar.add(mojito);

        // Utiliser System.lineSeparator() pour les fins de ligne
        String eol = System.lineSeparator();
        String expected = "Bar:" + eol +
                "\t Sans alcool" + eol +
                "\t\tCoca" + eol +
                "\t Avec alcool" + eol +
                "\t\tWhisky (l'abus d'alcool est dangereux pour la sante)" + eol +
                "\t Cocktail sans alcool" + eol +
                "\t\tMenthe 10.0%\tCitron 20.0%\t" + eol +
                "\t Cocktail avec alcool" + eol +
                "\t Boissons chaudes" + eol;

        assertEquals(expected, bar.toString());
    }
    @Test
    void testGetLists() {
        Bar bar = new Bar();
        Boisson coca = new Boisson("Coca");
        Boisson whisky = new Boisson("Whisky", 40.0f);
        Cocktail mojito = new Cocktail("Mojito");
        mojito.add("Menthe", 10.0);
        mojito.add("Citron", 20.0);

        // Ajouter des éléments
        bar.add(coca);
        bar.add(whisky);
        bar.add(mojito);

        // Vérifier les listes
        assertEquals(1, bar.getBoissonFroide().size());
        assertEquals(1, bar.getBoissonAlcoolisee().size());
        assertEquals(1, bar.getCocktailSansAlcool().size());
        assertEquals(0, bar.getCocktailAvecAlcool().size());
        assertEquals(0, bar.getBoissonChaude().size());
    }
}

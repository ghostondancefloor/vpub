package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    private Bar bar;
    private Boisson coca;
    private Boisson whisky;
    private Cocktail mojito;
    private Cocktail pinaColada;

    @BeforeEach
    void setUp() {
        bar = new Bar();
        coca = new Boisson("Coca");
        whisky = new Boisson("Whisky", 40.0f);
        mojito = new Cocktail("Mojito",true);
        mojito.add("Menthe", 10.0);
        mojito.add("Citron", 20.0);
        pinaColada = new Cocktail("Pina Colada", false);
        pinaColada.add("Ananas", 50.0);
    }

    @Test
    void testAddBoisson() {
        bar.add(coca);
        assertEquals(1, bar.getBoissonFroide().size());
        assertTrue(bar.getBoissonFroide().contains(coca));

        bar.add(whisky);
        assertEquals(1, bar.getBoissonAlcoolisee().size());
        assertTrue(bar.getBoissonAlcoolisee().contains(whisky));
    }

    @Test
    void testAddCocktail() {
        bar.add(mojito);
        assertEquals(1, bar.getCocktailAvecAlcool().size());
        assertTrue(bar.getCocktailAvecAlcool().contains(mojito));

        bar.add(pinaColada);
        assertEquals(1, bar.getCocktailSansAlcool().size());
        assertTrue(bar.getCocktailSansAlcool().contains(pinaColada));
    }

    @Test
    void testServBoisson() {
        bar.add(coca);
        bar.add(whisky);

        Boisson servedCoca = (Boisson) bar.serv("Coca");
        assertNotNull(servedCoca);
        assertEquals("Coca", servedCoca.getNom());
        assertEquals(0, bar.getBoissonFroide().size());

        Boisson servedWhisky = (Boisson) bar.serv("Whisky");
        assertNotNull(servedWhisky);
        assertEquals("Whisky", servedWhisky.getNom());
        assertEquals(0, bar.getBoissonAlcoolisee().size());
    }

    @Test
    void testServCocktail() {
        bar.add(mojito);
        Cocktail servedMojito = (Cocktail) bar.serv("Mojito");
        assertNotNull(servedMojito);
        assertEquals("Mojito", servedMojito.getNom());
        assertEquals(0, bar.getCocktailSansAlcool().size());
    }

    @Test
    void testServNonExistent() {
        bar.add(coca);
        Object served = bar.serv("Eau");
        assertNull(served);
    }

    @Test
    void testToString() {
        Bar bar = new Bar();
        bar.add(new Boisson("Coca"));
        bar.add(new Boisson("Whisky", 40.0f));

        String actual = bar.toString();
        assertTrue(actual.contains("Bar:"));
        assertTrue(actual.contains("Sans alcool"));
        assertTrue(actual.contains("\t\tCoca"));
        assertTrue(actual.contains("Avec alcool"));
        assertTrue(actual.contains("\t\tWhisky (l'abus d'alcool est dangereux pour la sante)"));
        assertTrue(actual.contains("Cocktail sans alcool"));
        assertTrue(actual.contains("Cocktail avec alcool"));
    }

    @Test
    void testGetLists() {
        bar.add(coca);
        bar.add(whisky);
        bar.add(mojito);

        assertEquals(1, bar.getBoissonFroide().size());
        assertEquals(1, bar.getBoissonAlcoolisee().size());
        assertEquals(1, bar.getCocktailAvecAlcool().size());
    }
}

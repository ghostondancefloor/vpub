package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    private Bar bartest;
    private Boisson coca;
    private Boisson whisky;
    private Cocktail mojito;
    private Cocktail pinaColada;

    @BeforeEach
    void setUp() {
        bartest = new Bar();
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
        bartest.add(coca);
        assertEquals(1, bartest.getBoissonFroide().size());
        assertTrue(bartest.getBoissonFroide().contains(coca));

        bartest.add(whisky);
        assertEquals(1, bartest.getBoissonAlcoolisee().size());
        assertTrue(bartest.getBoissonAlcoolisee().contains(whisky));
    }

    @Test
    void testAddCocktail() {
        bartest.add(mojito);
        assertEquals(1, bartest.getCocktailAvecAlcool().size());
        assertTrue(bartest.getCocktailAvecAlcool().contains(mojito));

        bartest.add(pinaColada);
        assertEquals(1, bartest.getCocktailSansAlcool().size());
        assertTrue(bartest.getCocktailSansAlcool().contains(pinaColada));
    }

    @Test
    void testServBoisson() {
        bartest.add(coca);
        bartest.add(whisky);

        Boisson servedCoca = (Boisson) bartest.serv("Coca");
        assertNotNull(servedCoca);
        assertEquals("Coca", servedCoca.getNom());
        assertEquals(0, bartest.getBoissonFroide().size());

        Boisson servedWhisky = (Boisson) bartest.serv("Whisky");
        assertNotNull(servedWhisky);
        assertEquals("Whisky", servedWhisky.getNom());
        assertEquals(0, bartest.getBoissonAlcoolisee().size());
    }

    @Test
    void testServCocktail() {
        bartest.add(mojito);
        Cocktail servedMojito = (Cocktail) bartest.serv("Mojito");
        assertNotNull(servedMojito);
        assertEquals("Mojito", servedMojito.getNom());
        assertEquals(0, bartest.getCocktailSansAlcool().size());
    }

    @Test
    void testServNonExistent() {
        bartest.add(coca);
        Object served = bartest.serv("Eau");
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
        bartest.add(coca);
        bartest.add(whisky);
        bartest.add(mojito);

        assertEquals(1, bartest.getBoissonFroide().size());
        assertEquals(1, bartest.getBoissonAlcoolisee().size());
        assertEquals(1, bartest.getCocktailAvecAlcool().size());
    }
}

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CocktailTest {

    @Test
    void testCocktailSansAlcool() {
        Cocktail cocktail = new Cocktail("Mojito",true);
        assertEquals("Mojito", cocktail.getNom());
        assertTrue(cocktail.alcoolFree());
    }

    @Test
    void testAddIngredient() {
        Cocktail cocktail = new Cocktail("Mojito",false);
        cocktail.add("Menthe", 10.0);
        cocktail.add("Citron", 20.0);

        // Vérifiez que les ingrédients sont correctement ajoutés via toString()
        String expected = "Menthe 10.0%\tCitron 20.0%\t";
        assertEquals(expected, cocktail.toString());
    }

    @Test
    void testToString() {
        Cocktail cocktail = new Cocktail("Mojito",false);
        cocktail.add("Menthe", 10.0);
        cocktail.add("Citron", 20.0);

        String expected = "Menthe 10.0%\tCitron 20.0%\t";
        assertEquals(expected, cocktail.toString());
    }

    @Test
    void testGetNom() {
        Cocktail cocktail = new Cocktail("Mojito",false);
        assertEquals("Mojito", cocktail.getNom());
    }


}

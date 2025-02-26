package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoissonTest {

    @Test
    void testBoissonSansAlcool() {
        Boisson boisson = new Boisson("Coca");
        assertEquals("Coca", boisson.getNom());
        assertFalse(boisson.isAlcoolise());
        assertEquals(0.0f, boisson.getDegre());
    }

    @Test
    void testBoissonAvecAlcool() {
        Boisson boisson = new Boisson("Whisky", 40.0f);
        assertEquals("Whisky", boisson.getNom());
        assertTrue(boisson.isAlcoolise());
        assertEquals(40.0f, boisson.getDegre());
    }

    @Test
    void testToStringSansAlcool() {
        Boisson boisson = new Boisson("Coca");
        assertEquals("Coca", boisson.toString());
    }

    @Test
    void testToStringAvecAlcool() {
        Boisson boisson = new Boisson("Whisky", 40.0f);
        assertEquals("Whisky (l'abus d'alcool est dangereux pour la sante)", boisson.toString());
    }
}

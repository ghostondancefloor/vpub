package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoissonTest {

    @Test
    void testConstructeurSansAlcool(){
        Boisson b = new Boisson("atay");
        assertEquals("atay",b.nom);
        assertFalse(b.alcoolise);
        assertNull(b.degre);
    }

    @Test
    void testConstructeurAlcool(){
        Boisson b = new Boisson("atay7ram",7.5f);
        assertEquals("atay7ram",b.nom);
        assertEquals(7.5f,b.degre);
        assertTrue(b.alcoolise);
    }


    @Test
    void testToStringSansAlcool() {
        Boisson b = new Boisson("atay");
        assertEquals("atay", b.toString());
    }


    @Test
    void testToStringAvecAlcool() {
        Boisson b = new Boisson("Vin", 10.4f);
        assertEquals("Vin (l'abus d'alcool est dangereux pour la sante)", b.toString());
    }
}
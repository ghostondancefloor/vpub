package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class BarTest {
    public Vector<Boisson> boissonChaude;
    public Vector<Boisson> boissonFroide;
    public Vector<Boisson> boissonAlcoolisee;
    public Vector<Cocktail> cocktailSansAlcoole;
    public Vector<Cocktail> cocktailAvecAlcoole;


    @BeforeEach
    void setUp(){
        this.boissonChaude = new Vector<Boisson>();
        this.boissonFroide = new Vector<Boisson>();
        this.boissonAlcoolisee = new Vector<Boisson>();
        this.cocktailAvecAlcoole = new Vector<Cocktail>();
        this.cocktailSansAlcoole = new Vector<Cocktail>();
    }

    @Test
    void add() {
        assertNull(this.boissonAlcoolisee);
        assertNull(this.boissonChaude);
        assertNull(this.boissonFroide);
        assertNull(this.cocktailAvecAlcoole);
        assertNull(this.cocktailSansAlcoole);
    }

    @Test
    void testAdd() {
        fail();
    }

    @Test
    void serv() {
        fail();
    }

    @Test
    void testToString() {
        fail();
    }
}
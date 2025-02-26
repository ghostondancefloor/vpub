package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CaveTest {

    @Test
    void testAddAndTake() {
        Cave cave = new Cave();
        Boisson boisson = new Boisson("Coca");

        cave.add(boisson);
        assertEquals(1, cave.rayons.size());

        Boisson takenBoisson = cave.take("Coca");
        assertEquals(boisson, takenBoisson);
        assertEquals(0, cave.rayons.size());
    }

    @Test
    void testTakeNonExistent() {
        Cave cave = new Cave();
        Boisson boisson = cave.take("Coca");
        assertNull(boisson);
    }

    @Test
    void testToString() {
        Cave cave = new Cave();
        cave.add(new Boisson("Coca"));
        cave.add(new Boisson("Whisky", 40.0f));

        String eol = System.lineSeparator();
        String expected = "Cave : " + eol + "\tCoca" + eol + "\tWhisky (l'abus d'alcool est dangereux pour la sante)" + eol;
        assertEquals(expected, cave.toString());
    }
}

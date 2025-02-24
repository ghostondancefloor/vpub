package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CaveTest {
    Cave c;
    Boisson a;
    Boisson b;
    Boisson d;
    Boisson e;
    @BeforeEach
    void setUp(){
        c = new Cave();
        a = new Boisson("atay");
        b = new Boisson("vin",12.3f);
        d = new Boisson("vin",1.3f);
        e = new Boisson("9hwa",6.8f);

    }

    @Test
    void add(){
        c.rayons.isEmpty();
        c.add(b);
        assertFalse(c.rayons.isEmpty());
    }

    @Test
    void take1element() {
        c.add(b);
        c.take("vin");
        c.rayons.isEmpty();
    }

    @Test
    void take2elements() {
        c.add(b);
        c.add(a);
        c.take("atay");
        assertEquals(c.rayons.isEmpty(),false);
        assertFalse(c.rayons.isEmpty());

        c.take("vin");
        c.rayons.isEmpty();
    }

    @Test
    void takeElements(){
        List<Boisson> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(d);
        list.add(e);

        c.take("vin");

        assertFalse(list.contains("vin"));
    }

    @Test
    void testToStringSimple() {
        String expected = "Cave : " + System.getProperty("line.separator");
        assertEquals(expected, c.toString());
    }


    @Test
    void testToString() {
        c.add(a);
        c.add(b);
        String expected = "Cave : " + System.getProperty("line.separator")
                + "\tatay" + System.getProperty("line.separator")
                + "\tvin (l'abus d'alcool est dangereux pour la sante)" + System.getProperty("line.separator");
        assertEquals(expected, c.toString());
    }
}
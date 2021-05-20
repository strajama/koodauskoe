/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe1;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author strajama
 */
public class ElamaTest {

    private Elama elama;

    public ElamaTest() {
    }

    @BeforeEach
    public void init() {
        this.elama = new Elama("19052000");
    }

    /**
     * Elämä on elossa ellei ole kuollut ja että kuolla voi vain kerran
     */
    @Test
    public void elossaJaKuole() {
        assertTrue(elama.elossa());
        assertTrue(elama.kuole());
        assertFalse(elama.elossa());
        assertFalse(elama.kuole());
    }

    /**
     * Ikä näkyy vuosina oikein.
     * Muutetaan keinotekoisesti kuolinvuotta, jotta näkyisi, että ikä lasketaan
     * kuolleella kuolinpäivän mukaan
     */
    @Test
    public void ika() {
        assertEquals(21, elama.ika());
        assertTrue(elama.kuole());
        elama.setKuolinpaiva(LocalDate.of(2010, Month.MAY, 20));
        assertEquals(10, elama.ika());
    }
 }

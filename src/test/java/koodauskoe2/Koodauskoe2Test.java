/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;

/**
 * Testataan abstraktin luokan Koodauskoe2 muokkaa-funktion toimivuus
 *
 * @author strajama
 */
public class Koodauskoe2Test {

    public Koodauskoe2Test() {
    }

    /**
     * Testataan muokkaa-funktio, kun syötteenä on 0
     */
    @Test
    public void muokkaaNolla() {
        Koodauskoe2 absCls = Mockito.mock(
                Koodauskoe2.class,
                Mockito.CALLS_REAL_METHODS);

        Assertions.assertEquals(0, absCls.muokkaa(0));
    }

    /**
     * Testataan muokkaa-funktio, kun syötteenä on 1
     */
    @Test
    public void muokkaaYksi() {
        Koodauskoe2 absCls = Mockito.mock(
                Koodauskoe2.class,
                Mockito.CALLS_REAL_METHODS);

        Assertions.assertEquals(0, absCls.muokkaa(1));
    }

    /**
     * Testataan muokkaa funktio, kun syötteenä on 3
     */
    @Test
    public void muokkaaKolme() {
        Koodauskoe2 absCls = Mockito.mock(
                Koodauskoe2.class,
                Mockito.CALLS_REAL_METHODS);

        Assertions.assertEquals(2, absCls.muokkaa(3));
    }
}

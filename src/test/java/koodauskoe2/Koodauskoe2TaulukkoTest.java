/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Testaa luokan Koodauskoe2Taulukko
 *
 * @author strajama
 */
public class Koodauskoe2TaulukkoTest {

    private Koodauskoe2Taulukko koe;

    public Koodauskoe2TaulukkoTest() {

    }

    /**
     * Ennen jokaista testiä luodaan uusi Koodauskoe2Taulukko-olio
     */
    @BeforeEach
    public void init() {
        koe = new Koodauskoe2Taulukko();
    }

    /**
     * Testataan mallina annettu taulukko [1, 4, 10]
     */
    @Test
    public void malliTesti() {
        int[] taulukko = {1, 4, 10};
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan mallitaulukon numerot eri järjestyksessä annettuna
     */
    @Test
    public void numerotEriJarjestyksessa() {
        int[] taulukko = {4, 10, 1};
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan tyhjällä taulukolla
     */
    @Test
    public void tyhjaTaulukko() {
        int[] taulukko = {};
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on vain yksi numero
     */
    @Test
    public void taulukossaYksiNumero() {
        int[] taulukko = {4};
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on kaksi samaa numeroa
     */
    @Test
    public void taulukossaKaksiSamaaNumeroa() {
        int[] taulukko = {1, 4, 4, 10};
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on monta samaa numeroa
     */
    @Test
    public void taulukossaMontaSamaaNumeroa() {
        int[] taulukko = {1, 4, 4, 4, 4, 10};
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa numeroiden välissä on sama ero
     */
    @Test
    public void taulukoidenNumeroidenValissaSamaEro() {
        int[] taulukko = {1, 3, 5};
        Assertions.assertEquals(1, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on mukana negatiivinen numero
     */
    @Test
    public void taulukossaNegatiivinenJaPositiivinenLuku() {
        int[] taulukko = {-1, 3, 10};
        Assertions.assertEquals(3, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on negatiivinen numero ja nolla
     */
    @Test
    public void taulukossaNegatiivinenLukuJaNolla() {
        int[] taulukko = {-3, 0};
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on vain negatiivisia numeroita
     */
    @Test
    public void taulukossaNegatiivisiaLukua() {
        int[] taulukko = {-4, -1, -10};
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on positiivisia ja negatiivisia numeroita ja
     * pienin ero positiivisisten numeroiden välillä
     */
    @Test
    public void taulukossaNegatiivisiaJaPositiivisiaLukujaPositiivinen() {
        int[] taulukko = {10, 12, -4, -1};
        Assertions.assertEquals(1, koe.pieninMaaraNumeroitaValissa(taulukko));
    }

    /**
     * Testataan taulukolla, jossa on positiivisia ja negatiivisia numeroita ja
     * pienin ero negatiivisten numeroiden välillä
     */
    @Test
    public void taulukossaNegatiivisiaJaPositiivisiaLukujaNegatiivinen() {
        int[] taulukko = {10, 19, -4, -1};
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(taulukko));
    }
}

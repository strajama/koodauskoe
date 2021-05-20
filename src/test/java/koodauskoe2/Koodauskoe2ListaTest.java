/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Testaa luokan Koodauskoe2Lista
 *
 * @author strajama
 */
public class Koodauskoe2ListaTest {

    private Koodauskoe2Lista koe;
    private List<Integer> lista;

    public Koodauskoe2ListaTest() {
    }

    /**
     * Ennen jokaista testiä luodaan uusi Koodauskoe2Lista-olio
     */
    @BeforeEach
    public void init() {
        koe = new Koodauskoe2Lista();
        lista = new ArrayList<>();
    }

    /**
     * Testataan mallina annettu taulukko [1, 4, 10]
     */
    @Test
    public void malliTesti() {
        int[] taulukko = {1, 4, 10};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan mallitaulukon numerot eri järjestyksessä annettuna
     */
    @Test
    public void numerotEriJarjestyksessa() {
        int[] taulukko = {10, 1, 4};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan tyhjällä taulukolla
     */
    @Test
    public void tyhjaTaulukko() {
        int[] taulukko = {};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on vain yksi numero
     */
    @Test
    public void taulukossaYksiNumero() {
        int[] taulukko = {4};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on kaksi samaa numeroa
     */
    @Test
    public void taulukossaKaksiSamaaNumeroa() {
        int[] taulukko = {1, 1, 4, 10};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on monta samaa numeroa
     */
    @Test
    public void taulukossaMontaSamaaNumeroa() {
        int[] taulukko = {1, 1, 1, 1, 4, 10};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(0, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa numeroiden välissä on sama ero
     */
    @Test
    public void taulukoidenNumeroidenValissaSamaEro() {
        int[] taulukko = {1, 3, 5};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(1, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on mukana negatiivinen numero
     */
    @Test
    public void taulukossaNegatiivinenJaPositiivinenLuku() {
        int[] taulukko = {-1, 3, 10};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(3, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on negatiivinen numero ja nolla
     */
    @Test
    public void taulukossaNegatiivinenLukuJaNolla() {
        int[] taulukko = {-3, 0};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on vain negatiivisia numeroita
     */
    @Test
    public void taulukossaNegatiivisiaLukua() {
        int[] taulukko = {-4, -1, -10};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on positiivisia ja negatiivisia numeroita ja
     * pienin ero positiivisisten numeroiden välillä
     */
    @Test
    public void taulukossaNegatiivisiaJaPositiivisiaLukujaPositiivinen() {
        int[] taulukko = {10, 12, -4, -1};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(1, koe.pieninMaaraNumeroitaValissa(lista));
    }

    /**
     * Testataan taulukolla, jossa on positiivisia ja negatiivisia numeroita ja
     * pienin ero negatiivisten numeroiden välillä
     */
    @Test
    public void taulukossaNegatiivisiaJaPositiivisiaLukujaNegatiivinen() {
        int[] taulukko = {10, 19, -4, -1};
        for (int i : taulukko) {
            lista.add(i);
        }
        Assertions.assertEquals(2, koe.pieninMaaraNumeroitaValissa(lista));
    }
}

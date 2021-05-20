/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author strajama
 */
public class HenkiloTest {

    private Henkilo henkilo;

    public HenkiloTest() {
    }

    @BeforeEach
    public void init() {
        this.henkilo = new Henkilo("Testi", "19052000");
    }

    /**
     * Henkilölle voi vain kerran lisätä saman henkilön lapseksi, vanhemmaksi
     * tai sisarukseksi.
     */
    @Test
    public void vainYksiSamaLapsiVanhempiSisarus() {
        Henkilo lapsi = new Henkilo("Lapsi", "19052020");
        Henkilo sisarus = new Henkilo("Sisarus", "19052010");
        assertTrue(henkilo.getPerhesuhteet().isEmpty());
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.LAPSI, lapsi));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.LAPSI, lapsi));
        assertFalse(henkilo.getPerhesuhteet().get(Perhe.LAPSI).isEmpty());
        assertTrue(lapsi.lisaaPerhesuhde(Perhe.VANHEMPI, henkilo));
        assertFalse(lapsi.lisaaPerhesuhde(Perhe.VANHEMPI, henkilo));
        assertFalse(lapsi.getPerhesuhteet().get(Perhe.VANHEMPI).isEmpty());
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.SISARUS, sisarus));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.SISARUS, sisarus));
        assertFalse(henkilo.getPerhesuhteet().get(Perhe.SISARUS).isEmpty());
    }

    /**
     * Henkilö ei voi olla itsensä lapsi, vanhempi tai sisarus
     */
    @Test
    public void eiVoiOllaItsensaPerhetta() {
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.LAPSI, henkilo));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.VANHEMPI, henkilo));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.SISARUS, henkilo));
        assertTrue(henkilo.getPerhesuhteet().isEmpty());
    }

    /**
     * Itseä nuorempi henkilö ei voi olla oma vanhempi eikä itseä vanhempi
     * henkilö voi olla oma lapsi. Tämän takia ei voi olla itsensä esivanhempi
     * tai jälkeläinen
     */
    @Test
    public void ikajarjestys() {
        Henkilo nuorempi = new Henkilo("Nuorempi", "19052020");
        Henkilo vanhempi = new Henkilo("Vanhempi", "19051990");
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.LAPSI, vanhempi));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.VANHEMPI, nuorempi));
        assertTrue(henkilo.getPerhesuhteet().isEmpty());
    }

    /**
     * Vanhempien, lasten ja sisarusten lukumäärää ei ole rajoitettu. Henkilö,
     * joka on perhettä, ei voi lisätä enää toiseksi perheenjäseneksi
     */
    @Test
    public void paljonPerhetta() {
        Henkilo eka = new Henkilo("Eka", "19052020");
        Henkilo toka = new Henkilo("Toka", "19052019");
        Henkilo kolmas = new Henkilo("Kolmas", "19051990");
        Henkilo neljas = new Henkilo("Neljäs", "19051980");
        Henkilo viides = new Henkilo("Viides", "19052001");
        Henkilo kuudes = new Henkilo("Kuudes", "19052002");
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.LAPSI, eka));
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.LAPSI, toka));
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.VANHEMPI, kolmas));
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.VANHEMPI, neljas));
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.SISARUS, viides));
        assertTrue(henkilo.lisaaPerhesuhde(Perhe.SISARUS, kuudes));
        assertTrue(henkilo.getPerhesuhteet().get(Perhe.LAPSI).contains(eka));
        assertTrue(henkilo.getPerhesuhteet().get(Perhe.LAPSI).contains(toka));
        assertTrue(henkilo.getPerhesuhteet().get(Perhe.VANHEMPI).contains(kolmas));
        assertTrue(henkilo.getPerhesuhteet().get(Perhe.VANHEMPI).contains(neljas));
        assertTrue(henkilo.getPerhesuhteet().get(Perhe.SISARUS).contains(viides));
        assertTrue(henkilo.getPerhesuhteet().get(Perhe.SISARUS).contains(kuudes));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.SISARUS, eka));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.SISARUS, toka));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.SISARUS, kolmas));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.SISARUS, neljas));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.LAPSI, viides));
        assertFalse(henkilo.lisaaPerhesuhde(Perhe.LAPSI, kuudes));
    }

}

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
public class TarkastajaTest {

    Tarkastaja tarkastaja;

    public TarkastajaTest() {
    }

    @BeforeEach
    public void init() {
        this.tarkastaja = new Tarkastaja();
    }

    /**
     * Tarkastaa annetun henkilötunnuksen
     */
    @Test
    public void tarkastaHetuTarkastaja() {
        assertTrue(tarkastaja.tarkastaHetu("190521A967W"));
        assertTrue(tarkastaja.tarkastaHetu("190521-967W"));
        assertTrue(tarkastaja.tarkastaHetu("190521+967W"));
        assertFalse(tarkastaja.tarkastaHetu("190521AA67W"));
        assertFalse(tarkastaja.tarkastaHetu("190521A967+"));
        assertFalse(tarkastaja.tarkastaHetu("190521L967W"));
        assertFalse(tarkastaja.tarkastaHetu("990521A967W"));
        assertFalse(tarkastaja.tarkastaHetu("191521A967W"));
        assertFalse(tarkastaja.tarkastaHetu("190521A167W"));
    }

    /**
     * Ohjelman toiminnallisuutta
     */
    @Test
    public void toiminnallisuus() {
        /*Henkilöltä kysytään alussa nimi ja henkilötunnus. 
        Tarkastaja tarkastaa, että henkilötunnus on validi ja muodostaa 
        henkilötunnuksesta syntymäajan Henkilo-luokkaa varten.
         */
        String nimi = "Ninni Nimetön";
        String hetu = "190590-988C";
        assertTrue(this.tarkastaja.tarkastaHetu(hetu));
        Henkilo henkilo = new Henkilo(nimi, this.tarkastaja.muotoilePaiva(hetu));
        assertEquals(henkilo.getNimi(), nimi);
        assertEquals(henkilo.getElama().ika(), 31);
        //Lisätään Ninnille yhteystietoja
        String osoite = "Testiosoite on vapaamuotoinen";
        String puhelin = "0401234567";
        String sahkoposti = "testi@testi.fi";
        String websivu = "www.testi.fi";
        henkilo.getYhteystieto().setOsoite(osoite);
        assertEquals(henkilo.getYhteystieto().getOsoite(), osoite);
        assertTrue(henkilo.getYhteystieto().muutaPuhelin(puhelin));
        assertEquals(henkilo.getYhteystieto().getPuhelin(), puhelin);
        assertTrue(henkilo.getYhteystieto().muutaSahkoposti(sahkoposti));
        assertEquals(henkilo.getYhteystieto().getSahkoposti(), sahkoposti);
        assertTrue(henkilo.getYhteystieto().muutaWebsivu(websivu));
        assertEquals(henkilo.getYhteystieto().getWebsivu(), websivu);
    }

}

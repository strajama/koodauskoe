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
public class YhteystietoTest {

    private Yhteystieto yhteystieto;

    public YhteystietoTest() {
    }

    @BeforeEach
    public void init() {
        this.yhteystieto = new Yhteystieto();
    }

    /**
     * MuutaPuhelin tarkastaa, että annettu uusi puhelinnumero alkaa + tai 0 ja
     * sen pituus on 7-12 merkkiä.
     */
    @Test
    public void muutaPuhelin() {
        assertTrue(yhteystieto.muutaPuhelin("0123456"));
        assertTrue(yhteystieto.muutaPuhelin("+123456"));
        assertTrue(yhteystieto.muutaPuhelin("012345678910"));
        assertTrue(yhteystieto.muutaPuhelin("+12345678910"));
        assertFalse(yhteystieto.muutaPuhelin("012345"));
        assertFalse(yhteystieto.muutaPuhelin("1123456"));
        assertFalse(yhteystieto.muutaPuhelin("0123456789101"));
        assertFalse(yhteystieto.muutaPuhelin("+12345A78910"));
        assertFalse(yhteystieto.muutaPuhelin(""));
    }

    /**
     * MuutaWebsivu tarkastaa, että annettu uusi websivu on validi
     * websivu-osoite, joita ihmiset copy-pastettavat selaimen osoiteriviltä.
     */
    @Test
    public void muutaWebsivu() {
        assertFalse(yhteystieto.muutaWebsivu(""));
        assertFalse(yhteystieto.muutaWebsivu("a"));
        assertFalse(yhteystieto.muutaWebsivu("aaaaa."));
        assertFalse(yhteystieto.muutaWebsivu("aaaaa.a"));
        assertFalse(yhteystieto.muutaWebsivu(".a"));
        assertFalse(yhteystieto.muutaWebsivu("aaaaa.1234567890123456789012345678901234567890123456789012345678901234"));
        assertFalse(yhteystieto.muutaWebsivu("http://localhost:8080/"));
        assertTrue(yhteystieto.muutaWebsivu("cgi.fi"));
        assertTrue(yhteystieto.muutaWebsivu("www.cgi.fi"));
        assertTrue(yhteystieto.muutaWebsivu("http://cgi.fi"));
        assertTrue(yhteystieto.muutaWebsivu("https://cgi.fi"));
        assertTrue(yhteystieto.muutaWebsivu("http://www.cgi.fi"));
        assertTrue(yhteystieto.muutaWebsivu("https://www.cgi.fi"));
        assertTrue(yhteystieto.muutaWebsivu("http://c2.com/cgi/wiki?DomainObject"));
        assertTrue(yhteystieto.muutaWebsivu("https://github.com/strajama"));
        assertTrue(yhteystieto.muutaWebsivu("https://outlook.office.com/mail/inbox/id/AQMkAGY1NmI1YWJhLTMxZTEtNDM2ZS1iODA3LTRmODJiODE2OWJlZABGAAAD5QKeFq5Ib0qZUhMwmMivpwcAqXjfLu1Lk0OJcbeJyFRIfwAAAgEMAAAAqXjfLu1Lk0OJcbeJyFRIfwADiuxBUQAAAA%3D%3D"));
        assertTrue(yhteystieto.muutaWebsivu("https://twitter.com/CGI_Global?ref_src=twsrc%5Etfw&ref_url=https%3A%2F%2Fwww.cgi.com%2Ffi%2Ffi%2Fvaltio"));
    }

    /**
     * MuutaSahkopostiToimii tarkastaa, että validi sähköposti hyväksytään.
     * Testitapauksissa on käytetty Wikipedian esimerkki-listaa
     * https://en.wikipedia.org/wiki/Email_address
     */
    @Test
    public void muutaSahkopostiToimii() {
        assertTrue(yhteystieto.muutaSahkoposti("simple@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("very.common@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("disposable.style.email.with+symbol@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("ther.email-with-hyphen@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("fully-qualified-domain@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("user.name+tag+sorting@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("x@example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("example-indeed@strange-example.com"));
        assertTrue(yhteystieto.muutaSahkoposti("test/test@test.com"));
        assertTrue(yhteystieto.muutaSahkoposti("admin@mailserver1"));
        assertTrue(yhteystieto.muutaSahkoposti("example@s.example"));
        assertTrue(yhteystieto.muutaSahkoposti("\" \"@example.org"));
        assertTrue(yhteystieto.muutaSahkoposti("\"john..doe\"@example.org"));
        assertTrue(yhteystieto.muutaSahkoposti("mailhost!username@example.org"));
        assertTrue(yhteystieto.muutaSahkoposti("user%example.com@example.org"));
        assertTrue(yhteystieto.muutaSahkoposti("user-@example.org"));
    }

    /**
     * MuutaSahkopostiEiToimi tarkastaa, että ei-validit sähköpostit hylätään.
     * Testitapauksissa on käytetty Wikipedian esimerkki-listaa
     * https://en.wikipedia.org/wiki/Email_address
     */
    @Test
    public void muutaSahkopostiEiToimi() {
        assertFalse(yhteystieto.muutaSahkoposti("Abc.example.com"));
        assertFalse(yhteystieto.muutaSahkoposti("A@b@c@example.com"));
        assertFalse(yhteystieto.muutaSahkoposti("a\"b(c)d,e:f;g<h>i[j\\k]l@example.com"));
        //assertFalse(yhteystieto.muutaSahkoposti("just\"not\"right@e[^\\.]xample.com"));
        assertFalse(yhteystieto.muutaSahkoposti("this is\"not\\allowed@example.com"));
        assertFalse(yhteystieto.muutaSahkoposti("this\\ still\\\"not\\\\allowed@example.com"));
        assertFalse(yhteystieto.muutaSahkoposti("1234567890123456789012345678901234567890123456789012345678901234+x@example.com"));
        assertFalse(yhteystieto.muutaSahkoposti("i_like_underscore@but_its_not_allowed_in_this_part.example.com"));
        assertFalse(yhteystieto.muutaSahkoposti("QA[icon]CHOCOLATE[icon]@test.com"));
    }

}

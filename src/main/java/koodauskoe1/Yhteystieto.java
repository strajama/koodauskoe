/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Yhteystieto-luokka ylläpitää yhteystietoja.
 * 
 * @author strajama
 */
class Yhteystieto {

    private String websivu;
    private String sahkoposti;
    private String puhelin;
    private String osoite;

    public Yhteystieto() {
    }

    /**
     * Muuttaa puhelinnumeron, jos annettu uusi puhelinnumero on validi
     * @param puhelin
     * @return true, jos puhelinnumeron vaihtaminen onnistuu
     */
    public boolean muutaPuhelin(String puhelin) {
        Pattern malli = Pattern.compile("^(\\+|0)\\d{6,11}");
        Matcher tarkistus = malli.matcher(puhelin);
        if (tarkistus.matches()) {
            this.puhelin = puhelin;
            return true;
        }
        return false;
    }

    /**
     * Muuttaa websivun, jos annettu uusi websivu on validi.
     * @param websivu
     * @return true, jos websivun vaihtaminen onnistuu
     */
    public boolean muutaWebsivu(String websivu) {
        Pattern malli = Pattern.compile("^(http://|https://)?(www.)?\\w+.\\w*[.][a-zA-Z]{2,63}($|[/]\\S*)");
        Matcher tarkistus = malli.matcher(websivu);
        if (tarkistus.matches()) {
            this.websivu = websivu;
            return true;
        }
        return false;
    }

    /**
     * Muuttaa sähköpostiosoitteen, jos annettu uusi puhelinnumero on validi.
     * @param sahkoposti
     * @return true, jos sähköpostiosoitteen vaihtaminen onnistuu
     */
    public boolean muutaSahkoposti(String sahkoposti) {
        Pattern malli = Pattern.compile("^((\\w|\\.|!|#|\\$|%|&|'|\\*|\\+|\\-|\\/|=|\\?|\\^|\\_|`|\\{|\\||\\}|~|\".*\"){0,64})"
                + "(@)(([0-9]|[a-zA-Z]|\\.|-){1,255})$");
        Matcher tarkistus = malli.matcher(sahkoposti);
        if (tarkistus.matches()) {
            this.sahkoposti = sahkoposti;
            return true;
        }
        return false;
    }

    public String getWebsivu() {
        return websivu;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

    public String getPuhelin() {
        return puhelin;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

}

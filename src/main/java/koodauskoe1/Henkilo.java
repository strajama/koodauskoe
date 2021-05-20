/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe1;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * Henkilo-luokka ylläpitää luonnollisen henkilön perustietoja ja tietoa
 * perheenjäsenistä.
 *
 * @author strajama
 */
public class Henkilo {

    private String nimi;
    private Yhteystieto yhteystieto;
    private Elama elama;
    private EnumMap<Perhe, List<Henkilo>> perhesuhteet;

    public Henkilo(String nimi, String syntymapaiva) {
        this.nimi = nimi;
        this.yhteystieto = new Yhteystieto();
        this.elama = new Elama(syntymapaiva);
        this.perhesuhteet = new EnumMap<>(Perhe.class);
    }

    /**
     * Lisää perhesuhteen henkilölle
     *
     * @param perhe
     * @param henkilo
     * @return true, jos perhesuhteen lisäys onnistuu
     */
    public boolean lisaaPerhesuhde(Perhe perhe, Henkilo henkilo) {
        if (this.equals(henkilo)) {
            return false;
        }
        if (onkoPerhetta(henkilo)) {
            return false;
        }
        if (perhe.ikavertailu(henkilo.elama.ika(), this.elama.ika())) {
            return false;
        }
        if (!this.perhesuhteet.containsKey(perhe)) {
            this.perhesuhteet.put(perhe, new ArrayList<>());
        }
        this.perhesuhteet.get(perhe).add(henkilo);

        return true;
    }

    /**
     * Apufunktio varmistamaan, että samoja henkilöitä ei lisätä monta kertaa
     * perheenjäseniksi
     *
     * @param henkilo
     * @return true, jos henkilö kuuluu ennestään perheeseen
     */
    private boolean onkoPerhetta(Henkilo henkilo) {
        for (Perhe p : Perhe.values()) {
            if (this.perhesuhteet.containsKey(p)) {
                if (this.perhesuhteet.get(p).contains(henkilo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getNimi() {
        return nimi;
    }

    public Yhteystieto getYhteystieto() {
        return yhteystieto;
    }

    public Elama getElama() {
        return elama;
    }

    public EnumMap<Perhe, List<Henkilo>> getPerhesuhteet() {
        return perhesuhteet;
    }

}

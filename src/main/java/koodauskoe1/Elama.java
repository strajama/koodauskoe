package koodauskoe1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Elama-luokassa on tiedot henkilön elämästä: syntymästä ja kuolemasta
 *
 * @author strajama
 */
public class Elama {

    private final LocalDate syntymapaiva;
    private LocalDate kuolinpaiva;

    public Elama(String syntymapaiva) {
        DateTimeFormatter muoto = DateTimeFormatter.ofPattern("ddMMyyyy");
        this.syntymapaiva = LocalDate.parse(syntymapaiva, muoto);
    }

    /**
     * Kertoo iän vuosissa tällä tai kuolinhetkellä.
     *
     * @return ikä vuosissa
     */
    public int ika() {
        if (!elossa()) {
            return Period.between(this.syntymapaiva, this.kuolinpaiva).getYears();
        }
        return Period.between(this.syntymapaiva, LocalDate.now()).getYears();
    }

    /**
     * Kertoo onko elossa
     *
     * @return true, jos henkilö on elossa
     */
    public boolean elossa() {
        return this.kuolinpaiva == null;
    }

    /**
     * Lopettaa elämän ja määrittelee kuolinpäivän
     *
     * @return true, jos ei ole jo kuollutTappaa
     */
    public boolean kuole() {
        if (elossa()) {
            this.kuolinpaiva = LocalDate.now();
            return true;
        }
        return false;
    }

    /**
     * Tavallinen setteri testausta varten
     *
     * @param kuolinpaiva
     */
    public void setKuolinpaiva(LocalDate kuolinpaiva) {
        this.kuolinpaiva = kuolinpaiva;
    }

}

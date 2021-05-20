/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

/**
 * Abstrakti luokka Koodauskoe2, jotta muokkaa-funktiota ei tarvitsisi toteuttaa monta kertaa
 * 
 * @author strajama
 */
public abstract class Koodauskoe2 <T> {

    public Koodauskoe2() {
    }

    public abstract int pieninMaaraNumeroitaValissa(T t);

    /**
     * Muokkaa erotuksen luonnollisten numeroiden väliin jäävien numeroiden
     * määräksi
     *
     * @param luku
     * @return numero
     */
    public int muokkaa(int luku) {
        if (luku == 1 || luku == 0) {
            return 0;
        }
        return luku - 1;
    }

}

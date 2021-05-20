/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

import java.util.Arrays;

/**
 * Toteuttaa abstraktin luokan Koodauskoe2 ja on tehtävänannossa pyydetty
 * versio, jonka funktiolle annetaan syötteenä taulukko.
 *
 * @author strajama
 */
public class Koodauskoe2Taulukko extends Koodauskoe2<int[]> {

    /**
     * Selvittää pienimmän määrän numeroita mitä luonnollisessa järjestyksessä
     * mahtuu taulukon eri numeroiden välille.
     *
     * @param taulukko luonnollisia numeroita
     * @return pienin määrä numeroita välissä
     */
    @Override
    public int pieninMaaraNumeroitaValissa(int[] taulukko) {

        int pienin = 0;
        if (taulukko.length == 0 || taulukko.length == 1) {
            return pienin;
        }
        Arrays.sort(taulukko);
        pienin = taulukko[1] - taulukko[0];

        for (int i = 1; i < taulukko.length; i++) {
            int erotus = taulukko[i] - taulukko[i - 1];
            if (erotus < pienin) {
                pienin = erotus;
            }
        }
        return muokkaa(pienin);
    }

}

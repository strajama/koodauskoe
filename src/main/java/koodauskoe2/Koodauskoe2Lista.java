/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

import java.util.Collections;
import java.util.List;

/**
 * Toteuttaa abstraktin luokan Koodauskoe2 ja on käyttöliittymää varten versio,
 * jonka funktiolle annetaan syötteenä lista.
 *
 * @author strajama
 */
public class Koodauskoe2Lista extends Koodauskoe2<List<Integer>> {

    /**
     * Selvittää pienimmän määrän numeroita mitä luonnollisessa järjestyksessä
     * mahtuu listan eri numeroiden välille.
     *
     * @param lista luonnollisia numeroita
     * @return pienin määrä numeroita välissä
     */
    @Override
    public int pieninMaaraNumeroitaValissa(List<Integer> lista) {

        int pienin = 0;
        if (lista.isEmpty() || lista.size() == 1) {
            return pienin;
        }
        Collections.sort(lista);
        pienin = lista.get(1) - lista.get(0);

        for (int i = 2; i < lista.size(); i++) {
            int erotus = lista.get(i) - lista.get(i - 1);
            if (erotus < pienin) {
                pienin = erotus;
            }
        }
        return muokkaa(pienin);
    }
}

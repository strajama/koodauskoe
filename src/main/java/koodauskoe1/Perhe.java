/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe1;

/**
 * Enum perhesuhteille ettei heidän nimiä ja vertailuja tarvitsisi kovakoodata muualle
 *
 * @author strajama
 */
public enum Perhe {

    LAPSI {
        @Override
        public boolean ikavertailu(int eka, int toka) {
            return eka >= toka;
        }
    },
    SISARUS,
    VANHEMPI {
        @Override
        public boolean ikavertailu(int eka, int toka) {
            return eka <= toka;
        }
    };
/**
 * Ikävertailulla katsotaan onko kahden mahdollisen perheenjäsenen iät väärin päin.
 * 
 * @param eka
 * @param toka
 * @return oletuksena false
 */
    public boolean ikavertailu(int eka, int toka) {
        return false;
    }
}

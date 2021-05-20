/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.GenericValidator;

/**
 * Tarkastaja on henkilötunnuksen tarkastamiseen ja syntymäpäivän muotoiluun. 
 * Tarkastajan testiluokassa on koottu yhteen toiminnallisuuksia.
 * @author strajama
 */
public class Tarkastaja {

    public Tarkastaja() {
    }
    
    public boolean tarkastaHetu (String hetu) {
        Pattern malli = Pattern.compile("([0-9]{6})(\\-|[A]|\\+)([0-9]{3})([0-9]|[A-Z])");
        Matcher tarkistus = malli.matcher(hetu);

        if (!tarkistus.matches()) {
            return false;
        }        
        if (!tarkastaPaiva(muotoilePaiva(hetu))) {
            return false;
        }
        return tarkastaTarkistusmerkki(hetu);
    }
    
    /**
     * Muotoilee hetussa olevan tiedon syntymäpäiväksi, joka on muotoa ddMMyyyy
     * 
     * @param hetu
     * @return syntymäpäivä 8-merkkisenä Stringinä
     */
    public String muotoilePaiva (String hetu) {
        StringBuilder rakentaja = new StringBuilder();
        rakentaja.append(hetu.substring(0, 4));      
        switch (hetu.charAt(6)) {
            case '+':
                rakentaja.append("18");
                break;
            case '-':
                rakentaja.append("19");
                break;
            case 'A':
                rakentaja.append("20");
                break;
            default:
                break;
        }        
        return rakentaja.append(hetu.substring(4, 6)).toString();
    }
    
    /**
     * Apufunktio tarkastamaan, että annettu päivä on validi päivämäärä
     * 
     * @param paiva muodossa ddMMyyyy
     * @return true, jos päivä on validi
     */
    private boolean tarkastaPaiva (String paiva) {
        return GenericValidator.isDate(paiva, "ddMMyyyy", true);
    }
    
    /**
     * Apufunktio tarkastamaan hetun tarkistusmerkin
     * @param hetu
     * @return true, jos tarkistusmerkki on validi
     */
    private boolean tarkastaTarkistusmerkki (String hetu) {
        StringBuilder rakentaja = new StringBuilder(hetu);
        rakentaja.deleteCharAt(10);
        rakentaja.deleteCharAt(6);
        int luku = Integer.valueOf(rakentaja.toString());
        int jaannos = luku % 31;
        char[] tarkastusmerkit = {'0','1','2','3','4','5','6','7','8', '9',
            'A','B','C','D','E','F','H','J','K','L','M','N','P','R','S','T',
            'U','V','W','X','Z'};
        return hetu.charAt(10) == tarkastusmerkit[jaannos];
    }
    
}

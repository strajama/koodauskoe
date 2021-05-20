/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koodauskoe2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Yksinkertainen käyttöliittymä
 * 
 * @author strajama
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        Koodauskoe2Lista koodauskoe2 = new Koodauskoe2Lista();
        ArrayList<Integer> lista = new ArrayList();
        Pattern kokonaislukumalli = Pattern.compile("-?\\d+");

        while (true) {
            System.out.println("Anna kokonaisluku. Kun haluat lopettaa, anna jokin muu merkki ");
            String syote = lukija.nextLine();
            if (kokonaislukumalli.matcher(syote).matches()) {
                int numero = Integer.parseInt(syote);
                lista.add(numero);
            } else {
                break;
            }
        }
        System.out.println("Annoit kokonaisluvut: ");
        lista.forEach((luku) -> {
            System.out.println(luku);
        });
        System.out.println("Pienin määrä numeroita, joka mahtuu luonnollisessa "
                + "järjestyksessä joukon numeroiden väliin on " + koodauskoe2.pieninMaaraNumeroitaValissa(lista));

        {

        }
    }
}

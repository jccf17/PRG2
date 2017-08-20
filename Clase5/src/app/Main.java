package app;

import encarta.Traductor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        Traductor t1 = new Traductor();
        String p = "", t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("BIENVENIDO A ENCARTA 2017");
        t1.mostrar();
        System.out.print("PALABRA A TRADUCIR: ");
        try {
            p = br.readLine();
        } catch (Exception e) {
            System.out.println("NO VAS");
            System.exit(-1);
        }
        t = t1.traducir(p);
        if (!t.equals("Palabra no encontrada")) {
            System.out.println("En ingles, " + p + " se dice " + t);
        } else {
            System.out.println(t);
        }
    }
}

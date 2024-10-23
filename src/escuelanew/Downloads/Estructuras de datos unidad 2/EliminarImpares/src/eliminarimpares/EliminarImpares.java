/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminarimpares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class EliminarImpares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 9.	Eliminar elementos impares de un arreglo de números enteros.
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> listaEnteros = new ArrayList<>();
        String respuesta;
        do {
            System.out.println("Quieres ingresar números al array(si/no)");
            respuesta = in.nextLine();
            if (respuesta.equalsIgnoreCase("si")) {
                System.out.println("Ingresa el valor ");
                int num = in.nextInt();
                listaEnteros.add(num);
                in.nextLine();
            }

        } while (respuesta.equalsIgnoreCase("si"));

        Iterator<Integer> iterador = listaEnteros.iterator();
        while (iterador.hasNext()) {
            int num = iterador.next();
            if (num % 2 != 0) {
                iterador.remove(); // elimina el elemento si es impar
            }

        }
        System.out.println("Lista actualizada " + listaEnteros);

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class EscribirTXT {

    //Método el cual crea un fichero txt a partir de una lista y una ruta
    public void generarFicheroTxt(ArrayList<App> lista, String idFichero) {

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (App app : lista) {
                flujo.write(app.toString());
                flujo.newLine();
            }
            //Llamada -explicita- para que se guarde lo que se llama en el disco
            //Sin flush funciona pero se recomienda.
            flujo.flush();

            System.out.println("El fichero " + idFichero + " se ha creado correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void generarFicheroTxtIndividual(App app, String idFichero) {

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            flujo.write(app.toString());
            flujo.newLine();

            //Llamada -explicita- para que se guarde lo que se llama en el disco
            //Sin flush funciona pero se recomienda.
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}

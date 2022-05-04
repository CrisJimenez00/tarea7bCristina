/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Cris
 */
public class Prueba {

    //Método el cual rellena una lista de apps aleatorias y devuelve la lista
    public static ArrayList<App> rellenarArray() {
        ArrayList<App> lista = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            App p1 = new App();
            lista.add(p1);
        }
        return lista;
    }

    //Método de clase el cual crea un archivo pasándole la dirección donde se quiere ubicar-
    public static void crearDirectorio(String ruta) {

        //Esto hace que se indique la ruta donde se quiere ubicar
        Path directory = Paths.get(ruta);

        //try/catch para controlar posibles excepciones
        try {
            //Crea el directorio
            Files.createDirectory(directory);

            //Si ya existe sale esta excepción
        } catch (FileAlreadyExistsException faee) {

            //Lo cual hace que salga un mensaje específico
            System.out.println("No se puede crear " + ruta + " porque ya existe");

            //Si el usuario no tiene permisos para crear archivos en el ordenador
            //(lo pongo para usos futuros o pruebas)
        } catch (AccessDeniedException ade) {

            System.out.println("No tiene permisos para crear " + ruta);

            //Si la ruta está mal escrita o si hay algún problem creando el directorio
        } catch (IOException ioe) {

            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");

        }

    }

    public static void main(String[] args) throws IOException, JAXBException {

        //Añadimos los directorios(Si no, nos da error en la ruta)
        crearDirectorio("appstxt");
        crearDirectorio("appsxml");
        crearDirectorio("appsjson");
        crearDirectorio("copia");
        crearDirectorio("aplicaciones");

        ArrayList<App> listaApp = rellenarArray();
        for (App app : listaApp) {
            System.out.println(app.toString());
        }

        //Creamos el fichero con el metodo de otra clase(Creada anteriormente).
        //pasamos lista y la ruta que queremos y lo genera
        EscribirTXT ficheroTXT = new EscribirTXT();
        ficheroTXT.generarFicheroTxt(listaApp, "./appstxt/aplicaciones.txt");
        ficheroTXT.generarFicheroTxt(listaApp, "./copia/aplicaciones.txt");
        for (int i = 0; i < listaApp.size(); i++) {
            ficheroTXT.generarFicheroTxtIndividual(listaApp.get(i), "./aplicaciones/" + listaApp.get(i).getNombre() + ".txt");
        }

        //Creamos el archivo en xml
        //pasamos lista y la ruta que queremos y lo genera
        EscribirXML generarFicheroXML = new EscribirXML();
        System.out.println("\n\n-----ESTO ESE VOLCA EN EL XML-------");
        generarFicheroXML.generarFicheroXML(listaApp, "./appsxml/aplicaciones.xml");
        System.out.println("\n\n-------ESTO SE VOLVA EN EL FICHERO XML DE COPIA------");
        generarFicheroXML.generarFicheroXML(listaApp, "./copia/aplicaciones.xml");

        //Creamos los fichero JSON individualmente de cada tipo de app
        //pasamos lista y la ruta que queremos y lo genera
        EscribirJSON ficheroJSON = new EscribirJSON();
        ficheroJSON.generarFicheroJSON(listaApp, "./appsjson/aplicaciones.json");
        ficheroJSON.generarFicheroJSON(listaApp, "./copia/aplicaciones.json");

        System.out.println("\n\n--------FICHERO JSON LECTURA---------");
        ficheroJSON.leerFicheroJSON("./appsjson/aplicaciones.json");
    }

}

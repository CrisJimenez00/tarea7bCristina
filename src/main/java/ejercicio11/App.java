/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11;

import java.util.Random;

/**
 *
 * @author Cris
 */
public class App {

    //Atributos
    private int codigo;
    private String nombre;
    private String descripcion;
    private double tamanio;
    private int numDescargas;

    //Atributos necesarios para construir
    private static Random random = new Random();
    private static int contadorApps = 1;

    //Constructor por defecto
    public App() {
        this.codigo = contadorApps;
        this.nombre = generarNombre();
        this.descripcion = descripcion();
        this.tamanio = generarTamanio();
        this.numDescargas = generaNumDescargas();
        contadorApps++;
    }

    //Constructor parametrizado
    public App(int codigo, String nombre, String descripcion, double tamanio, int numDescargas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.numDescargas = generaNumDescargas();
        contadorApps++;
    }

    //Genera tamaño aleatoria entre 100 y 1024 y lo pasa a double
    private static double generarTamanio() {
        final double MIN = 100.0;
        final double MAX = 1024.0;
        return random.doubles(1, MIN, MAX).findFirst().getAsDouble();
    }

    //Genera el nombre como se indica("app"+ condUnico + letra(a-z))
    private static String generarNombre() {
        char letra = (char) (random.nextInt(122 - 97 + 1) + 97);
        return "app" + contadorApps + letra;
    }

    //Crea 10 descripciones aleatorio y me devuelve 1.
    private static String descripcion() {
        int numero = random.nextInt(10) + 1;
        String texto = "";
        switch (numero) {
            case 1:
                texto = "Recetario";
                break;
            case 2:
                texto = "Classroom";
                break;
            case 3:
                texto = "Spotify";
                break;
            case 4:
                texto = "Youtube";
                break;
            case 5:
                texto = "Netflix";
                break;
            case 6:
                texto = "Meet";
                break;
            case 7:
                texto = "Amazon Prime Video";
                break;
            case 8:
                texto = "HBO España";
                break;
            case 9:
                texto = "Juego de snake";
                break;
            case 10:
                texto = "Monopoly";
                break;
        }
        return texto;
    }

    //Crea un numero aleatorio entre 0 y 50.000 y lo pasa a int
    private static int generaNumDescargas() {
        final int MIN = 0;
        final int MAX = 50000;
        return random.ints(1, MIN, MAX).findFirst().getAsInt();
    }

    //Getters y setters
    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + descripcion + ";" + tamanio + ";" + numDescargas;
    }

}

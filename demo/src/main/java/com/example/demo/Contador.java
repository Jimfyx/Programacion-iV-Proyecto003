package com.example.demo;

public class Contador {
    private final int[] contador = new int[10];

    public void catalogar(int numero) {
        int indice = (numero - 1) / 10;
        if (indice >= 0 && indice < contador.length) {
            contador[indice]++;
        }
    }

    public void mostrar() {
        for (int i = 0; i < contador.length; i++) {
            int rang_inicio = i * 10 + 1;
            int rang_fin = rang_inicio + 9;
            System.out.println("En el rango: " + rang_inicio + " - " + rang_fin + " hay: " + contador[i] + " numeros.");
        }
    }
}

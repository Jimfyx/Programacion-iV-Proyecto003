package com.example.demo;

import java.util.List;

public class Consumidor implements Runnable {
    private final List<Integer> cola;
    private final Contador contador;

    public Consumidor(List<Integer> cola, Contador contador) {
        this.cola = cola;
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero;
                synchronized (cola) {
                    while (cola.isEmpty()) {
                        cola.wait();
                    }
                    numero = cola.remove(0);
                    cola.notifyAll();
                }
                if (numero == -1){
                    break;
                }
                contador.catalogar(numero);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

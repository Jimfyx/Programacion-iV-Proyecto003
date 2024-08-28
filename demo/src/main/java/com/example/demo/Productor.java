package com.example.demo;

import java.util.List;
import java.util.Random;

public class Productor implements Runnable {
    private final List<Integer> cola;

    public Productor(List<Integer> cola) {
        this.cola = cola;
    }
    @Override
    public void run() {
        Random random = new Random();

        try {
            for (int i = 0; i < 1000; i++) {
                synchronized (cola) {
                    while (cola.size() == 1000) {
                        cola.wait();
                    }
                    int num = random.nextInt(100) + 1;
                    cola.add(num);
                    cola.notifyAll();
                }
            }
            synchronized (cola) {
                cola.add(-1);
                cola.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

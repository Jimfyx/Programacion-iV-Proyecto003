package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);

        List<Integer> cola = new ArrayList<>();
        Contador contador = new Contador();

        Thread productor = new Thread(new Productor(cola));
        Thread consumidor = new Thread(new Consumidor(cola, contador));

        productor.start();
        consumidor.start();

        productor.join();
        consumidor.join();


        contador.mostrar();
        System.out.println(cola.size());
    }
}
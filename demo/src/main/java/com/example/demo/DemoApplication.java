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

        Thread productor = new Thread(new Productor(cola));

        productor.start();

        productor.join();

        System.out.println(cola.size());
    }
}
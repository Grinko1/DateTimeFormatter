package ru.practice.itkacademy.itkacademy.concuretBlockingQueue;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

    ExecutorService poolProducer = Executors.newFixedThreadPool(7);
    ExecutorService poolConsumer = Executors.newFixedThreadPool(7);


        try {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            poolProducer.submit(() -> {
                    queue.enqueue(finalI);
                    System.out.println("Производитель добавил: " + finalI);
            });
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            poolConsumer.submit(() -> {
                     queue.dequeue();
                    System.out.println("Потребитель извлек: " + finalI);
            });
        }

    } finally {
        poolProducer.shutdown();
        poolConsumer.shutdown();
    }
    }
}

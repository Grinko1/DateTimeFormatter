package ru.practice.itkacademy.itkacademy.сomplexTaskExecutor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComplexTaskExecutor {
    private final CyclicBarrier barrier;
    private final ExecutorService executor;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.barrier = new CyclicBarrier(numberOfTasks, () -> {
            System.out.println("All tasks completed.");
        });

        this.executor = Executors.newFixedThreadPool(numberOfTasks);
    }

    public void executeTasks(int numberOfTasks) {
        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                ComplexTask task = new ComplexTask();
                task.execute();

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}

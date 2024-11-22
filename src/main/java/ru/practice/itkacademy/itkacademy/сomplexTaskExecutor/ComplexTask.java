package ru.practice.itkacademy.itkacademy.сomplexTaskExecutor;

import java.util.UUID;

public class ComplexTask {
    private final UUID id;

    public ComplexTask() {
        id = UUID.randomUUID();
    }

    public void execute() {
        countLotsOfEl();
    }

    private void countLotsOfEl(){
        long res =0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 10000; j++) {
                res = res +  (long) i * (j + 1) /2;
            }

        }
    }
}

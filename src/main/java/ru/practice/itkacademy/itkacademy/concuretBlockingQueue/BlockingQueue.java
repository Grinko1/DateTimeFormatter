package ru.practice.itkacademy.itkacademy.concuretBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private int size;
    private Queue<T> queue;

    public BlockingQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }
    public synchronized void enqueue(T item) {
        while (queue.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(item);
        notifyAll();
    }


    public synchronized T dequeue() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        T queueNew = queue.remove();
        notifyAll();
        return queueNew;
    }

    public synchronized int size() {
        return queue.size();
    }
}

package ru.practice.itkacademy.itkacademy.concurrentBank;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
public class BankAccount {
    private final UUID id;

    private BigDecimal balance;
    private Lock lock = new ReentrantLock();

    public BankAccount(BigDecimal balance) {
        this.id = UUID.randomUUID();
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        try {
            lock.lock();
            balance = balance.add(amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) throws Exception {
        lock.lock();
        try {
            if (balance.compareTo(amount) <= 0) {
                throw new Exception("Insufficient funds");
            }
            balance = balance.subtract(amount);
        } finally {
            lock.unlock();
        }
    }
}

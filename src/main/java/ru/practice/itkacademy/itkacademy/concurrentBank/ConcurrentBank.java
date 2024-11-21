package ru.practice.itkacademy.itkacademy.concurrentBank;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentBank {
    private final ConcurrentHashMap<UUID, BankAccount> accounts = new ConcurrentHashMap<>();

    public BankAccount createAccount(int balance) {
        BankAccount newAccount = new BankAccount(BigDecimal.valueOf(balance));
        accounts.put(newAccount.getId(), newAccount);
        return newAccount;
    }
    public void transfer(BankAccount from, BankAccount to, int amount){
        from.getLock().lock();
        try {
            to.getLock().lock();
            try {
                from.withdraw(BigDecimal.valueOf(amount));
                to.deposit(BigDecimal.valueOf(amount));
                System.out.println("Transfer successful: " + amount);
            } catch (Exception e) {
                System.out.println("Transfer failed: " + e.getMessage());
            } finally {
                to.getLock().unlock();
            }
        } finally {
            from.getLock().unlock();
        }

    }
    public BigDecimal getTotalBalance() {
        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount account : accounts.values()) {
          total=  total.add(account.getBalance());
        }
        return total;
    }
}

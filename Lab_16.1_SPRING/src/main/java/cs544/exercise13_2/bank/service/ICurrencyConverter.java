package cs544.exercise13_2.bank.service;

import org.springframework.stereotype.Component;


public interface ICurrencyConverter {
    public double euroToDollars (double amount);
    public double dollarsToEuros (double amount);
}

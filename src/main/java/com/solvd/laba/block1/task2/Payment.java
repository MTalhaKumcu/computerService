package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Exceptions.PaymentValidationException;

import java.util.Scanner;

public class Payment {
    private ComputerInfo computerInfo;
    private Invoice invoice;
    private double amount;
    private Scanner scan;
    private ServiceInfo serviceInfo;
    ComputerProblem computer = new ComputerProblem();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment(double repairCost, String diagnosis) {
        System.out.println("yauv bu sakkadir");
        invoice.setAmount(computer.getRepaireCost(String.valueOf(repairCost)));
        System.out.println(serviceInfo);
    }

    public int paymentOption() {
        System.out.println(Invoice.getBill());
        System.out.println("Welcome to our payment department. Please chose a method to make payment.");
        System.out.println("1-Cash \n2-Credit Card");
        int paymentOption = this.scan.nextInt();
        switch (paymentOption) {
            case 1:
                System.out.println("Please pay amount by cash: "
                        + this.amount);
                break;
            case 2:
                System.out.println("Please pay amount by card: "
                        + this.amount);
                break;
            default:
                throw new PaymentValidationException("Invalid payment option.");
        }
        return paymentOption;
    }
}

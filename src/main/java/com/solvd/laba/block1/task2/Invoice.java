package com.solvd.laba.block1.task2;

public class Invoice {
    private String serviceInfo;
    private String currency;
    private double amount;
    public static Invoice invoice;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static Invoice getInvoice() {
        return invoice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public static void setInvoice(double cost, String address, String currency) {
        invoice = new Invoice();


        invoice.amount = cost;
        invoice.currency = currency;
        invoice.serviceInfo = address;
    }

    public static String getBill() {
        return "Your invoice = " + invoice.amount
                + invoice.serviceInfo
                + invoice.currency;
    }
}

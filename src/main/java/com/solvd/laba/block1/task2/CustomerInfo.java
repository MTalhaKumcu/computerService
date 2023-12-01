package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Exceptions.CustomerValidationException;
import com.solvd.laba.block1.task2.Interfaces.ICustomerInfo;

import java.util.HashSet;
import java.util.Scanner;

public class CustomerInfo implements ICustomerInfo {
    private String customerName;
    private String customerNumber;
    private String customerEmail;

    private HashSet<QueueTicket> tickets;

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public void addTicket(QueueTicket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(QueueTicket ticket) {
        tickets.remove(ticket);
    }

    public CustomerInfo(String customerName, String customerNumber, String customerEmail) {
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    private static final int MAX_TRIES = 3;
    public static class ConsoleHelper {
        private static final Scanner scanner = new Scanner(System.in);

        public static String readLine() {
            return scanner.next();
        }
    }

    public static CustomerInfo getCustomerInput() {
        String name = "";
        String email = "";
        String phoneNumber = "";
        int remainingNameTries = MAX_TRIES;
        int remainingEmailTries = MAX_TRIES;
        int remainingPhoneNumberTries = MAX_TRIES;

        while (remainingNameTries >= 1 || remainingEmailTries >= 1 || remainingPhoneNumberTries >= 1) {

            try {
                if (remainingNameTries >= 1) {
                    System.out.println("Enter Customer Name Surname:");
                    name = validateName(ConsoleHelper.readLine());
                    remainingNameTries--;
                }
                if (remainingEmailTries >= 1) {
                    System.out.println("Enter Customer Email:");
                    email = validateEmail(ConsoleHelper.readLine());
                    remainingEmailTries--;
                }
                if (remainingPhoneNumberTries >= 1) {
                    System.out.println("Enter Customer Phone Number:");
                    phoneNumber = ValidatePhomeNumber(ConsoleHelper.readLine());
                    remainingPhoneNumberTries--;
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
                if (e.getMessage().contains("Name")) {
                    if (remainingNameTries >= 1) {
                        System.out.println("You have " + remainingNameTries + " attempts remaining for Name Surname.");
                        remainingNameTries--;
                    }
                } else if (e.getMessage().contains("Email")) {
                    if (remainingEmailTries >= 1) {
                        System.out.println("You have " + remainingEmailTries + " attempts remaining for Email.");
                        remainingEmailTries--;
                    }
                } else if (e.getMessage().contains("Number")) {
                    if (remainingPhoneNumberTries >= 1) {
                        System.out.println("You have " + remainingPhoneNumberTries + " attempts remaining for Phone Number.");
                        remainingPhoneNumberTries--;
                    }
                }
                if (remainingNameTries == 0 || remainingEmailTries == 0 || remainingPhoneNumberTries == 0) {
                    System.out.println("Too many invalid attempts. Exiting the application.");
                    System.exit(1);
                }
            }
        }
        return new CustomerInfo(name, email, phoneNumber);
    }


    private static String validateName(String name) {
        if (name.matches(".*\\d.*")) {
            throw new CustomerValidationException("Name must only contain letters.");
        }
        return name;
    }

    private static String validateEmail(String email) {
        if (!email.matches("[a-zA-Z0-9]+@gmail\\.com")) {
            throw new CustomerValidationException("Invalid email format. Email must end with @gmail.com, Letters and Numbers");
        }
        return email;
    }

    private static String ValidatePhomeNumber(String number) {
        if (!number.matches("\\d+")) {
            throw new CustomerValidationException("Number must only contain numbers");
        }
        if (number.length() != 9) {
            throw new CustomerValidationException("Number must be 9 digits");
        }
        if (!number.matches("[1-9]\\d{8}")) {
            throw new CustomerValidationException("Number does not start 0");
        }
        return number;
    }

    @Override
    public void getCustomerInfo() {
        System.out.println(
                "Customer Name: " + customerName +
                        ", Customer Number: " + customerNumber +
                        ", Customer E-mail: " + customerEmail);

    }
}

package com.solvd.laba.block1.task2;

import com.solvd.laba.block1.task2.Exceptions.ComputerValidationException;
import com.solvd.laba.block1.task2.Interfaces.IComputerInfo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputerInfo implements IComputerInfo {
    private final String brand;
    private final String model;
    private final String year;

    public ComputerInfo(String brand, String model, String year) {
        this.brand = brand;
        this.model = model;
        this.year = year;

    }


    public static ComputerInfo getComputerInfo() {
        try {
            System.out.println("Computer Brand: ");
            String brand = ComputerInfo.ConsoleHelper.readLine();
            System.out.println("Computer Model: ");
            String model = ComputerInfo.ConsoleHelper.readLine();
            System.out.println("Computer Year: ");
            String year = validateYearOfComputer(ComputerInfo.ConsoleHelper.readLine());

            return new ComputerInfo(brand, model, year);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number for the year.");
            return null;
        }

    }

    public static class ConsoleHelper {
        private static final Scanner scanner = new Scanner(System.in);

        public static String readLine() {
            return scanner.next();
        }
    }

    public static String validateYearOfComputer(String year)
    {
        if (!year.matches("\\d+")) {
            throw new ComputerValidationException("Year must only contain numbers");
        }
        if (year.length() != 4) {
            throw new ComputerValidationException("Invalid Year length. It must contain exactly 4 digits.");
        }
        if (!year.startsWith("20")) {
            throw new ComputerValidationException("Year cannot start with 20.");
        }
        return year;
    }

    @Override
    public String toString() {
        return "Computer" +
                "brand=" + brand +
                ", model=" + model +
                ", year=" + year;
    }
}


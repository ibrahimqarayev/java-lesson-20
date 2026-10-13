import exception.InvalidAgeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAgeException {

        registerUser("Ibrahim",150);

    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number: ");
                double number1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double number2 = scanner.nextDouble();

                if (number2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }

                double division = number1 / number2;

                System.out.println(number1 + " / " + number2 + " = " + division);

                break;
            } catch (InputMismatchException ex) {
                System.out.println("Exception: The entered value is not a number!");
                scanner.nextLine();
            } catch (ArithmeticException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }


    public static void task2() {
        String[] names = {"Ali", "Vüsal", "Aysel"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ". " + names[i]);
        }

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter index number: ");
            int index = scanner.nextInt();

            System.out.println(names[index]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Exception: Index must be between 0 and 2");

        } catch (InputMismatchException ex) {
            System.out.println("Exception: Please enter a numeric value");
        }
    }

    public static void task3() {
        String[] values = {"12", "abc", "7", "", "3.5", "-4"};

        int total = 0;

        for (String value : values) {
            try {
                int number = Integer.parseInt(value);
                System.out.println("Value = " + number);
                total = total + number;

            } catch (NumberFormatException ex) {
                System.out.println(value + ": is not a number");
            }
        }

        System.out.println("Total: " + total);
    }

    public static void registerUser(String name, int age) {

        if (age < 18 || age > 120) {
            throw new InvalidAgeException("Age must be between 3 and 120");
        }

        System.out.println("User: " + name + " registered.");
    }

    public static int parseIntOrDefault(String s, int def) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            return def;
        }
    }

    public static double parseDoubleOrDefault(String s, double def) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            return def;
        }
    }
}
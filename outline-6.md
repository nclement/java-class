# Java Class: Week 6 (25 July)

## Intro

### Last time: if/else, loops

### This time: parameters, return values, scanner

## Parameters

A parameter is a way to communicate a variable to a method.

Parameter declarations go between the parentheses in your method definition:

    public static void printInteger(int x) {
      System.out.println(x);
    }

When you call your method you must provide a value of the correct type:

    printInteger(3);
    printInteger(-81829);

### Multiple values can be passed as parameters

    public static void printStars(char star, char separator) {
      System.out.println(star + separator + star);
    }

## Return values

A return value is a way to communicate a variable out of a method.

Method type is declared along with method:

    public static double computeTax(double amount, double taxRate) { ... }

Value gets "sent back" from method using "return":

    return amount * taxRate;

## Scanner

A way to get input values into your program.

Put this at the top of your program file:

    import java.util.Scanner;

Then, inside a method:

    Scanner console = new Scanner(System.in);

You can use it by calling methods on the console:

    double d = console.nextDouble();
    int i = console.nextInt();
    String word = console.next();
    String line = console.nextLine();

Each of these methods returns a value of the appropriate type based on what is
typed into the console window.

## Example: bill calculator

Write a program that asks the user for three prices and a tax rate, and computes
the subtotal, the tax, and the total bill.

## Homework

- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s13-mathExpressions
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s14-parameterMysteryReturn
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s6-parameterMysteryNumbers

- Do five exercises from "Warmup-1" at http://codingbat.com/java

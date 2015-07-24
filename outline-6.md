# Java Class: Week 6 (25 July)

## Intro

### Last time: scanner, if/else, while loops

### This time: for loops, return values

## For loops

We've seen one loop construct so far: ``while``.

    int count = 10;
    while (count != 0) {
      System.out.println("Hello! " + count + " left to go ...");
      count--;
    }

In this loop we have a counter variable that keeps track of the number of times
we've run the loop.

This pattern of looping is so common that there's a special syntax for it: the
``for`` loop:

    for (int count = 10; count != 0; count--) {
      System.out.println("Hello! " + count + " left to go ...");
    }

Basically the initialization and decrement are moved inside the parentheses in
the ``for`` loop.

The generic syntax is:

    for (<init statement>; <boolean expression>; <incr statement>) {
      <statement>;
      <statement>;
      // ...
    }

The initialization statement typically creates a variable to keep track of the
number of loop iterations, the loop continues as long as the boolean expression
is ``true``, and the increment (or decrement) statement is run after each
iteration through the loop.

### Practice: squares of numbers

Write a single for loop that prints out the squares of each integer from ``0``
through some upper limit ``n``.

### Practice: number triangle

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+2&problem=bjp3-2-e15-printDesign

Write a series of nested for loops to generate the following output:

    -----1-----
    ----333----
    ---55555---
    --7777777--
    -999999999-

## Return values

So far we've looked at methods that just contain statements. These methods
cannot share information, they can only do things like print, get inputs, or
call other methods.

We can change that by *returning* a value from a method. A return value is a way
to communicate a value to the *caller* of a method.

Methods that do not return a value are declared ``void``. (So far all the
methods we've written are ``void``.)

Calling a ``void`` method is a *statement*, e.g.:

    System.out.println("Hello!"); // does not return a value

Calling a non-``void`` method is an *expression*:

    double s = Math.sqrt(10);

### Declaring a method with a return type

Before we defined only ``void`` methods:

    public static void <name>() {
      return <expression>;
    }

It turns out ``void`` is a special keyword representing a "non-type" of data. In
general the return type of a method is declared along with the method:

    public static <type> <name>() {
      return <expression>;
    }

For example, this method computes the tax on a bill by asking the user for
appropriate values. It prints out the tax amount:

    public static void computeTax() {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter the amount of the bill: ");
      var bill = console.nextDouble();
      System.out.print("Enter the tax rate: ");
      var tax = console.nextDouble();
      System.out.println("The tax is: " + (bill * tax));
    }

This method can be changed to return the tax instead:

    public static double computeTax() {
      Scanner console = new Scanner(System.in);
      System.out.print("Enter the amount of the bill: ");
      var bill = console.nextDouble();
      System.out.print("Enter the tax rate: ");
      var rate = console.nextDouble();
      return bill * rate;
    }

This value gets "sent back" to the caller:

    public static void main() {
      double tax = computeTax();
      System.out.println("The tax is: " + tax);
    }

### Math methods

There are many built-in methods in the ``Math`` class that return values:

    Math.abs(-4.0);  // absolute value
    Math.pow(3, 4);  // computes x to the y power
    Math.sqrt(4.4);  // square root
    Math.exp(1.2);   // exponential function
    Math.sin(0.2);   // sin function
    Math.log(1221);  // logarithm

## Homework

### Fibonacci numbers

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+2&problem=bjp3-2-e3-fibonacci

Write a single for loop inside a main method that prints out the first 10
Fibonacci numbers.

### Quadratic equation solver

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e8-quadratic

(Instead of parameters, use a ``Scanner`` to get the ``a``, ``b``, and ``c``
values from the user.)

### Square printer

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e4-printSquare

(Instead of parameters, use a ``Scanner`` to get the values of ``min`` and
``max`` from the user.)

## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic5_for_loops_nested_loops_4Up.pdf
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic6_loops_figures_constants_4Up.pdf

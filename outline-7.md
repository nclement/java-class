# Java Class: Week 7 (1 August)

## Intro

### Last time: for loops, nested loops

### This time: parameters, return values, scope

## Parameters

A parameter is a way to communicate a variable to a method.

Parameter declarations go between the parentheses in your method definition:

    public static <type> <name>(<type> <name>) { ... }

For example, here's a method that prints out some integer:

    public static void printInteger(int x) {
      System.out.println(x);
    }

When you call your method you must provide a value of the correct type:

    printInteger(3);
    printInteger(-81829);

### Multiple values can be passed as parameters

To include multiple parameters, just add more type/name pairs with commas in
between them:

    public static <type> <name>(<type> <name>, <type> <name>, ...) { ... }

When you call the method, you need to include the appropriate number of
expressions.

For example, here's a method that prints out two star characters separated by
some other character:

    public static void printStars(char star, char separator) {
      System.out.println(star + separator + star);
    }

When it's called:

    printStars('x', '*');  // prints out "x*x"

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

## Math methods

There are many built-in methods in the ``Math`` class that take parameters and
return values:

    Math.abs(-4.0);  // absolute value
    Math.pow(3, 4);  // computes x to the y power
    Math.sqrt(4.4);  // square root
    Math.exp(1.2);   // exponential function
    Math.sin(0.2);   // sin function
    Math.log(1221);  // logarithm

### Scope

Each variable in a Java program has a limited visibility.

## Homework

- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s13-mathExpressions
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s14-parameterMysteryReturn
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s6-parameterMysteryNumbers

- Do five exercises from "Warmup-1" at http://codingbat.com/java

### Quadratic equation solver

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e8-quadratic

(In your main method, use a ``Scanner`` to get the ``a``, ``b``, and ``c``
values from the user.)

## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic7_parameters_4Up.pdf

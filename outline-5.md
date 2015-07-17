# Java Class: Week 5 (18 July)

## Intro

Last time: statements, expressions, examples

This time: input, boolean expressions, if/else, loops

## Input Expressions

So far we have looked at programs that only produce output. Here's a way to get
input from the person running your program, using a "Scanner":

    import java.util.Scanner;

    public class Input {
      public static void main() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter your age: ");
        double age = console.nextDouble();
        System.out.println("Your are " + age + ", really?!");
      }
    }

This code creates a new variable called ``console`` that lets you call methods
on it (the "." separates the variable name from the method name). Each of these
methods is an **expression** that can be used to put a value in a variable.

There are also methods on the console variable that will read integers, words,
and entire lines:

    int i = console.nextDouble();
    String s = console.next();
    String l = console.nextLine();

## Boolean Expressions

A boolean variable is used to represent the binary states of "yes" and "no",
"on"/"off", "true"/"false", etc.

    bool isOldEnough = true;

``true`` and ``false`` are the boolean literals.

Booleans are also the results of comparisons between values:

    int a = 4, b = 5;
    bool aIsLarger = a > b;
    bool bIsLarger = a < b;
    bool aEqualsB = a == b;
    bool isEven = a % 2 == 0;
    bool isNonNegative = a >= 0;

You can also logically combine two booleans using "and" and "or":

    bool bothEven = (a % 2 == 0) && (b % 2 == 0);
    bool eitherEven = (a % 2 == 0) || (b % 2 == 0);

## Conditional statements: ``if`` and ``else``

In many programming languages you can get your code to do run statements based
on the value that's stored in a variable. In Java to do this you use ``if`` and
``else``.

To run some statements if a boolean expression is ``true``, use ``if``:

    if (<boolean expression>) {
      // these statements run if the expression is true.
      <statement>;
      <statement>;
      // ...
    }

Example:

    Scanner console = new Scanner(System.in);
    System.out.print("How many brothers? ");
    int brothers = console.nextInt();
    System.out.print("How many sisters? ");
    int sisters = console.nextInt();
    if (brothers + sisters == 0) {
      System.out.println("You're an only child.");
    }

If the boolean expression evaluates to ``false`` then the computer will "jump
over" the body of the if statement, skipping all of the statements contained
between the curly brackets!

If you want your code to do one thing if an expression is ``true`` and a
different thing if it's ``false``, use ``else``:

    if (<boolean expression>) {
      // these statements run if the expression is true.
      <statement>;
      <statement>;
      // ...
    } else {
      // these statements run if the expression is false.
      <statement>;
      <statement>;
      // ...
    }

Example:

    Scanner console = new Scanner(System.in);
    System.out.print("How old are you? ");
    int age = console.nextInt();
    if (age < 16) {
      System.out.println("Wait " + (16 - age) + " years to drive.");
    } else {
      System.out.println("You can get your license!");
    }

## Loops: ``while``

Sometimes you need to run the same statements over and over again, until some
condition is met. This is accomplished using **loops**. In Java the simplest
loop is written using ``while``:

    while (<boolean expression>) {
      <statement>;
      <statement>;
      // ...
    }

Example:

    int i = 10;
    while (i != 0) {
      System.out.println("Time " + i);
      i = i - 1;
    }
    System.out.println("Liftoff!");

## Homework



## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic5_for_loops_nested_loops_4Up.pdf
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic6_loops_figures_constants_4Up.pdf

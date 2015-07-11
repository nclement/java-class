# Java Class: Week 4 (11 July)

## Intro

Last time: methods and variables (practice)

This time: review, statements, expressions (, parameters)

## Computer architecture

- CPU: runs program
- RAM: stores variables in a running program
- HD: stores saved data

## Program syntax

We know so far how to write a basic Java program:

    public class <Name> {
      <Method>
      // more methods ...
    }

So a program so far contains one or more method definitions. Each method
definition looks like this:

    public static void <Name>() {
        <Statement>;
        // more statements ...
    }

Each method is a "wrapper" for one or more statements.

## Statements

A **statement** is a single instruction for the Java virtual machine to run.
Here are some examples that we've seen already:

- System.out.println("hello");
- System.out.println();
- myMethod();

We have also seen a few statements that involve variables:

- ``int x;  // declare variable x of type int``
- ``x = 3;  // assign literal value 3 to x``
- ``System.out.println(x);  // print the contents of x``

Each of these statements represents an instruction that the Java program will
carry out when it runs.

## Expressions

An **expression** is a representation of a value in a Java program. Like
variables, expressions are strongly typed.

We've already seen a few examples of expressions. All literals are expressions:

- "hello" (a String literal)
- 3 (an int literal)
- -5.5 (a double literal)
- true (a boolean literal)

Also any valid combination of literals, variables, and operators is an
expression:

- 5 + 3 (represents the int value 8)
- 9.0 / 3.3 (represents the double value 2.727272727...)
- "hello" + 1 (represents the string value "hello1")
- 3 * 4 / 8 + 2.5 * 2 (represents the double value 6.0)

## Example: The Shining

For homework I asked you to write a program that prints this sentence 1000
times:

    All work and no play makes Jack a dull boy.

(This is from http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+1&problem=bjp3-1-e16-Shining.)

You could do this by writing a program that contains 1000 println statements:

    public class Shining {
      public static void main() {
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        // 995 more println ...
      }
    }

But you can do this with far fewer lines by grouping common statements together
into methods:

    public class Shining {
      public static void main() {
        print625();
        print125();
        print125();
        print125();
      }

      public static void print625() {
        print125();
        print125();
        print125();
        print125();
        print125();
      }

      public static void print125() {
        print25();
        print25();
        print25();
        print25();
        print25();
      }

      public static void print25() {
        print5();
        print5();
        print5();
        print5();
        print5();
      }

      public static void print5() {
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
        System.out.println("All work and no play makes Jack a dull boy.");
      }
    }

This is an example of using methods to structure your program more clearly.
Here, the methods make a sort of "tree" structure, where each method calls a
small number of other methods.

## Example: star figure

Suppose we want to generate the following figure when we run our program:

    *****
    *****
     * *
      *
     * *

    *****
    *****
     * *
      *
     * *
    *****
    *****

      *
      *
      *
    *****
    *****
     * *
      *
     * *

(This is from http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+1&problem=bjp3-1-e13-StarFigures.)

We could do this by "wrapping" the entire thing with print statements:

    public class Stars {
      public static void main() {
        System.out.println("*****");
        System.out.println("*****");
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
        System.out.println();
        System.out.println("*****");
        System.out.println("*****");
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
        System.out.println("*****");
        System.out.println("*****");
        System.out.println();
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("*****");
        System.out.println("*****");
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
      }
    }

But this involves a lot of repetition. We can simplify the repeated bits by
putting repeated statements in methods:

    public class Stars {
      public static void main() {
        printBanner();
        System.out.println();
        printBanner();
        System.out.println("*****");
        System.out.println("*****");
        System.out.println();
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("  *");
        printBanner();
      }

      public static void printBanner() {
        System.out.println("*****");
        System.out.println("*****");
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
      }
    }

Already this is better. But there is a bit that's still repeated in the two
methods. We can factor this out into a separate method:

    public class Stars {
      public static void main() {
        printBanner();
        System.out.println();
        printBanner();
        printBars();
        System.out.println();
        System.out.println("  *");
        System.out.println("  *");
        System.out.println("  *");
        printBanner();
      }

      public static void printBanner() {
        printBars();
        System.out.println(" * *");
        System.out.println("  *");
        System.out.println(" * *");
      }

      public static void printBars() {
        System.out.println("*****");
        System.out.println("*****");
      }
    }

We can also avoid repeating the same string literals by storing them in
variables:

    public class Stars {
      public static void main() {
        printBanner();
        System.out.println();
        printBanner();
        printBars();
        System.out.println();
        String one = "  *";
        System.out.println(one);
        System.out.println(one);
        System.out.println(one);
        printBanner();
      }

      public static void printBanner() {
        printBars();
        String two = " * *";
        System.out.println(two);
        System.out.println("  *");
        System.out.println(two);
      }

      public static void printBars() {
        String five = "*****";
        System.out.println(five);
        System.out.println(five);
      }
    }

## Homework

### Egg figure

Write a program that generates the following output:

      _______
     /       \
    /         \
    \         /
     \_______/
    -"-'-"-'-"-
      _______
     /       \
    /         \
    \         /
     \_______/
    -"-'-"-'-"-
    \         /
     \_______/
      _______
     /       \
    /         \
    -"-'-"-'-"-
    \         /
     \_______/

Use at least one method in your program to provide structure and eliminate
repetition.

Hint: make sure you escape the backslashes (\) and double quotes (")!

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+1&problem=bjp3-1-e10-Egg2

### Program tracing

What is the output of the following programs?

Letter:

    public class Letter {
      public static void main() {
        System.out.println("Dear \"DoubleSlash\" magazine,");
        System.out.println();
        System.out.println("\tYour publication confuses me.  Is it");
        System.out.println("a \\\\ slash or a //// slash?");
        System.out.println("\nSincerely,");
        System.out.println("Susan \"Suzy\" Smith");
      }
    }


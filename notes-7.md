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

    public class Squares {
      public static void main() {
        int n = 10;
        for (int i = 0; i <= n; i++) {
          System.out.println(i * i);
        }
      }
    }

You could do this by coding up ``n`` lines containing ``System.out.println(1 *
1)``, ``System.out.println(2 * 2)`` and so on, but this is repetitive and prone
to bugs. It's also difficult to maintain. A loop lets us express the printing
and the squaring one time in our code.

Suppose we wanted to print out the cubes of the numbers instead; we'd just need
to change what gets printed out:

          System.out.println(i * i * i);

To print more numbers, we'd just change the value of ``n`` at the beginning.

How would you change the code to let the user enter the value for ``n``?

### Fibonacci numbers

The Fibonacci numbers are a sequence of integers defined using a recurrence
relation: each value in the sequence is the sum of the two preceding values. The
first two values are 1 and 1, the next few are 2, 3, 5, 8. 13. etc.

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+2&problem=bjp3-2-e3-fibonacci

Write a single for loop inside a main method that prints out the first 10
Fibonacci numbers.

    public class Fibonacci {
      public static void main() {
        int twoback = 1;
        int oneback = 1;
        for (int n = 1; n <= 10; n++) {
          System.out.println(twoback);
          int current = oneback + twoback;
          twoback = oneback;
          oneback = current;
        }
      }
    }

In this method we use two extra variables to keep track of the Fibonacci
sequences values that are one and two back from our current position. We then
swap these values around after we print the two-back value.

The loop is designed to run ten times. The loop variable ``n`` doesn't play a
direct role in computing the Fibonacci values; it's just there to make sure we
do the computation 10 times.

How would you modify the program so that the user could input the number of
numbers to display?

    import java.util.Scanner;

    public class Fibonacci {
      public static void main() {
        System.out.print("Enter the number of numbers: ");
        int limit = console.nextInt();

        int twoback = 1;
        int oneback = 1;
        for (int n = 1; n <= limit; n++) {
          System.out.println(twoback);
          int current = oneback + twoback;
          twoback = oneback;
          oneback = current;
        }
      }
    }

You'd need to add a Scanner and prompt the user for a number, like the code
above.

### Practice: star triangle

Write a Java method that generates the following output:

    *
    **
    ***
    ****
    *****

To solve this problem, we need to *nest* one loop inside another. Consider how
you might write code to generate this output:

    *****
    *****
    *****
    *****
    *****

You could do this with a single loop that prints ``*****`` five times:

    public class Stars {
      public static void main() {
        for (int i = 1; i <= 5; i++) {
          System.out.println("*****");
        }
      }
    }

What if yo wanted to print the stars in the line using a loop instead of a
single string? You need another loop inside the first that will print ``*`` 5
times.

    public class Stars {
      public static void main() {
        for (int i = 1; i <= 5; i++) {
          for (int j = 1; j <= 5; j++) {
            System.out.print("*");
          }
          System.out.println();
        }
      }
    }

(Here we've replaced the ``println`` with just ``print`` so that all the stars
will be on the same line. We then need a ``println`` after the internal loop to
start a new line.)

So now we have a nested for loop to print out a square of stars. The outer loop
prints out the lines in the square, and the inner loop prints out the stars in
each line.

We can modify this to print just the stars in the triangle by figuring out the
relationship between the line being printed and the number of stars on that
line. In this case it's pretty straightforward: when ``i`` is some value, say,
3, then there are that many (say, 3) stars on the line. So we need to change the
inner loop so that it runs for a number of times that depends on the index
variable of the outside loop. In the code above we can do that by replacing ``j
<= 5`` with ``j <= i``!

    public class Stars {
      public static void main() {
        for (int i = 1; i <= 5; i++) {
          for (int j = 1; j <= i; j++) {
            System.out.print("*");
          }
          System.out.println();
        }
      }
    }

## Homework

### Output check

What output does the following code produce?

    for (int line = 1; line <= 5; line++) {
      for (int i = 1; i <= (5 - line); i++) {
        System.out.print(".");
      }
      for (int j = 1; j <= line; j++) {
        System.out.print(line);
      }
      System.out.println();
    }

You should try to trace through the code, keeping track of the variables in
memory. After you've given that a try, you can copy the code into BlueJ, compile
it, and run it to check your prediction.

Make sure you understand why the code produces the output it does. If you have
any questions, write them down and ask next week in class.

### Inverted star triangle

Write a nested for loop to generate the following output:

    *****
    ****
    ***
    **
    *

### Wide inverted star triangle

Write a nested for loop to generate the following output:

    **********
    ********
    ******
    ****
    **

### Lower right triangle

Write a nested for loop to generate the following output:

        *
       **
      ***
     ****
    *****

### Number triangle

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+2&problem=bjp3-2-e15-printDesign

Write a series of nested for loops to generate the following output:

    -----1-----
    ----333----
    ---55555---
    --7777777--
    -999999999-

### Square printer

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e4-printSquare

(Instead of parameters, use a ``Scanner`` to get the values of ``min`` and
``max`` from the user. We'll go over parameters soon.)

## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic5_for_loops_nested_loops_4Up.pdf
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic6_loops_figures_constants_4Up.pdf

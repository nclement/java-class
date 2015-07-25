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

### Fibonacci numbers

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+2&problem=bjp3-2-e3-fibonacci

Write a single for loop inside a main method that prints out the first 10
Fibonacci numbers.

## Homework

### Quadratic equation solver

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e8-quadratic

(Instead of parameters, use a ``Scanner`` to get the ``a``, ``b``, and ``c``
values from the user. We'll go over parameters soon.)

### Square printer

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e4-printSquare

(Instead of parameters, use a ``Scanner`` to get the values of ``min`` and
``max`` from the user. We'll go over parameters soon.)

### Practice: number triangle

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+2&problem=bjp3-2-e15-printDesign

Write a series of nested for loops to generate the following output:

    -----1-----
    ----333----
    ---55555---
    --7777777--
    -999999999-

## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic5_for_loops_nested_loops_4Up.pdf
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic6_loops_figures_constants_4Up.pdf

# Java I: Day 3
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/)*

## Intro

### Review last class: strings

### Goals for this class: static methods, variables

## What is Java

### Bytecode compiler -- translates high-level syntax to machine code

- Runs on a "virtual machine"

The virtual machine allows a single Java program to run on lots of different
underlying hardware architectures (e.g., phones, desktops, mainframes).

### Statically typed

All variables in a program have an associated type. Variables of different
types, in general, cannot be used interchangeably.

### Garbage-collected

Memory is managed for you by the virtual machine.

### Object-oriented

Code is grouped into logical "objects" that combine data with functions for
manipulating the data.

We won't talk much about this in this class; it's powerful but complicated!

## Program entry point: main

When a Java class is run as the "main" program, the following method is called:

```java
public static void main(String[] args) { ... }
```

## Comments

Use comments to annotate your code.

    /* everything between /* and */ is a comment */

    // everything from // to the end of the line is a comment

## Methods

Methods group together logical chunks of operations.

To define a method:

```java
public static void methodName() {
// ... put statements here, like System.out.println("hi");
}
```

To invoke or "call" a method:

    methodName();

### Important to have good names
```java
public static void c() { ... } // not so great

public static void printChorus() { ... } // better!
```

### Bottom-up way of defining methods

To define methods "bottom-up", think of your program as a long sequence of
commands to be executed. Then find repetition in the sequence, and replace
repeated chunks with methods.

### Top-down way of defining methods

To define methods "top-down", think of how your program "should" work and write
method calls. Then define those methods.

### Methods can call each other!

If there is a loop in a sequence of method calls, your program will run without
stopping, until it runs out of memory. This generates a Stack Overflow!

## Variables

A variable is a name for a place in the computer's memory.

In Java, a variable holds a specific type of information.

Java has several "primitive" ("built-in") types:

- `int` -- an integer value ("whole number": positive, zero, or negative)
- `double` -- a real ("decimal") value
- `String` -- a sequence of characters
- `boolean` -- true or false

Assigning the wrong type to a variable can produce an error!

### Steps for using

1. Declare the variable: `int x`
2. Assign a value to it: `x = 3`
3. Use it: `System.out.println(x)`

### Managing Types
Java can automatically convert between some types:
- Going from an `int` to a `double` is okay

However, going from some types is not okay

- What is the `int` version of 2.6? Is it 2? Is it 3?

Make sure you understand type conversion when doing simple arithmetic. For example, try the following:
```java
System.out.println(4/5);
System.out.println(4.0/5);
System.out.println(4/5*5);
```
## Order of operations (PEMDAS)

- Parentheses
- Exponents (not used in Java)
- Multiplication
- Division
- Addition
- Subtraction

## Homework

### Method Exercises

- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e9-Egg
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e16-Shining
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e13-StarFigures

### Variable Exercises

- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter2/s2-expressions1
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter2/s3-expressions2
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter2/s4-expressions3

## More Info

- http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic3staticMethods_StructuredProgramming.pdf
- http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic4_expressions_and_variables.pdf
- https://learnjavathehardway.org/book/ex05.html
- https://learnjavathehardway.org/book/ex06.html
- https://learnjavathehardway.org/book/ex11.html

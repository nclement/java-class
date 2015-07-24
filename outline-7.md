# Java Class: Week 7 (1 Aug)

## Intro

### Last time: for loops, return values

### This time: parameters, memory

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

## Memory

We've already seen how a variable is a name for a piece of memory. But what does
that mean?

In Java, a variable names a piece of memory that's as big as the memory
architecture of the machine. For example, on a 64-bit Java Virtual Machine, each
``double``, ``int``, ``boolean``, etc. is a name for 64 bits (8 Bytes) of
memory.

### Scope

Each variable in a Java program has a limited visibility.

### Pointers

But what about more complex data types, like ``String``? A ``String`` can
contain 1, or 10, or 100, or 100000 characters. How would these all fit into 8
Bytes of memory?

The answer is that a variable of type ``String`` is a name for 8 Bytes of
memory. However, the contents of that variable are an 8-Byte integer that is the
address of another place in memory!

## Homework

- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s13-mathExpressions
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s14-parameterMysteryReturn
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s6-parameterMysteryNumbers

- Do five exercises from "Warmup-1" at http://codingbat.com/java

## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic7_parameters_4Up.pdf

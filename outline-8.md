# Java Class: Week 8 (8 August)

## Intro

### Last time: parameters, return values, scope

### This time: memory, pointers, objects

## String methods

http://docs.oracle.com/javase/7/docs/api/java/lang/String.html

Strings in Java are different from other basic types -- they are "objects."

In part that means that Strings are associated with a set of methods that can be
called on them.

Use the dot notation: ``<variable>.<method>()``

    String s = "hello";
    System.out.println(s);
    System.out.println(s.toUppercase());
    System.out.println(s.substring(2, 4));
    System.out.println(s.length());
    System.out.println(s.endsWith("lo"));
    System.out.println(s.endsWith("ll"));
    System.out.println(s.contains("ll"));
    System.out.println(s.contains("LL"));

## Memory

We've already seen how a variable is a name for a piece of memory. But what does
that mean?

In Java, a variable names a piece of memory that's as big as the memory
architecture of the machine. For example, on a 64-bit Java Virtual Machine, each
``double``, ``int``, ``boolean``, etc. is a name for 64 bits (8 Bytes) of
memory.

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


# Java Class: Week 8 (8 August)

## Intro

### Last time: parameters, return values, scope

### This time: memory, strings, objects

## Strings

http://docs.oracle.com/javase/7/docs/api/java/lang/String.html

Strings in Java are different from other basic types (int, double, etc.) --
Strings are "objects."

In part that means that Strings are associated with a set of methods that can be
called on them.

Use the dot notation: ``<variable>.<method>(<parameter expressions>)``

    String s = "hello";
    System.out.println(s);
    System.out.println(s.toUpperCase());
    System.out.println(s.substring(2, 4));
    System.out.println(s.length());
    System.out.println(s.endsWith("lo"));
    System.out.println(s.endsWith("ll"));
    System.out.println(s.contains("ll"));
    System.out.println(s.contains("LL"));

The dot notation basically means, "call this method on this specific piece of
data." It's a little bit like having a hidden parameter inside the method that
gives a "target" value for the method.

## Memory

We've already seen how a variable is a name for a piece of memory. But what does
that mean?

In Java, a variable names a piece of memory whose size depends on the type of
variable. For example, a ``double`` is a name for 64 bits (8 Bytes) of memory,
an ``int`` is a name for 32 bits (4 Bytes), and ``boolean`` is a name for one
bit (but this gets a little bit complicated).

To a computer, memory is accessed using a numeric "address" -- the first Byte of
memory has address 0, the second Byte has address 1, etc.

When you declare a variable like this:

    int x = 10;

the Java compiler sets aside 4 Bytes of memory at some address (let's say it was
address 16), and gives that address the name ``x``. Internally, Java maintains a
lookup table that maps variable names to their addresses in memory:

     name | start | stop
    ------+-------+------
     x    | 16    | 20

If you allocate another variable:

    double y = 0.1;

then the memory table might look like this:

     name | start | stop
    ------+-------+------
     x    | 16    | 20
     y    | 20    | 28

In other words, Java keeps track of where your variables are stored in memory
using this table, like an address book.

### Strings in memory

Strings are weird, though. Strings are made up of some number of characters, but
there can be one, two, or many thousands of characters in a string. How does a
string get stored in memory?

The answer is that a variable of type ``String`` is a name for 8 Bytes of
memory. However, the contents of that variable are an 8-Byte integer that is the
address of another place in memory!

## Homework

- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s13-mathExpressions
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s14-parameterMysteryReturn
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s6-parameterMysteryNumbers

## Resources

- Java String documentation: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
- http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic13_procedural_design_4Up.pdf

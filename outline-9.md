# Java Class: Week 9 (15 August)

## Intro

### Last time: strings

### This time: files

## Memory

We've already seen how a variable is a name for a piece of memory. But what does
that mean?

In Java, a variable names a piece of memory whose size depends on the type of
variable. For example, a ``double`` is a name for 64 bits (8 Bytes) of memory,
an ``int`` is a name for 32 bits (4 Bytes), and ``boolean`` is a name for one
bit (but this gets a little bit complicated).

To a computer, memory is accessed using a numeric **address** -- the first Byte
of memory has address 0, the second Byte has address 1, etc.

When you declare a variable like this:

    int x = 10;

the Java compiler sets aside 4 Bytes of memory at some address (let's say it was
address 16), and gives that address the name ``x``. Internally, Java maintains a
lookup table that maps variable names to their addresses in memory:

     name | type | address | size
    ------+------+---------+------
     x    | int  | 16      | 4

If you allocate another variable:

    double y = 0.1;

then the memory table might look like this:

     name | type   | address | size
    ------+--------+---------+------
     x    | int    | 16      | 4
     y    | double | 20      | 8

In other words, Java keeps track of where your variables are stored in memory
using a table, like an address book.

## Strings in memory

Strings are weird, though. Strings are made up of some number of
characters---there can be one, two, or many thousands of characters in a string.
How does a string get stored in memory?

The answer is that a variable of type ``String`` is a name for 8 Bytes of
memory. However, the contents of that variable are an 8-Byte integer that
provides the address for another place in memory!

A string keeps track of both where it starts in memory and how many Bytes of
memory it consumes.

    String s = "hello";

This basically creates two things in memory: starting at address 1084, a
sequence of 5 Bytes containing "h", "e", "l", "l", "o" as well as a "reference"
to the starting address of the characters of the string.

     name |  type  | address | size
    ------+--------+---------+------
     x    | int    | 16      | 4
     y    | double | 20      | 8
     s    | ref    | 28      | 8
     *s   | String | 1084    | 5

We say that ``s`` "points to" memory address 1084.

### Example: swap pairs

In this problem, we are to create a new string by swapping pairs of characters
from the original string. In the solution below, we loop over the string,
increasing our loop index by two each time. Then we append the second character
first, and the first character second:

    public static String swapPairs(String original) {
      String result = "";
      for (int i = 1; i < original.length(); i += 2) {
        result += original.charAt(i)
        result += original.charAt(i - 1);
      }
      if (original.length() % 2 == 1) {
        result += original.charAt(original.length() - 1);
      }
      return result;
    }

We need a test at the end to check whether the original string had an odd number
of characters; if so, the last character just gets appended to the end of our
result.


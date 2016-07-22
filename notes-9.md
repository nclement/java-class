# Java Class: Week 8 (8 August)

## Intro

### Last time: parameters, return values, scope

### This time: strings

## Review: parameters and return values

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s6-parameterMysteryNumbers

    public class MysteryNumbers {
      public static void main(String[] args) {
          String one = "two";
          String two = "three";
          String three = "1";
          int number = 20;

          sentence(one, two, 3);
          sentence(two, three, 14);
          sentence(three, three, number + 1);
          number = sentence(three, two, 1);
          sentence("eight", three, number / 2);
      }

      public static int sentence(String three, String one, int number) {
        number++;
        System.out.println(one + " times " + three + " = " + (number * 2));
        return number + 1;
      }
    }

## Strings

http://docs.oracle.com/javase/7/docs/api/java/lang/String.html

Strings in Java are different from other basic types (int, double, etc.).
Strings are "objects" which means they are a bundle of data combined with
methods that operate on that data specifically.

We've already seen how to create a String object (called an "instance"):

    String s = "Hello";

To call a method on an instance, use the dot notation:
``<variable>.<method>(<parameter expression>, ...)``

    System.out.println(s);
    System.out.println(s.toUpperCase());
    System.out.println(s.substring(2));
    System.out.println(s.substring(2, 4));
    System.out.println(s.length());
    System.out.println(s.endsWith("lo"));

The dot notation basically means, "call this method on this specific piece of
data." It's a little bit like having a hidden parameter inside the method that
gives a "target" value for the method.

### String basics

Strings are composed of a sequence of characters. Each character has an index,
starting from index ``0`` (the first character in the string) and going up to
index ``n-1`` (the last character in a string of length ``n``).

Strings have lots of built-in functionality in Java. The most basic methods
return the length of the string:

    s.length();

and retrieving parts of a string. There is a way to get individual characters:

    s.charAt(3);

It's quite common to loop over all of the the index positions in a string.
Usually the loop looks like this:

    for (int i = 0; i < s.length(); i++) {
      System.out.println(s.charAt(i));
    }

You can also build a new string by concatenating characters or sub-strings.

### Example: reversing

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e19-printReverse

    public static String reverse(String s) {
      String r = "";
      for (int i = s.length() - 1; i >= 0; i--) {
        r += s.charAt(i);
      }
      return r;
    }

### Other methods

Strings have many built-in methods.

There is a method that returns a string containing some sub-sequence of the
original string's characters:

    s.substring(2);
    s.substring(1, 4);

The first example returns all but the first 2 characters, and the second example
returns characters starting at index 1 and stopping just before index 4.

You can find the index of a string inside a string:

    s.indexOf("e");
    s.indexOf("el");
    s.indexOf("xy");  // returns -1 if not found

You can check whether a string is contained inside another string:

    s.contains("ll");
    s.contains("LL");

and whether the string has a given prefix or suffix:

    s.startsWith("ll");
    s.endsWith("ll");

There are methods to convert the letter case of a string:

    s.toUpperCase();
    s.toLowerCase();

and to replace one string with another:

    s.replace("l", "x");
    s.replace("lo", "abc");

### Equality

In Java, object instances cannot be compared using ``==``. Instead, you must use
the ``equals()`` method. For example:

    String s = "hello";
    String t = "hello";
    System.out.println(s == "hello");  // false
    System.out.println(s == t);  // false
    System.out.println(s.equals("hello"));  // true
    System.out.println(s.equals(t));  // true

### Example: word count

http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+4&problem=bjp3-4-e18-wordCount

In this problem, we are to count the number of words in a string. A word is
defined here as any sequence of non-space characters, so "a b c", "a-. b_ c" and
"  a    b  c  " all have three words.

    public static int wordCount(String s) {
      int count = 0;
      boolean inSpace = true;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
          if (!inSpace) {
            count++;
          }
          inSpace = true;
        } else {
          inSpace = false;
        }
      }

      if (!inSpace) {
        count++;
      }

      return count;
    }

## Homework

- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+4&problem=bjp3-4-e17-swapPairs
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs,+3rd+edition/BJP3+Chapter+3&problem=bjp3-3-e18-vertical
- http://practiceit.cs.washington.edu/problem.jsp?category=Building+Java+Programs%2C+3rd+edition%2FBJP3+Chapter+3&problem=bjp3-3-s14-parameterMysteryReturn

Do at least:

- three of the exercises from http://codingbat.com/java/String-1
- two of the exercises from http://codingbat.com/java/String-2
- one of the exercises from http://codingbat.com/java/String-3

Print out your solutions to the six problems to hand in next class time.

## Resources

- Java String documentation: http://docs.oracle.com/javase/7/docs/api/java/lang/String.html
- http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic13_procedural_design_4Up.pdf

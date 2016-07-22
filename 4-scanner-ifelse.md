# Java I: Day 4
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/)*

## Intro

Last time: statements, expressions, variables

This time: input, boolean expressions, if/else

## Input Expressions

So far we have looked at programs that only produce output. Here's a way to get
input from the person running your program, using a "Scanner":

```java
import java.util.Scanner;
```

```java
public class Input {
  public static void main() {
    Scanner console = new Scanner(System.in);
    System.out.print("Enter your age: ");
    double age = console.nextDouble();
    System.out.println("Your are " + age + ", really?!");
  }
}
```

This code creates a new variable called ``console`` that lets you call methods
on it (the "." separates the variable name from the method name). Each of these
methods is an **expression** that can be used to put a value in a variable.

There are also methods on the console variable that will read integers, words,
and entire lines:

```java
int i = console.nextDouble();
String s = console.next();
String l = console.nextLine();
```

## Boolean Expressions

A boolean variable is used to represent the binary states of "yes" and "no",
"on"/"off", "true"/"false", etc.
```java
boolean isOldEnough = true;
```

``true`` and ``false`` are the boolean literals.

Booleans are also the results of comparisons between values:

```java
int a = 4, b = 5;
boolean aIsLarger = a > b;
boolean bIsLarger = a < b;
boolean aEqualsB = a == b;
boolean isEven = a % 2 == 0;
boolean isNonNegative = a >= 0;
```

You can also logically combine two booleans using "and" and "or":

```java
boolean bothEven = (a % 2 == 0) && (b % 2 == 0);
boolean eitherEven = (a % 2 == 0) || (b % 2 == 0);
```

## Conditional statements: ``if`` and ``else``

In many programming languages you can get your code to do run statements based
on the value that's stored in a variable. In Java to do this you use ``if`` and
``else``.

To run some statements if a boolean expression is ``true``, use ``if``:

```java
if (<boolean expression>) {
  // these statements run if the expression is true.
  <statement>;
  <statement>;
  // ...
}
```

Example:

```java
Scanner console = new Scanner(System.in);
System.out.print("How many brothers? ");
int brothers = console.nextInt();
System.out.print("How many sisters? ");
int sisters = console.nextInt();
if (brothers + sisters == 0) {
  System.out.println("You're an only child.");
}
```

If the boolean expression evaluates to ``false`` then the computer will "jump
over" the body of the if statement, skipping all of the statements contained
between the curly brackets!

If you want your code to do one thing if an expression is ``true`` and a
different thing if it's ``false``, use ``else``:

```java
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
```

Example:

```java
Scanner console = new Scanner(System.in);
System.out.print("How old are you? ");
int age = console.nextInt();
if (age < 16) {
  System.out.println("Wait " + (16 - age) + " years to drive.");
} else {
  System.out.println("You can get your license!");
}
```

## Return Values and Function Parameters

Your homework will ask you to finish several functions that require "return" values and "parameters". We'll not talk about this significantly until next week, and you won't need to implement anything, but here is a brief outline.

Each function can be thought of as a self-contained capsule, with "input" and "output" wires:

```
        ----
 in1 --|    |
       |    |-- return
 in2 --|    |
        ----
```

Each function can have zero or more input wires and one output wire.

### Return Values
The following function:
```java
public void printHello() {
   System.out.println("Hello, World!");
}
```
can also *return* the value instead of printing it:
```java
public String printHello() {
    return "Hello, World!";
}
```
### Parameters
Functions can also have *parameters*, which are variables with an "unknown" quantity. These variables can be used, unset, in the function. This function will print `Hello, <name>` for any name passed to it.
```java
public void sayHello(String name) {
    System.out.println("Hello, " + name);
}
```
You can run the preceeding function as `sayHello("Nathan");`.

## Homework

### Self-Check
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter4/s2-logicExpressions1
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter4/s3-ifStatementSyntax
 
### Programming
- [Even Odd](https://practiceit.cs.washington.edu/problem/view/bjp3/chapter4/s7-evenOdd): https://practiceit.cs.washington.edu/problem/view/bjp3/chapter4/s7-evenOdd
- [Sleep In](http://codingbat.com/prob/p187868): http://codingbat.com/prob/p187868
- [Monkey Smiling](http://codingbat.com/prob/p181646): http://codingbat.com/prob/p181646
- [Sum Double](http://codingbat.com/prob/p154485): http://codingbat.com/prob/p154485
- [Parrot Trouble](http://codingbat.com/prob/p140449): http://codingbat.com/prob/p140449

## Resources

http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic11_scanner_conditional_execution_4Up.pdf
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic12_more_conditional_cumlative_sum_printf_4Up.pdf

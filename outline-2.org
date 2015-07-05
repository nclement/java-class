#+TITLE: Java Class: Week 2 (27 June)

* Intro
*** Review last class: strings
*** Goals for this class: static methods, variables
* What is Java
*** Bytecode compiler -- translates high-level syntax to machine code
***** Runs on a "virtual machine"
The virtual machine allows a single Java program to run on lots of different
underlying hardware architectures (e.g., phones, desktops, mainframes).
*** Statically typed
*** Garbage-collected
Memory is managed for you by the virtual machine.
*** Object-oriented
Code is grouped into logical "objects" that combine data with functions for
manipulating the data.

We won't talk much about this in this class; it's powerful but complicated!
* Program entry point: main
When a Java class is run as the "main" program, the following method is called:

  public static void main(String[] args)
* Comments
*** Use to annotate your code
/* everything between /* and */ is a comment */

// everything from // to the end of the line is a comment
* Methods
*** Group together logical chunks of operations
To define a method:

  public static void myMethod() {
  // ... put statements here, like System.out.println("hi");
  }

To invoke or "call" a method:

  myMethod();
*** Important to have good names
  public static void c() { ... } // not so great

  public static void printChorus() { ... } // not so great
*** Bottom-up way of defining methods                               :example:
To define methods "bottom-up", think of your program as a long sequence of
commands to be executed. Then find repetition in the sequence, and replace
repeated chunks with methods.
*** Top-down way of defining methods                                :example:
To define methods "top-down", think of how your program "should" work and write
method calls. Then define those methods.
*** Methods can call each other!
If there is a loop in a sequence of method calls, your program will run without
stopping, until it runs out of memory. This generates a Stack Overflow!
* Variables
*** Names for places in the computer's memory
*** Hold specific types of information
In Java, there are several "primitive" ("built-in") types.

- int -- an integer value (positive, zero, or negative)
- double -- a real ("decimal") value
- String -- a sequence of characters
- boolean -- true or false

Assigning the wrong type to a variable can produce an error!
*** Steps for using
1. Declare the variable: "int x"
2. Assign a value to it: "x = 3"
3. Use it: "System.out.println(x)"
* Order of operations (PEMDAS)
- Parentheses
- Exponents (not used in Java)
- Multiplication
- Division
- Addition
- Subtraction
* More Info
*** Slides
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic3staticMethods_StructuredProgramming.pdf
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic4_expressions_and_variables.pdf
*** Hard Way
https://learnjavathehardway.org/book/ex05.html
https://learnjavathehardway.org/book/ex06.html
https://learnjavathehardway.org/book/ex11.html

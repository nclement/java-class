# Java II: Day 1
*(Note: A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/1-file-input-output.html)*

## Intro

### Instructor

- Nathan Clement
- PhD student at UT
- worked as a professional software engineer
- been programming for a long time (started in 8th grade on my TI-83 calculator)
- started with TI-BASIC, first serious class in C++; know Java, C, Perl, Python, Lisp, Javascript, Ruby...

### Goals of the class

- learn more of Java in-depth
- learn about the power of object-oriented languages
- start to develop strength in one programming laguage, learn many programming
techniques
- create your own program in Processing

### By this poing in class, you should understand...
 - variables & expressions
 - functions, parameters, return values
 - Strings and String functions
 - conditional statements
 - loops (both 'definite' (`for`) and 'indefinite' (`while`)
 - file input
 - Exceptions, what throws them, and how to "catch" one

## Warmup
### Puzzle: The Fake Coin

You have twelve coins. You know that one is fake. The only thing that distinguishes the fake coin from the real coins is that its weight is imperceptibly different. You have a perfectly balanced scale. The scale only tells you which side weighs more than the other side.

**What is the smallest number of times you must use the scale in order to always find the fake coin?**

#### Rules:
 - Use only the twelve coins themselves and no others, no other weights, no cutting coins, no pencil marks on the scale. etc.

 - These are modern coins, so the fake coin is not necessarily lighter.

 - Presume the worst case scenario, and don't hope that you will pick the right coin on the first attempt.

### Coding warmup:
https://practiceit.cs.washington.edu/problem/view/bjp3/chapter6/e4-countCoins

-----

## Today: File Input/Output
### Line-Based File Input
Given the file `hours.txt` with the following contents:
```
123 Kim 12.5 8.1 7.6 3.2
456 Eric 4.0 11.6 6.5 2.7 12
789 Stef 8.0 8.0 8.0 8.0 7.5
```
- Consider the task of computing hours worked by each person:
```
Kim (ID#123) worked 31.4 hours (7.85 hours/day)
Eric (ID#456) worked 36.8 hours (7.36 hours/day)
Stef (ID#789) worked 39.5 hours (7.9 hours/day)
```

Flawed solution:
```java
// This solution does not work!
import java.io.*; // for File
import java.util.*; // for Scanner
public class HoursWorked {
  public static void main(String[] args)
      throws FileNotFoundException {
    Scanner input = new Scanner(new File("hours.txt"));
    while (input.hasNext()) {
      // process one person
      int id = input.nextInt();
      String name = input.next();
      double totalHours = 0.0;
      int days = 0;
      while (input.hasNextDouble()) {
        totalHours += input.nextDouble();
        days++;
      }
      System.out.println(name + " (ID#" + id + ") worked " + totalHours 
                         + " hours (" (totalHours / days) + " hours/day)");
    }
  }
}
```
&rarr; Why doesn't this work?

The best solution requires a hybrid approach:
 1. break the overall input into lines
 2. break each line into individual tokens
 3. use a `while`-loop to determine how many tokens there are

Line-based useful file methods:
```java
nextLine() // returns the next entire line of input
hasNextLine() // returns true if there are more lines of input
hasNext() // returns true if there is another token in the input
hasNextDouble() // returns true if the next thing is a double
hasNextInt() // returns true if the next thing is an int
```

Java's `Scanner` class is versatile: can be used for input/output, reading from files, even reading from Strings:
```java
Scanner input = new Scanner(new File("input.txt"));
while (input.hasNextline()) {
  String line = input.nextLine();
  Scanner lineScan = new Scanner(line);
  // Process the contents of the line
  int count = 0;
  while (lineScan.hasNext()) {
    String word = lineScan.next();
    count++;
  }
  System.out.println("Line has " + count + " words");
}
```

### File output
Writing to a file is easy, just like reading from one, except we use a `PrintStream` object. The following will *create a new file or overwrite an existing one* called `out.txt`:
```java
PrintStream output = new PrintStream(new File("out.txt"));
output.println("Hello, file!");
output.println("This is a second line of output.");
```
Important things about `PrintStream`:
 - if the file does not exist, it is *created*
 - if the file **does** exist, it is *overwritten*
 - the output will not appear in the console; you'll need to open the file with an editor to see it
 - do not open the same file for both reading (`Scanner`) and writing (`PrintStream`) at the same time
   - you'll overwrite your input file with an empty file

Can also use the `PrintStream` object to hold `System.out`, so you can write a versatile function:

```java
// Processes an employee input file and outputs each employee's hours.
import java.io.*; // for File
import java.util.*; // for Scanner
public class Hours2 {
   public static void main(String[] args) throws FileNotFoundException {
     Scanner input = new Scanner(new File("hours.txt"));
     PrintStream out = new PrintStream(new File("hours_out.txt"));
     while (input.hasNextLine()) {
       String line = input.nextLine();
       processEmployee(out, line);
     }
   }
   public static void processEmployee(PrintStream out, String line) {
     Scanner lineScan = new Scanner(line);
     int id = lineScan.nextInt(); // e.g. 456
     String name = lineScan.next(); // e.g. "Eric"
     double sum = 0.0;
     int count = 0;
     while (lineScan.hasNextDouble()) {
       sum = sum + lineScan.nextDouble();
       count++;
     }
     double average = sum / count;
     out.println(name + " (ID#" + id + ") worked " + sum + " hours (" + average + " hours/day)");
   }
}
```

### Advanced file reading
Small files are not interesting. How would you write a program that reads through a large file with the following input, then determines how many hours a given employee has worked? The program should work like this:
```
Enter an ID: 456
Eric worked 37.8 hours (7.36 hours/day)
Enter an ID: 293
ID #293 not found
```

It is good practice to break your code into smaller pieces. Create the following functions:
 - `public static void processLine(String line)`, which prints out how many hours a given person has worked
 - `public static String findPerson(Scanner input, int searchId)`, which looks through a given file for the user ID specified; will return `""` upon failure
 - a main method that calls both of the previous functions

#### Advanced file reading
Consider the following file from IMDB (modified slightly):
```
490400 9.1 The Shawshank Redemption (1994)
392937 9.1 The Godfather (1972)
232741 9.0 The Godfather: Part II (1974)
```
 - Write a program that displays any movies containing a phrase.
 - Write a program that searches for all programs that have a ratings and number of votes higher than specified.

#### Mixing tokens and lines
As a word of warning, be careful when mixing token-readers and line-readers. For example, given the following file:
```
23   3.14
Joe   "Hello world"
        45.2 19
```
What would the following code produce?
```java
System.out.println(input.nextInt()); // 23
System.out.println(input.nextDouble()); // 3.14
System.out.println(input.nextLine()); // ???
```

Remember where the cursor ends up!
```java
input.nextInt() // 23
// 23\t3.14\nJoe\t"Hello world"\n\t\t45.2 19\n
//   ^
input.nextDouble() // 3.14
// 23\t3.14\nJoe\t"Hello world"\n\t\t45.2 19\n
//         ^
input.nextLine() // "" (empty!)
// 23\t3.14\nJoe\t"Hello world"\n\t\t45.2 19\n
//           ^
input.nextLine() // "Joe\t\"Hello world\""
// 23\t3.14\nJoe\t"Hello world"\n\t\t45.2 19\
//                               ^
```

## Homework
 - Do two problems from here: http://codingbat.com/java/String-1
 - Do two problems from here: http://codingbat.com/java/String-2
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter6/e14-printDuplicates
 
## Resources
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic18_file_input_tokens_4Up.pdf
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic19_file_input_lines_4Up.pdf
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic20_more_file_processing_4Up.pdf

# Java I: Day 10
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/10-files.html)*

## Intro

### Last time: strings

### This time: files

## File Storage

Files are just stored as a bunch of zeros and ones as well, but sometimes it's nice to have a way to view the file. We call this file format ASCII.

Here's how you read from a file.

1. Create a `File` object to get info about a file (this won't actually *create* the file, but will give you information about a file if it should exist):
```java
import java.io.File;

public class FileFun {
  public static void main(String[] args) {
    File f = new File("example.txt");
    if (f.exists() && f.length() > 1000) {
      f.delete();
    }
  }
}
```
Make sure you're specifying the **absolute path** or **relative path** of the file (assumed to be relative to the *current directory*). Can find the  *current directory* using the following code:
```java
System.out.println("Current Directory = " +
                    System.getProperty("user.dir"));
```
2. Create a `Scanner` object (just like reading from the keyboard) and give it your file as a parameter (instead of `System.in`):
```java
File file = new File("mydata.txt");
Scanner input = new Scanner(file);
```

### Exceptions

When you try and run the following code, you'll most likely get an error message like the following:
```
ReadFile.java:6: unreported exception java.io.FileNotFoundException;
must be caught or declared to be thrown
        Scanner input = new Scanner(new File("data.txt"));
                        ^
```

Before this point, there have only been two types of errors:
1. syntax errors (prevent you from compiling), and
2. logic errors (ID-ten-tee errors)

But there's a third class of errors, *runtime errors*, than can be caused by a few things:
 - dividing a number by zero
 - trying to get the index of a character in a string that doesn't exist
 with `s.charAt(10)`
 - trying to read a double from the `Scanner` when it sees a `String`
 - trying to read from a file that doesn't exist.

Whenever a *runtime* error occurs, the program "throws an exception"

Exceptions can also be "caught":
```java
try {
  File file = new File("mydata.txt");
  Scanner input = new Scanner(file);
  System.out.println("The file exists!");
}
catch(FileNotFoundException e) {
  System.out.println("Error: File not found!!");
}
```

### Input Tokens

**token**: A unit of user input, separated by whitespace

A `Scanner` splits the file into tokens. Consider the file:
```
23  3.14
     "John Smith"
```
The `Scanner` will just interpret the file as a string of characters:
```
23  3.14\n     "John Smith"
```
and read the following tokens:

    token  |  type(s)
    -------|------
    23     | `int`, `double`, `String`
    3.14   | `double`, `String`
    "John  | `String`
    Smith" | `String`

#### Consuming Tokens
The `Scanner` has a "cursor", that it uses to keep track of where the next token will be. Consider a file `weather.txt` that has the following in it:
```
16.2  23.5
   19.1 7.4     22.8

18.5  -1.8 14.9
```
The "cursor" starts at the beginning, and consumes tokens as it goes:
```java
// 16.2  23.5\n   19.1 7.4     22.8\n\n18.5  -1.8 14.9
// ^

double d = input.nextDouble(); // 16.2
// 16.2  23.5\n   19.1 7.4     22.8\n\n18.5  -1.8 14.9
//       ^

String s = input.next(); // "23.5"
// 16.2  23.5\n   19.1 7.4     22.8\n\n18.5  -1.8 14.9
//                ^
```

### Creating Files
It's important to keep in mind when creating a file that you will have to read from it some other time. For example, in the following file, it's easy to separate out columns:
```
Nathan teacher 75
Ryan student 71
Anne student 73
```
But from this file, can you tell where the name starts and ends?
```
Nathan Clement Austin London
Jonathan Austin Johnson San Antonio Orlando
Stephanie Dallas Houston
```
--------

Exercise: The definition of a .ppm file can be found here: http://netpbm.sourceforge.net/doc/ppm.html

Every three numbers represents the rgb values of a "pixel" of an image. Plot these pixels as squares, filled with the specified value. See if you can determine what these images are showing:
 - http://cs.utexas.edu/~nclement/aces/img/mystery.ppm
 - http://cs.utexas.edu/~nclement/aces/img/mystery2.ppm

## Homework
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter6/e2-evenNumbers
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter6/e4-countCoins
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter6/e9-wordWrap
 
 - Spend some time playing around with Processing. Find something you'd like to solve with programming, and **DO IT**!! You can only get better by enjoying the Art of Programming.

## Final Thoughts
It's been a great two weeks! Hopefully I'll see you in Java II, but if not, have a great summer and go win at some [agar.io](http://agar.io/)!!

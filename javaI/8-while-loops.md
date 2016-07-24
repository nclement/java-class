# Java I: Day 8
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/8-while-loops.html)*

## Intro

### Last time: functions, breaking up problems

### This time: while-loops, loop patterns

## `while` Loops
Categories of loops:
 - **definite loop**: Executes a known number of times
   - Print "hello" 10 times
   - Find all the prime numbers up to a number `n`
   - Print each odd number between 5 and 127
 - **indefinite loop**: The number of times a loop repeats is not known in advance
   - Prompt the user until they type a non-negative number
   - Print random numbers until a prime number is printed
   - Repeat until the user presses 'q' to quit

### The `while` loop
```java
while(<test>) {
  <statement(s)>;
}
```
The `while` loop can be thought of as a repeating `if`-statement.
For example, this will print once:
```java
int num = 1;
if (num <= 200) {
  System.out.print(num + " ");
  num = num * 2;
}
```
but the following will repeatedly evaluate the *condition* until it is **not** satisfied (how many times will it run?)
```java
int num = 1;
while (num <= 200) {
  System.out.print(num + " ");
  num = num * 2;
}
```

Consider the following problem:
> Find the first factor of a given number, `n`

Should we design a `for`-loop? How many steps would it take?

Here is the solution with a `while`-loop
```java
int factor = 2;
while (n % factor != 0) {
  factor++;
}
System.out.println("First factor is " + factor);
```
## Loop Patterns

### Fence-post Pattern
Your task:
 > Write a method `printNumbers` that prints each number from 1
 > to a given maximum, separated by commas.
 >
 > For example, the call
 > 'printNumbers(5)' should print `1, 2, 3, 4, 5`

Can we do this with `for`-loops? Can we do it with `while`-loops?

The answer is deceptively difficult, but can be solved with the fence-post analogy: Assume we need to build a fence with *n* posts separated by wooden beams. If we use a flawed method, we would have too many beams
```
|---|---|---|---
|---|---|---|---
|   |   |   |   
```
The solution is to add a statement outside the loop to place the initial "post":
```java
public static void printNumbers(int max) {
  System.out.print(1);
  for (int i = 2; i <= max; i++) {
    System.out.print(", " + i);
  }
  System.out.println(); // to end the line
}
```
Alternatively, we could remove the last "post":
```java
public static void printNumbers(int max) {
  for (int i = 1; i <= max - 1; i++) {
    System.out.print(", " + i);
  }
  System.out.println(max); // to end the line
}
```

Using the homework from last time, write a method that prints all the prime numbers up to a maximum in a comma-separated list. For example, `printPrimes(50)` will print `2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47`

### Sentinel Values
**sentinel**: A value that signals the end of user input

For example:
 > Write a program that calculates the average number of Pok&eacute; Balls
 > the person has gathered since they got their Pok&eacute;mon app. Since you
 > don't know when they got it, keep prompting them for numbers until they type
 > `-1`.

How many times should this loop run? Since we don't know, we can use an *indefinite* loop:
```java
Scanner console = new Scanner(System.in);
double sum = 0; // double so it can be used for an average
int count = 0;
int number = -2; // "dummy" value, anything but -1

while (number != -1) {
  System.out.print("Enter the next value: ");
  number = console.nextInt();
  sum += number;
  count++;
}

System.out.println("You have an average of " + sum/count + " Pokeballs");
```

Three important pieces to having a sentinel value:
 1. Creating a variable *outside* the loop, and initializing it to a non-sentinel value 
 2. Having a `while`-loop that checks for the sentinel value
 3. Requesting the response from the user *inside* the loop (updating the variable)

What sentinel values should we choose for the following programs:
 - Prompting the user to enter temperatures, and we'll print out the average
 - Prompting the user for words, and we'll output the total number of characters
 - Prompting the user to guess our secret number

## Final notes for today:
### While-loops and global variables in Processing
Last time, we tried to only print 10 balloons, but instead we ended up printing many balloons. Why was that? You can think of the `draw()` method in Processing as a giant `while`-loop: it will keep running as long as the program exists. If you want to limit the number of balloons the program generates, you need a *global* variable (that exists outside the scope of the `draw()` method) and just an `if`-statement inside. Like this:
```Processing
int count = 1;

void setup() {
  size(800, 650);
  background(255);
}

void draw() {
  if (count <= 10) {
    drawBalloon(random(800), random(650), random(100), random(120), 
                color(random(255), random(255), random(255)));
  }
  count++; // Don't forget to increment count!
}

void drawBalloon(float x, float y, float balloonSize, float lineHeight, color c) {
  fill(c);
  stroke(0);
  ellipse(x,y, balloonSize, balloonSize);
  // Draw a line from the bottom of the balloon down a bit
  line(x, y + balloonSize / 2, x, y + balloonSize / 2 + lineHeight);
}
```

### Random in Java
Last time, we went over generating random numbers in Processing. You can also generate them in Java, like this:
```java
Random rand = new Random();
for (int i = 1; i <= 10; i++) {
  int r = rand.nextInt(50); // generates a random number between 0 and 49
  System.out.println(r);
}
```

## Homework
- https://practiceit.cs.washington.edu/problem/view/bjp3/chapter5/e1-showTwos

- Write a program that will flip a coin until there is a run of 10 flips of the same side in a row. This program will print out the total number of flips. (hint: use `rand.nextInt(2)` and let `0` be heads and `1` be tails)

- Last time in class, we wrote a program that will print out a bunch of balloons. Modify your program to print out balloons until the total mass of all the balloons is greater than 1000. Assume each balloon is perfectly spherical and the mass is computed by the volume of the balloon: 4/3 &pi; r<sup>2</sup>

## Resources

 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic14_while_loops_loop_patterns_4Up.pdf
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic15_string_boolean_methods_random_numbers_4Up.pdf

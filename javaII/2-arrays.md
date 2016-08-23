# Java II: Day 2
*(Note: A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/2-arrays.html)*

## Intro

### Review last time: file input, file output

### Goals for this class: learn about arrays

## Warmup

https://practiceit.cs.washington.edu/problem/view/bjp3/chapter6/e17-inputStats

## Arrays

How would you solve the following problem?
> Given an entire month's worth of temperatures, determine how many months
> were above the average.

It's not solvable as-is, because we need each value twice:
 1. to compute the average
 2. to count how many were above average

We need a way to declare many variables in the same step.

```java
<type>[] <name> = new <type>[<number>]
```
where `number` is any constant number or expression. For example:
```java
System.out.print("Enter the number of days: ");
int numDays = console.nextInt();
double[] temps = new double[numDays];
```
 - Each element gets a "zero-equivalent" value to start with:

   Type     | Default value
   ---------|--------------
   `int`    | `0`
   `double` | `0.0`
   `boolean`| `false`
   `String` | `null` (means "no object")

Accessing elements:
```java
<name>[<index>]; // access
<name>[<index>] = <value>; // modify
```

### Out-of-bounds
Like Strings, legal indices are betwen 0 and the arrays length - 1. Each array has a `length` field, that can be used to access the length. For example
```java
int[] data = new int[10];
data[3] = -2;
data[9] = -1;
data[6] = 4;
System.out.println(data[6]);  // okay, 4.0
System.out.println(data[0]);  // okay, 0.0
System.out.println(data[3]);  // okay, -2.0
System.out.println(data[10]); // exception
System.out.println(data.length - 1); // okay, -1

// index [ 0   1   2    3   4   5   6   7   8    9 ]
// value [ 0 | 0 | 0 | -2 | 0 | 0 | 4 | 0 | 0 | -1 ]
```

Exercise: Print out a histogram of the temperatures in Austin.

### The `Arrays` class
Limitations of arrays:
 - cannot resize an existing array
 - cannot compare arrays with `==` or `equals`
 - cannot print an array

The `Arrays` class:
 - `binarySearch(<array>, <value>)`: returns the index of the given value in a **sorted** array (or <0 if not found)
 - `copyOf(<array>, <length>)`: returns a new copy of an array
 - `equals(<array1>, <array2>)`: return `true` if two arrays contain the same elements
 - `fill(<array>, <value>)`: sets every element in the array to the given value
 - `sort(<array>)`: arranges the elements into sorted order
 - `toString(<array>)`: returns a string representing the array

Exercise: Print out the two hottest and two lowest temperatures during the week

### Arrays as parameters
To use an array as a parameter, follow the same format as normal parameters:
```java
public static double average(int[] numbers) {
  int sum = 0;
  for (int i = 0; i < numbers.length; i++) {
    sum += numbers[i];
  }
  return (double) sum / numbers.length;
}
```

## Homework
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/s10-max
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/s21-swapPairs
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/e1-lastIndexOf
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/e4-isSorted

## Resources
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic21_arrays1_4Up.pdf
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic22_arrays2_4Up.pdf

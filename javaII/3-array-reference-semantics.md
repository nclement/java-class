# Java II: Day 3
*(Note: A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/3-array-reference-semantics.html)*

## Intro

### Review last time: arrays

### Goals for this class: more arrays, reference semantics

## Warmup

https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/s17-allLess
https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/s30-isPalindrome
http://codingbat.com/prob/p148972

## Arrays as References

### Arrays as parameters and return values
Arrays can be used as parameters, or return values (or both!). What does the following method do?
```java
public static int[] stutter(int[] numbers) {
  int[] result = new int[2 * numbers.length];
  for (int i = 0; i < numbers.length; i++) {
    result[2 * i] = numbers[i];
    result[2 * i + 1] = numbers[i];
  }
  return result;
}
```
Just like other variable types, we can "remember" the value from an array function:
```java
int[] iq = {126, 84, 149, 167, 95};
int[] stuttered = stutter(iq);
```

### The `Arrays` class (not covered last time)
Limitations of arrays:
 - cannot resize an existing array
 - cannot compare arrays with `==` or `equals`
 - cannot print an array

The `Arrays` class:
 - `binarySearch(<array>, <value>)`: returns the index of `value` in **sorted** `array` (or <0 if not found)
 - `copyOf(<array>, <length>)`: returns a new copy of `array`
 - `equals(<array1>, <array2>)`: return `true` if `array1` and `array1` contain the same elements
 - `fill(<array>, <value>)`: sets every element in `array` to the `value`
 - `sort(<array>)`: arranges the elements in `array` into sorted order
 - `toString(<array>)`: returns a string representing `array`

Exercise: Print out the two hottest and two lowest temperatures during the past week. Use the following array as input:
```
int[] temps = {93, 102, 101, 101, 102, 101, 101, 100};
```

### Reference Semantics
Does the following `swap` method work? Why or why not?
```java
public static void main(String[] args) {
  int a = 7;
  int b = 35;
  // swap a with b?
  swap(a, b);
  System.out.println(a + " " + b);
}
public static void swap(int a, int b) {
  int temp = a;
  a = b;
  b = temp;
}
```
After the function has been called, `a` and `b` return to their former values (unchanged!)

 * **value semantics**: variables are *copied* whenever they are assigned, passed as parameters, or returned.
   * Java uses value semantics for all primitive types (`String`, `double`, `int`, etc)
 * **reference semantics**: variables actually store the *address* of another object in memory
   * when one variable is assigned to another, the object is *not* copied; both variables refer to the **same** object.
   * modifying the value of one variable *will* affect others
```java
int[] a1 = {4, 15, 8};
int[] a2 = a1;  // refer to the *same* array as a1
a2[0] = 7;
System.out.println(Arrays.toString(a1)); // [7, 15, 8]
```

Why does Java use reference semantics for objects and arrays?
 * copying large objects slows down a program
 * it's useful to share an object's data among methods

#### Notable "exception" to reference semantics:
 * If the parameter is assigned to a new value within the function, the change will not be reflected in the calling method.
```java
public static void main(String[] args) {
  int[] arr = {5, 5, 5, 5, 5};
  changeMe(arr);
  System.out.println(Arrays.toString(arr)); // prints out [5, 5, 0, 5, 5]
}
public static void changeMe(int[] arr) {
  arr[2] = 0;
  arr = new int[5];
  arr[0] = 0;
  arr[1] = 10;
  arr[2] = 20;
  arr[3] = 30;
  arr[4] = 40;
}
```

## Array Algorithms
### Using Input As Indices
Consider the following problem:
> Write a method `mostFrequentDigit` that returns the digit that occurs
> most frequently in the number.
>
> For example, the number 669260267 contains one 0, two 2's, four 6's,
> one 7, and one 9: return 6

The setup would be as follows:
```java
public static int mostFrequentDigit(int d) {
  while (d > 0) {
    int digit = d % 10; // Get the last digit
    d /= 10;            // Strip off the last digit of d
    // Do something with the value digit
    // ...
  }
  // Return the largest digit (not -1)
  return -1; // What to return here?
}
```
 * One solution might be to create 10 variables, `count0`, `count1`, `count2`, ...
 * Better solution is to use an array of size 10
   * each element at index `i` will store the counter for the digit that is the same as `i`

For example, for 669260267:
```
index [ 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 ]
value [ 1 | 0 | 2 | 0 | 0 | 0 | 4 | 1 | 0 | 0 ]
```

Can add to the above program as:
```java
public static int mostFrequentDigit(int d) {
  int[] counts = new int[10];
  while (d > 0) {
    int digit = d % 10; // Get the last digit
    d /= 10;            // Strip off the last digit of d
    counts[digit]++;
  }
  // Find the largest digit
  int maxDigit = 0;
  for (int i = 0; i < 10; i++) {
    if (counts[i] > counts[maxDigit]) {
      maxDigit = i;
    }
  }
  return maxDigit;
}
```

Tallies can be used for many other things:
 * random numbers between 1 and 1000
 * exam scores
 * characters in a file
 * etc...

## Homework
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/e12-priceIsRight
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/e11-isUnique

## Resources
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic22_arrays2_4Up.pdf
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic23_arrays3_4Up.pdf

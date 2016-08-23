# Java II: Day 4
*(Note: A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/4-array-algorithms.html)*

## Intro

### Review last time: arrays and reference semantics

### Goals for this class: array algorithms

## Warmup
- http://codingbat.com/prob/p199484
- http://codingbat.com/prob/p196976
http://codingbat.com/prob/p193753

## Searching Arrays
Given an array of numbers, what's the *best* way to find if a target number exists?
 * If I have an array of 1,000,000 distinct elements in random order, how many items do I expect to look at when searching if
   * the item **is** present?
   * the item **is not** present?

If I'm writing an array search method, what should I `return` if
 * the item is present?
 * the item is not present? (think "sentinel values")

### Sequential Search
Sequential search is the easiest (but not most efficient) method for searching an array

```java
/**
 * Returns the index of the value, or -1 if it's not found
 */
public static int sequentialSearch(int[] arr, int value) {
  for (int i = 0; i < arr.length; i++) {
    if (arr[i] == value) {
      return 0;
    }
  }

  return -1;
}
```

Can I do faster than sequential search?

### Binary Search
If the items are sorted, then we can *divide and conquer*

Consider the following piece of code (which just so happens to be the very first game I ever programmed on my TI-83 calculator):
```java
import java.util.Scanner;
import java.util.Random;
public class Guess {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    Random rand = new Random();
    int high = 1000;
    // Keep playing the game as long as the user requests it.
    boolean keepGoing = true;
    while(keepGoing) {
      int secretNum = rand.nextInt(high);
      int guesses = 1;
      System.out.println("I'm thinking of a number between 0 and " + high);
      System.out.print("Enter your guess: ");
      int guess = console.nextInt();

      // Keep going until the user has guessed it
      while(guess != secretNum) {
        if (guess > secretNum) {
          System.out.print("Too high. Enter another number: ");
        } else {
          // I know I'm not equal, so I must be too low.
          System.out.print("Too low. Enter another number: ");
        }
        guess = console.nextInt();
        guesses++;
      }

      System.out.println("Correct! Took you " + guesses + " guesses.");
      System.out.println("Go again? (enter 'Y'): ");
      String yorn = console.next();
      if (yorn.equalsIgnoreCase("Y")) {
        keepGoing = true;
      } else {
        keepGoing = false;
      }
    }

    System.out.println("Goodbye!");
  }
}
```
What's the fastest way to always guarantee finding a match?

Binary search performs the following on a given array.:
 1. Given two indices, `low` and `high`, look at the number at position `(low+high)/2` (divide the list in half)
 2. If the number was too low, change `low` to the guessed position
 3. If the number was too high, change `high` to the guessed position
 4. If `low` and `high` are the same, return -1, otherwise go back to step 1
 
This is the fastest method. However, it requires the list to be **sorted**. This is also a difficult problem.

## Sorting Arrays
What's the best way to sort an array of numbers? How do you find a method that is both *fast* and *space efficient*?

Excercise: try sorting a deck of cards and clearly write out the algorithm you follow (can you?)

### Selection Sort
To sort a list:
 - Find the smallest item in an array
 - Swap that item with the first item in the array
 - Continue with the next items in the array until all have been sorted

Can we make it any faster?

### Insertion Sort
To sort a list:
 - The first element is sorted.
 - Compare the second element with the first. 
   - if it's smaller, swap
   - otherwise stay the same
 - Compare the third element with the second.
   - if it's smaller, swap, compare against the first
   - otherwise, stay the same
 - Continue until the entire array has been sorted.

Can we make it faster? What's the *best* case, *worst* case, and average case?

### Quick Sort
As it turns out, the fastest (common) sorting algorithm is the following:
 - Divide the list until it only has two elements
   - sort the two elements (this is easy)
 - Merge two sorted lists
 - Keep merging until you've sorted the entire list.

### Running Time Complexity
In computer science, we care a lot about complexity. It might not matter with small arrays, but if it took 1 second to look up a credit card number, how long would you wait at the store before your credit card was accepted or rejected? When there are 60 million credit card numbers to look through, it better not take 60 million seconds.

## Homework
 - http://codingbat.com/prob/p105031
 - http://codingbat.com/prob/p164144

## Resources
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic24_sorting_searching_arrays_4Up.pdf

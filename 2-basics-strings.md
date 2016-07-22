# Java 1: Day 2
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/)*

## Intro

### Review last class: binary numbers, bitwise operations

### Goals for this class

## Why program?

### Need to solve a problem

- compute the average of a lot of numbers
- suggest spelling corrections to a person
- schedule routes for delivery trucks

### Computer scientists devise *algorithms* to solve these problems

Algorithm: like a recipe.

Exercise: write down a recipe for making cookies.

High level:
- Gather ingredients
- Mix ingredients
- Place on cookie sheet
- Bake

Lower level needed to break down steps into unambiguous parts. "Gather
ingredients" might become:
- Measure out 1c flour, 1c butter, etc.
- Be sure to use semi-sweet chocolate!
- Etc.
* What is programming

In an important sense, programming is the translation of an algorithm into
instructions for a computer to follow.

But computers operate using bits?!

### Languages allow control at a higher level

- Machine code: bits
- Assembly: mnemonics
- High-level languages: blocks

### Language has *syntax* and *semantics*

Consider these sentences:
- the dog ate the spaghetti with meatballs
- ate the the with dog meatballs spaghetti

The second one doesn't make any sense because it violates the rules of syntax in
English. This is a "syntax error."

Now consider:
- colorless green ideas sleep furiously

All of the words in this sentence make sense in their syntactic roles, but this
sentence doesn't make sense because the words together violate the rules of
semantics ("meaning") -- what is a "colorless green idea"?

## First example program

```java
public class Hello {
    public static int main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

## Strings

- represent sequences of characters
- enclosed in double quotes
- display messages to user of program: System.out.println(message)

### escaping

To include " inside a string, it must be *escaped* by preceding it with a
backslash (\):

`\"` -> escaped double quote

If you want to include a \ inside a string, it must be escaped too:

`\\` -> escaped backslash
```
System.out.println("\""); // prints "
System.out.println("\"\\"); // prints "\
```
### Special characters

There are several "whitespace" characters that are commonly used. They are not
visible, but instead move the "cursor" around when printing things.

- space character: '` `'
- newline character: '`\n`'
- tab character: '`\t`'

### How many visible characters are printed?

    "hello world!" (11)
    "\"" (1)
    "\\'\\\\\"" (5)
    "\n" (0)
    " here  we  are" (9)

## Homework
1. Complete the assignment Song.java, that will print out the lyrics to the song "I know an old woman who swallowed a fly." Use the start program at http://cs.utexas.edu/~nclement/aces/Song.java to help you out. You can find more details for the assignment at https://www.cs.utexas.edu/~scottm/cs312/assignments/A1Song.html
2. Complete the following PracticeIt programs:
  1. https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e1-Stewie
  2. https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e2-Spikey
  3. https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e3-WellFormed
  4. https://practiceit.cs.washington.edu/problem/view/bjp3/chapter1/e4-Difference

## More Info

- http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic2JavaBasics.pdf
- https://learnjavathehardway.org/book/ex01.html
- https://learnjavathehardway.org/book/ex02.html
- https://learnjavathehardway.org/book/ex04.html

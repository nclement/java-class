# Java I: Day 1

## Intro

### Instructor

- Nathan Clement
- PhD student at UT
- worked as a professional software engineer
- been programming for a long time (started in 8th grade on my TI-83 calculator)
- started with TI-BASIC, first serious class in C++; know Java, C, Perl, Python, Lisp, Javascript, Ruby...

### Goals of the class

- learn some parts of a programming language
- learn what programming is like
- discover whether programming is an interest

### About the class

- taking algebra?
- interest in programming?
- why are you taking the class?
- email? apps on phone? ...

# Computer Architecture

## What is a computer

- computers are everywhere!

- hardware over time

|        | 1984 (IBM PC/AT) | 2016 (OnePlus Three)   | 2044 (?) |
|--------|------------------|------------------------|----------|
| Cost   |      1 500 $     |              399 $     | ?        |
| CPU    |  6 000 000 Hz    | 4x 2 200 000 000 Hz    |          |
| RAM    |    256 000 bytes |    6 000 000 000 bytes |          |
| Disk   | 20 000 000 bytes |   64 000 000 000 bytes |          |
| Weight |         30 lbs   |   158 grams (0.35 lbs) |          |

So in about 30y, computers have become about 1000x faster, 1000x cheaper (with
inflation), and offer about 1000x more storage.

In addition, the 2014 computer  offers a number of features that didn't exist in 1984: wifi (there was almost no such thing as networking for PCs in 1984), cameras, GPS, etc.

What will things look like in another 30y?

## Basic architecture

CPU + RAM + HD

- CPU: central processing unit. executes instructions.
- RAM: random access memory. stores information. erased when computer turns off.
- HD: hard drive. stores information. preserved when computer turns off.

## Bits ("binary digits")

- computer manipulates bits ==> on/off ==> high/low voltage

In base 10, a number like 384 actually means "three hundred and eighty and
four":

384 = 300 + 80 + 4 = 3 * 10^2 + 8 * 10^1 + 4 * 10^0

It turns out we can write numbers in other bases too. If we are limited to
binary, then we have to work in base 2, and the numerals available are 0 and 1.

In binary, a number like 101 actually means "one four and no twos and one":

101 = 1 * 2^2 + 0 * 2^1 + 1 * 2^0

## Basics

### Converting to binary

Here's an algorithm for converting a number from base 10 (decimal) to base 2 (binary). Suppose we have a number x written in decimal (for example, the number 11). The algorithm will compute the digits of x written in binary, moving from left to right.

1. Find a number, p, such that 2^p is greater than x
2. Is 2^p less than or equal to x? If so, write one and subtract 2^p from x; if not, write zero
3. Subtract one from p
4. Is p = -1? If so, finish. Otherwise, move one place to the right and repeat with step 2.


Example:

x = 6 (decimal) = ___ (binary)

1. 2^3 = 8, so let p = 3
2. No, write down a 0: 0; x remains 6
3. Subtract one from p; p = 2
4. No, p is not -1; go to step 2
5. Yes; subtract 2^2 from x and write one: 01; x becomes 2
6. Subtract one from p; p = 1
7. No, p is not -1; go to step 2
8. Yes; subtract 2^1 from x and write one: 011; x becomes 0
9. Subtract one from p; p = 0
10. No, p is not -1; go to step 2
11. No, write a zero: 0110; x remains 0
12. Yes! Finished, and 6 (decimal) is 0110 (binary)


### Bitwise operations

CPUs implement normal arithmetic operations (addition, multiplication, etc.) as well as special operations that work bit-by-bit.

Bitwise AND (&)

Output bit is 1 if both input bits are 1; 0 otherwise.

```
| a b | a & b |
|-----|-------|
| 0 0 |   0   |
| 0 1 |   0   |
| 1 0 |   0   |
| 1 1 |   1   |
```

Examples:

```
0101 & 0110 = 0100
0101 & 0111 = 0101
0101 & 1011 = 0001
```

Bitwise OR (|)

Output bit is 1 if either input bit is 1; 0 otherwise.

```
| a b | a | b |
|-----+-------|
| 0 0 |   0   |
| 0 1 |   1   |
| 1 0 |   1   |
| 1 1 |   1   |
```
Examples:
```
0100 | 0110 = 0110
0100 | 0111 = 0111
0100 | 1011 = 1111
```
## Installing a Java Development Environment

We will use the BlueJ editor for the class. To install it, go to
http://bluej.org and download the installer for your computer's operating
system. We'll start using it in class next week.

## Homework

### Convert following to binary

3, 1, 63, 64, 65, 0, 5213

### Write as binary
<table>
<tr><td> 3 & 4 </td><td> 1 & 15 </td><td> 0 & 7 </td><td> 4 & 7 </td></tr>
<tr><td> 3 | 4 </td><td> 1 | 15 </td><td> 0 | 7 </td><td> 4 | 7 </td></tr>
<tr><td> 3 * 4 </td><td> 1 * 15 </td><td> 0 * 7 </td><td> 4 * 7 </td></tr>
<tr><td> 3 + 4 </td><td> 1 + 15 </td><td> 0 + 7 </td><td> 4 + 7 </td></tr>
</table>

## More Information

Have a look at the first 9 slides from Mike Scott's online Java course:
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic2JavaBasics.pdf

#+TITLE: Java Class: Week 0 (13 June)

* Intro
*** Instructor
***** phd student at ut
***** worked as a professional software engineer
***** been programming for a long time
***** started with Logo, know Java, C, Python, Go, Javascript, Ruby...
*** Goals of the class
***** learn some parts of a programming language
***** learn what programming is like
***** discover whether programming is an interest
*** About the class
***** taking algebra?
***** interest in programming?
***** why are you taking the class?
***** email? apps on phone? ...
* About Computers
*** What is a computer
***** computers are everywhere!
***** hardware over time
|        | 1984 (IBM PC/AT) | 2014 (Moto G)          | 2044 (?) |
|--------+------------------+------------------------+----------|
| Cost   |      1 500 $     |               50 $     | ?        |
| CPU    |  6 000 000 Hz    | 4x 1 200 000 000 Hz    |          |
| RAM    |    256 000 bytes |    1 000 000 000 bytes |          |
| Disk   | 20 000 000 bytes |    8 000 000 000 bytes |          |
| Weight |         30 lbs   |                8 oz    |          |

So in about 30y, computers have become about 1000x faster, 1000x cheaper (with
inflation), and offer about 1000x more storage.

In addition, the 2014 computer  offers a number of features that didn't exist in
1984: wifi (there was almost no such thing as networking for PCs in 1984),
cameras, GPS, etc.

What will things look like in another 30y?
*** Basic architecture
***** often have cpu + memory + storage
*** Bits ("binary digits")
***** manipulate bits ==> on/off ==> high/low voltage              :exercise:

In base 10, a number like 384 actually means "three hundred and eighty and
four":

384 = 300 + 80 + 4 = 3 * 10^2 + 8 * 10^1 + 4 * 10^0

It turns out we can write numbers in other bases too. If we are limited to
binary, then we have to work in base 2, and the numerals available are 0 and 1.

In binary, a number like 101 actually means "one four and no twos and one":

101 = 1 * 2^2 + 0 * 2^1 + 1 * 2^0

* Basics
*** Arithmetic
***** conversion to binary                                         :exercise:

Here's an algorithm for converting a number from base 10 (decimal) to base 2
(binary). Suppose we have a number x written in decimal (for example, the number
11). The algorithm will compute the digits of x written in binary, moving from
right to left.

1. Is x zero? If so, we're done.
2. Is x odd? If so, write down a 1 and subtract 1 from x. If not, write zero.
3. Divide x by 2 and move one place to the left.
4. Repeat with step 1.

Example:

x = 7 (decimal) = ___w (binary)
(the "w" marks the place where we will write our next binary digit)

1. No, x = 7.
2. Yes: write a 1 in the w: ___1 (binary), x = 7 - 1 = 6 (decimal)
3. Move w to the left: __w1 (binary), x = 6 / 2 = 3 (decimal)
4. Go to step 1.
1. No, x = 3.
2. Yes: write a 1 in the w: __11 (binary), x = 3 - 1 = 2 (decimal)
3. Move w to the left: _w11 (binary), x = 2 / 2 = 1 (decimal)
4. Go to step 1.
1. No, x = 1.
2. Yes: write a 1 in the w: _111 (binary), x = 1 - 1 = 0 (decimal)
3. Move w to the left: w111 (binary), x = 0 / 2 = 0 (decimal)
4. Go to step 1.
1. Yes! 111 is the binary representation of 7.

***** bitwise operations                                           :exercise:

CPUs implement normal arithmetic operations (addition, multiplication, etc.) as
well as special operations that work bit-by-bit.

Bitwise AND (&)

Output bit is 1 if both input bits are 1; 0 otherwise.

| a b | a & b |
|-----+-------|
| 0 0 |   0   |
| 0 1 |   0   |
| 1 0 |   0   |
| 1 1 |   1   |

Examples:

0101 & 0110 = 0100
0101 & 0111 = 0101
0101 & 1011 = 0001

Bitwise OR (|)

Output bit is 1 if either input bit is 1; 0 otherwise.

| a b | a | b  |
|-----+-------|
| 0 0 |   0   |
| 0 1 |   1   |
| 1 0 |   1   |
| 1 1 |   1   |

Examples:

0100 | 0110 = 0110
0100 | 0111 = 0111
0100 | 1011 = 1111

* Installing a Java Development Environment

We will use the BlueJ editor for the class. To install it, go to
http://bluej.org and download the installer for your computer's operating
system. We'll start using it in class next week.

* Homework
*** Convert following to binary

3, 1, 63, 64, 65, 0, 5213

*** Write as binary

| 3 & 4, 1 & 15, 0 & 7, 4 & 7
| 3 | 4, 1 | 15, 0 | 7, 4 | 7
| 3 * 4, 1 * 15, 0 * 7, 4 * 7
| 3 + 4, 1 + 15, 0 + 7, 4 + 7

* More Information
*** Slides
Have a look at the first 9 slides from Mike Scott's online Java course:
http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic2JavaBasics.pdf

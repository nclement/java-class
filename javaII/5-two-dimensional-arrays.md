# Java II: Day 5
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/two-dimensional-arrays.html)*

## Intro

Last time: array algorithms

This time: two-dimensional arrays

## Warmup
- http://codingbat.com/prob/p102145
- http://codingbat.com/prob/p169506


## Two-Dimensional Arrays
What is a 2D array and why is it useful? A lot of times we want to create matrices, or tables. For example, assume we wanted to record how many times each of our favorite basketball teams won during the season, we might record this in a table. If we have 5 teams, assign each a number between 0 and 4. The number of games won might look like:
```
team ID:   0 | 1 | 2 | 3 | 4  | wins 
       ---------------------  |
       0 |   | 4 | 2 | 0 | 3  | 9
       1 | 1 |   | 0 | 0 | 2  | 3
       2 | 3 | 5 |   | 5 | 4  | 17
       3 | 5 | 5 | 0 |   | 4  | 14
       4 | 2 | 3 | 1 | 1 |    | 7

 losses  |11 |17 | 3 | 6 |13
```
From this table, I can see that team 2 beat team 3 five times (look accross the row for wins) and lost to team 0 twice (look down columns for losses).

There are many other uses for arrays. We'll get into one major one at the end of the class.

2D arrays can be created in Java in a similar fashion to 1D arrays:
```java
int[][] mat = new int[3][4];
```
This constructs an array that has 3 rows (the first number) and 4 columns (second number).

To loop over an array, use these pointers with `i` and `j` indices:
```java
for (int i = 0; i < mat.length; i++) {
  for (int j = 0; j < mat[i].length; j++) {
    mat[i][j] = i * j; // this is now a multiplication table
  }
}
```

### Reference Semantics
Remember references from last time? If I declare the following array:
```java
int[][] mat = new int[10][7]
```
I will have several *references* to remember:
 - `mat` will be a reference to the *entire array*
 - `mat[0]` or `mat[r]` are a reference to a *single row*
 - `mat[0][1]` or `mat[r][c]` are the *values* of single elements

**Note that there is *no way* to refer to a single column**

### "Jagged" Arrays
Because of the reference semantics, I can also create **jagged arrays**--arrays that have a different number of columns in each row. For example:
```java
int[][] jagged = new int[10][];
jagged[0] = new int[5];
jagged[1] = new int[3];
jagged[2] = new int[1];
jagged[3] = new int[20];
jagged[4] = new int[42];
```
Most of the time you won't need to worry about jagged arrays, but make sure your `for`-loops are using `mat[i].length` just in case.

## Conway's Game of Life
Today's programming project will be to develop Conway's Game of Life. 

The Game of Life takes place on a grid (2-dimensional array). Each cell of the grid is considered either "alive" or "dead." Each cell also interacts with its eight neighbors, which are the cells that are horizontally, vertically, or diagonally adjacent to the cell.

The Game of Life proceeds in "generations", or steps. At each step, the following transitions occur:
 - If the cell is "alive," there are three rules:
   1. If the cell has fewer than two live neighbors, it dies--as if by under-population.
   2. If the cell has more than three live neighbors, it dies--as if by over-population.
   3. If a cell has exactly two or three live neighbors, it survives to the next generation.
 - If the cell is "dead," the following rule applies:
   1. If a dead cell has exactly three live neighbors, it becomes alive in the next generation, as if by reproduction.

Each of these rules apply only to members of the next generation.

### Implementation in Processing
You should probably implement a couple of things:
 - Design a grid with square cells. You should have a grid (`boolean[][] grid`)that represents the current generation, and another one that represents the next generation. After you've finished setting the grid for the next generation, you should swap the two grids.
 - Design a method to activate cells in the grid by clicking on the screen. You should look for the `mouseX` and `mouseY` location and determine which cell of the grid it corresponds to. Every time the mouse clicks, it should make a cell active or inactive.
 - Implement a method to draw the grid. Color "alive" cells differently from "dead" cells.
 - Implement all the rules. You might want to consider the following method:
   - `int getNumAliveNeighbors(boolean[][] grid, int i, int j)`, which gets the number of "alive" neighbors for the designated grid. Pay special attention to corner cases (what are the horizontal neighbors of the cell at `0,0`?)
 - Have a way to "start" or "stop" the interaction. Perhaps it should be controlled by the `void keypressed()` function from Processing, which is called every time a key on the keyboard is pressed.

After you're done, make sure it works. For example, the following patterns will continue forever:
 - The "glider":
```
  X
   X
 XXX
```
 - The "Beacon"
```
 XX
 X
    X
   XX
```
 - The "Pulsar"
```
   XXX   XXX

 X    X X    X
 X    X X    X
 X    X X    X
   XXX   XXX

   XXX   XXX
 X    X X    X
 X    X X    X
 X    X X    X

   XXX   XXX
```
## Homework
 - http://codingbat.com/doc/array.html
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/e19-matrixAdd

## More Info
 - https://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic26_2DArrays_4Up.pdf

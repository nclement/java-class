# Java II: Day 6
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/6-classes-objects.html)*

## Intro

Last time: two-dimensional arrays

This time: classes and objects

## Warmup

https://practiceit.cs.washington.edu/problem/view/bjp3/chapter7/e19-matrixAdd

## Java Classes
### Parallel data
Consider the following problem:
> Given a file with a list of two-dimensional coordinates of restaurants,
> write a program to plot all the restaurants on a map, and then color each
> restaurant red that is within "walking distance" from a certain location.
```
6
50 20
90 60
10 72
74 98
5 136
150 91
```

One solution:
```java
Scanner input = new Scanner(new File("restaurants.txt"));
int restCount = input.nextInt();
int[] xCoords = new int[restCount];
int[] yCoords = new int[restCount];

for (int i = 0; i < restCount; i++) {
  xCoords[i] = input.nextInt();
  yCoords[i] = input.nextInt();
}
...
```
This solution uses **parallel arrays**: 2 (or more) arrays with related data at the same indices
 - Could be a third array of type `String` that contains the names of each restaurant
 - Considered poor programming *style* because the relationship exists in the programmers mind, but is not explicit in the program
   - need to make sure each array is the same length
   - everywhere you add to one, make sure you add to another
   - "off-by-one" errors can cause mayhem and are really hard to debug.

### Encapsulating data in "objects": Java `class`
Each x,y coordinate could be stored together in a `Point` object
 - A `Point` would store the city's x/y data
 - Each `Point` would know how to draw itself
 - Each `Point` would know its walking distance from the point of interest
 - Program could could be "refactored" to make debugging easier

<dl>
<dt><code>class</code></dt>
<dd><ol><li>A program/module, or</li>
        <li>A template for a new type of objects</li></ol></dd>
<dt><code>object</code></dt>
<dd>An entity that combines *state* and *behavior*.
<dt>object-oriented programming</dt>
<dd>Programs that perform their behavior as interactions between objects</dd>
<dd>
</dl>
</dl>
Java is an "object-oriented programming language", so classes and objects are fundamental to the language:
 - `String` class has functions like `indexOf()`, `length()`, `equalsIgnoreCase()`
 - `Random` class has functions like `nextInt()`
 - `Scanner` class works with files, URLs, ...

#### Important distinction:
 - A `class` is the description of an object (think: a blueprint for a house)
 - An *object* is an actual creation of the class (think: the actual house)

You can't call `Random.nextInt(3);` because `Random` is the *name* of the class. `Random r = new Random()` will create an *object* named `r` of type `Random`, which you can actually call the class functions.


### "State", "Behavior", and "Abstraction"
An important distinction between state and behavior:
 - state: the things an object contains (the characters in a `String`, the current position of a `Scanner`, etc)
 - behavior: the functions a class can do (create new objects, get the next random number, etc)

Designing a class with state and behavior allow us to utilize the concept of **abstraction**:
 - a distancing between ideas and details
 - allows us to treat a class like a "black box"
   - we don't know what goes on inside, nor how it works, we only need to know it behaves as promised
   - do you know the hardware in your laptop??
   - creating *good* random numbers is actually really difficult [this article](http://scienceblogs.com/cognitivedaily/2007/02/05/is-17-the-most-random-number/) suggests that 17 is the most common number between 1 and 20

### Object-Oriented Programming Design
Going back to the `Point` example, what would we need to design a `Point` class?
 - the `x` and `y` location of each point (**state**)
 - the ability to plot the `Point` on the screen (**behavior**)
 - the ability to determine the distance from a given location (**behavior**)

#### Class State
Start by giving our class some state, or the x and y locations.
```java
public class Point {
  int x;
  int y;
}
```
 - Every time you create an object, it will have *its own copy* of each field
 -  You can access each field by creating an object, and then saying something like `variable.field`:
```java
Point p1 = new Point(); // Create one object that has its own x- and y-coordinates
Point p2 = new Point(); // Create a second object that has its own (different) x- and y-coordinates
p1.x = 13;  // modify
p1.y = 15;  // modify
System.out.println("the x-coord of p1 is " + p1.x); //access
```

#### Class behavior
Classes also have methods. We can create a method to draw a point in Processing:
```Processing
void drawPoint(Point p) {
  ellipse(p.x, p.y, 3, 3);
  text("(" + p.x + ", " + p.y + ")", p.x, p.y);
}
```
But this puts the drawing code for the `Point` outside the `Point` class. We'd like to be able to put everything a `Point` should do inside the `Point` class.

To enable a class to use its member variables, define a function normally, but without the `static` keyword:
```Processing
public class Point {
  int x;
  int y;

  public void draw() {
    // Same as the global function, but use *my* variables
    ellipse(x, y, 3, 3);
    text("(" + x + ", " + y + ")", x, y);
  }
}
```

### Combining state and behavior
 - Create a class called Restaurant that behaves similar to the Point class, only each restaurant has a name associated with it. Using the data located [here](http://www.cs.utexas.edu/~nclement/aces/javaII/restaurants_small.txt), plot the location of each restaurant.
 - Update your program to use this [large list of restaurants](http://www.cs.utexas.edu/~nclement/aces/javaII/restaurants.txt) to color each restaurant red if they're close to the mouse, black otherwise.

## Homework
### Self-Check:
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/s2%2DwhatIsAnObject
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/s7%2DName

### Programming
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/s11%2DgetNormalReverseOrderName
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e3%2DmanhattanDistancePoint
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e2%2DflipPoint

## More Info
 - http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic27_classes_objects_1_4Up.pdf

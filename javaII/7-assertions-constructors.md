# Java II: Day 7
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/7-assertions-constructors.html)*

## Intro

Last time: intro to classes and objects

This time: assertions; class constructors

## Warmup

 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/s11%2DgetNormalReverseOrderName

## Assertions
What is output by the following program?
```java
public static void mysteryB(boolean b) {
  System.out.print(b + " ");
  b = (b == false); 
  System.out.print(b);
}
```
<dl>
<dt>assertion</dt>
<dd>a declarative sentence that is either true or false</dd>
</dl>
For example:
 - It is raining
 - I am playing agar.io
 - I should be paying attention in class
 - 2 + 2 equals 4
 - `x > 45`

Not assertions (why?):
 - How old are you?
 - Take me to the nearest Pokestop

Sometimes, assertions are *always* true or false:
 - 2 + 2 equals 4

Other times, they are *contextually* true or false (depends on the context):
 - `x > 45`
 - It is raining
 - Yesterday was the hottest day in history

One of the greatest tasks in writing good programs requires deciding the *context* of assertions.

Assertions can come in many different forms, some of which we've seen:
 - user input
 - assertions from conditionals
 - random numbers
 - function parameters

...and also in things we've just begun to talk about
 - constructors and object functions

### Assertions in input
Can we say anything about the value of variable `result` here?
```java
Scanner console = new Scanner(System.in);
System.out.print("Enter Y or N: ");
String result = console.nextLine();
// is result equal to "Y" or "N" here?
```
What about in this code snippet?
```java
Scanner console = new Scanner(System.in);
System.out.print("Enter Y or N: ");
String result = console.nextLine();
while(!result.equals("Y") && !result.equals("N")) {
  System.out.print("That wasn't a Y or N. ");
  System.out.print("Enter Y or N: ");
  result = console.nextLine();
}
// is result equal to "Y" or "N" here?
```

### Assertions from random numbers
Can we say anything about the value of the variable `result` here?
```java
Random rand = new Random();
int result = rand.nextInt(100);
if (result > 20) {
  result = rand.nextInt(50) + 150;
}
// what is the value of result here?
```

### Functional assertions
Sometimes the variable we want to make an assertion about is not "random" in the sense that it either comes from the user or a random number, but that it might be unexpected. When we write functions, we should be able to handle input in any form.

Can we say anything about the value of the variable `result` here?
```java
public static int mystery(int x) {
  int result = 0;
  if (x > 20) {
    result = -1;
  }
  if (x < 20) {
    result = 1;
  }
  return result;
}
```
When we write functions, they should work for *any* input, not just the ones we would like. For example, the following is a bad method for writing an matrix duplication method:
```java
public static int[][] doubleMatrix(int[][] input) {
  int[][] doubled = new int[input.length][input[0].length]; // A
  for (int i = 0; i < input.length; i++) {                  // B
    for (int j = 0; j < input[i].length; j++) {             // C
      doubled[i][j] = input[i][j] * 2;                      // D
    }
  }
  return doubled;                                           // E
}
```
Which point in our method might return an error?
### Conditional assertions
Suppose you have the following code:
```java
if (x > 3) {
  // A
  x--;
} else {
  // B
  x++;
  // C
}
// D
```
What do you know about the value of `x` at each of the four points?
 - Is `x > 3`? 
   - Always?
   - Sometimes? 
   - Never?

### Reasoning about programs
Right after a variable is initialized, its value is known:
```java
int x = 3;
// is x > 0? ALWAYS
```
In general, you know nothing about parameters' values
```java
public static void mystery(int a, int b) {
  // is a == 10? SOMETIMES
}
```
Inside an `if`, `while`, or other statements, you may know something:
```java
public static void mystery(int a, int b) {
  if (a < 0) {
    // is a == 10?  NEVER
    ...
  }
}
```

Things that cause a variable's value to be unknown (often leads to "sometimes" answers):
  - reading from a Scanner
  - reading a number from a Random object
  – initial value of a parameter in a method

If you can reach a part of the program both with the answer being "yes" and the answer being "no", then the correct answer is "sometimes”.

For the following snippet of code, decide whether each assertion is ALWAYS, NEVER, or SOMETIMES:
```java
public static void mystery(int x, int y) { 
  int z = 0;
  // Point A
  while (x >= y) {
    // Point B
    x = x - y;
    z++;
    if (x != y) {
      // Point C
      z = z * 2;
    }
    // Point D
  }
  // Point E
  System.out.println(z);
}
```
         | `x < y` | `x == y` | `z == 0`
      ---|---------|----------|--------
 Point A |         |          |
 Point B |         |          | 
 Point C |         |          |
 Point D |         |          |
 Point E |         |          |

## Object constructors
Consider the following code:
```Processing
public class Dot {
  String name;
  float x;
  float y;

  /**
   * Draws the name, bigger if the name is longer
   */
  public void drawName() {
    textSize(name.length);
    text(name, x, y);
  }
}
```
What is wrong with the `drawName()` method?

We need to make sure certain *assertions* have been made, but how can we be certain the `name` field is filled in?

### Constructors
When you create a new object, you are also calling a method:
```java
Random rand = new Random();
```
Notice that the `new Random()` above has parenthesis, suggesting it is a function call. In fact, it is a function call: a "constructor".

Every object can only be created with these constructors. We can leverage constructors to make sure assertions are filled. A constructor does not have a return type, and also must have the same name as the class, as follows:
```Processing
public class Dot {
  String name;
  float x;
  float y;
  public Dot() {
    name = "none"; // make sure name is always valid
  }

  /**
   * Draws the name, bigger if the name is longer
   */
  public void drawName() {
    textSize(name.length);
    text(name, x, y);
  }
}
```
We can have different constructors:
```java
public class Dot {
  String name;
  float x;
  float y;
  public Dot() {
    name = "none"; // make sure name is always valid
  }
  public Dot(float myX, float myY, String myName) {
    x = myX;
    y = myY;
    name = myName;
  }
  ...
}
```
In fact, if we don't supply the "default constructor" (constructor with no parameters), a user cannot create an object without parameters:
```java
public class Dot {
  String name;
  float x;
  float y;
  public Dot(float myX, float myY, String myName) {
    x = myX;
    y = myY;
    name = myName;
  }
  ...
}

public class DotUser {
  public static void main(String[] args) {
    Dot d1 = new Dot(10, 50, "cool user"); // okay
    Dot d2 = new Dot(); // won't compile
  }
}
```
### Private member variables
Constructors also allow us to make variables "private". In the previous code, we might want to make sure `x` and `y` are always valid (positive). But it is also possible to access the variables if they're public:
```java
Dot d1 = new Dot(10, 50, "cool user");
d1.x = -20;
d1.y = -200;
d1.name = "I JUST TOOK OVER THE WORLD!!";
```
For this reason, we'd like to make member variables "private" and only provide access through a prescribed method. We could have "getters" and "setters" that provide this interface:
```java
public class Dot {
  private int x; // private means they can't be altered by somebody else
  private int y;
  private String name;

  public Dot(int initialX, int initialY) {
    // Make sure they're positive
    if (initialX < 0) {
      initialX = 0;
    }
    if (initialY < 0) {
      initialY = 0;
    }
    // Assertion: Are initialX and initialY ever negative here?
    x = initialX;
    y = initialY;
  }
  public void setX(int newX) {
    if (newX < 0) {
      newX = 0;
    }
    // Assertion: Is newX ever > 0 here?
    x = newX;
  }

  public void setName(String n) {
    // Don't need to check anything here.
    name = n;
  }
  public String getName() {
    return name;
  }
  // Etc...
}
```
We could even go so far as to throw an assertion if the method was incorrect:
```java
import java.lang.IllegalArgumentException;

public class Dot
  private int x;
  private int y;

  public Dot(int initialX, int initialY) {
    // Make sure they're positive
    if (initialX < 0) {
      throw new IllegalArgumentException("x is negative!!");
    }
    if (initialY < 0) {
      throw new IllegalArgumentException("y is negative!!");
    }
    // Assertion: Are initialX and initialY ever negative here?
    x = initialX;
    y = initialY;
  }
  public void setX(int newX) {
    if (newX < 0) {
      throw new IllegalArgumentException("x is negative!");
    }
    // Assertion: Is newX ever > 0 here?
    x = newX;
  }
  // Etc...
}
```

Private variables also let us use things that other people don't need to know about. For example, we might also want to include the length of our string in the class. We might save it in a variable called `length`. However, if we created a `Dot d = new Dot()`, what would we expect the `d.length` method to return??

## Homework
### Self-Check
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter5/s28%2Dassertions2
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter5/s29%2Dassertions3

### Programming
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e18%2DclassRectangle

## More Info
 - http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic17_assertions_4Up.pdf
 - http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic28_classes_objects_2_4Up.pdf

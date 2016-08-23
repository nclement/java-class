# Java II: Day 10
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/10-polymorphism-arraylists.html)*

## Intro

Last time: inheritance, extends

This time: polymorphism, `ArrayList`

## Warmup

 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter9/e4%2DMonsterTruck
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter9/e10%2DDiscountBill

## Polymorphism
**Polymorphism**: The ability for the same code to be used with different types of objects and behave differently with each.
 - `System.out.println` can print *any* type of object (how?)
 - `CritterMain` can interact with any type of critter
   - each one implements the `move()`, `fight()`, etc., functions
   - (does every class implement these methods?)

How does this differ from *inheritance*?
**Inheritance**: A way to form new classes based on existing classes, taking on their attributes/behavior

### Coding with Polymorphism
When you have a lot of objects of the same type, sometimes you'd like to place them all in an array and call the same method on each of them. For example:

```java
LemonadeSalesperson ed = new LemonadeChef();
```
You can call any methods from the `LemonadeSalesperson` class on `ed`. This only works because `LemonadeChef` is a subclass of `LemonadeSalesperson`.

#### Functions with Polymorphism
It's beneficial to use the most generic parameter types with each function. For example, you could write:
```java
public class LemonadeMain {
  public static double getAllChefWages(LemonadeChef[] chefs) {
    double wages = 0;
    for (int i = 0; i < chefs.length; i++) {
      wages += chefs[i].getWage() * chefs[i].getNumHours();
    }
    return wages;
  }
  public static double getAllUnionizedStandBuilderWages(UnionizedStandBuilder[] usbs) {
    // ...
  }
  public static double getAllAccountsReceivableWages(AccountsReceivable[] ars) {
    // ...
  }
}
```
However, since each subclass inherits methods from LemonadeStandsperson, it would be easier (and a lot cleaner) to declare a single array with *all* employees and just write:
```java
public class LemonadeMain {
  public static double getAllWages(LemonadeStandsperson[] people) {
    double wages = 0;
    for (int i = 0; i < people.length; i++) {
      wages += people[i].getWage() * people[i].getNumHours();
    }
  }
}
```
In a function, you can pass any subtype of a parameter's type.

### Polymorphism and Arrays
Arrays of any superclass can store any subtype as elements:
```java
public classe LemonadeMain {
  public static void main(String[] args) {
    LemonadeSalesperson[] people = {new LemonadeStandsperson(), new StandBuilder(),
                                    new LemonadeChef(), new UnionizedStandBuilder()};
    for (int i = 0; i < people.length; i++) {
      System.out.println("wage: " + people[i].getWage());
      System.out.println("num hours worked: " + people[i].numHoursWorked());
    }
  }
}
```

### Basic Behavior of `Object`s
As it turns out, *every* class by default inherits from the same class: the `Object` class. This class contains a couple of methods:
 - `public boolean equals(Object obj);`
 - `public String toString()`;

By default, these return something not very intelligible (whether the memory location is the same for the `equals` method and the memory location for the `toString()` method. However, we can override these methods:
```java
public class LemonadeStandsperson {
  private String name;
  private int id;

  // ...

  public String toString() {
    return "Employee #" + id + " who is named " + name;
  }
}
```
The `equals` method requires a bit more subtlety. Remember how to cast a `double` into an `int`? You can do the same with objects. In addition, there is a comparator called `instanceOf` that tells you if one object is of a particular type or not.
```java
  public boolean equals(Object obj) {
    // If I'm not comparing against another LemonadeStandsperson, they're not the same.
    if (!(obj instanceof LemonadeStandsperson)) {
      return false;
    }
    // If my memory location is the same, it's the same object
    if (obj == this) {
      return true;
    }
    // Check and see if my name and ID are the same.
    LemonadeStandsperson other = (LemonadeStandsperson)obj;
    if (other.name.equals(name) && other.id == id) {
      return true;
    }
    // Why don't I need the "else" here?
    return false;
  }
```
However, this might break when we have subclasses. You might try and use a symmetric `equals` construct (`return this.blindlyEquals(obj) && obj.blindlyEquals(this);`).

### Exercises:
 - Implement the `move` function in both the `User` and `Food` subclasses of `Dot`
 - Implement the `equals` method for a standard playing card.

## ArrayList
Consider the following problem:
> Write a program that reads a file and displays the words of that file in a list
> 
> First, display all the words
>
> Then, display ass the words ending in "s" (plural)

Obviously, we need an array (why?).

How big should we make the array?
 - Problem: we don't know how many words the file will have until we've read the file.

### Collections
**collection**: an object that stores data (a.k.a. "data structure")
 - many different kinds of Java collections: `ArrayList`, `LinkedList`, `HashMap`, ...
 - all collections are in the `java.util` package.:w

### ArrayList functions
ArrayLists behave similarily to normal arrays, but have several added functions:

        function     | behavior
        ------------ | -------- 
 `add(value)`        | adds a value to the end of the list 
 `add(index, value)` | inserts `value` to the index just before `index` 
 `clear()`           | removes all element of a list 
 `indexOf(value)`    | returns the first index where `value` is found (or -1 if not found) 
 `get(index)`        | returns the value at `index` (same as `[]` for arrays) 
 `remove(index)`     | removes the value at `index`, shuffling subsequent values to the left 
 `set(index, value)` | sets the value at `index` to `value` 
 `size()`            | returns the number of elements in the list (like the `length` variable for normal arrays) 
 `toString()`        | returns a `String` representing the array (like `Arrays.toString(myOtherArray);`) 
 ...                 | [...etc...](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)

When declaring an `ArrayList`, you must tell Java what type it is:
```java
ArrayList<String> names = new ArrayList<String>();
names.add("Nathan");
names.add("Ryan");
names.add("Anna");
```

### ArrayList of primitives
You cannot build an `ArrayList` of just a primitive (`int` or `double`, etc). However, there are wrapper classes:
```java
// create a list of ints
ArrayList<Integer> list = new ArrayList<Integer>();
```

### Exercise
 - Create a program that counts the number of unique words in a file. Every time you see a new word, add it to the end of the `ArrayList`
 - Change your `agar` program to use an `ArrayList` of type `Dot` that has both food, people, and bot dots

## More Info
 - http://www.cs.utexas.edu/%7Escottm/cs312/handouts/slides/topic32_polymorphism_4Up.pdf
 - http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic33_array_lists_4Up.pdf

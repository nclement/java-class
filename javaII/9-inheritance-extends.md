# Java II: Day 9
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/9-inheritance-extends.html)*

## Intro

Last time: classes case study

This time: inheritance, extends

## Warmup

 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e13%2DtransferBankAccount

## Inheritance
Assume you're the owner and proprietor of a small company of lemonade salesman. You own several lemonade stands, and it's gotten to the point where you need to make a rulebook to guide you.
 - Each lemonade standsperson needs to attend orientation
 - Each lemonade standsperson receives a 20-page manual of common rules
 - Everyone also receives a smaller (1-3 page) manual of specific jobs, depending on their role (lemonade pourer, stand builder, advertising, etc)
   - this smaller manual adds some rules and changes some others from the large manual

### Lemonade Stand Regulations
Consider the following regulations:
 - Lemonade standspersons should work 20 hours per week
 - Lemonade standspersons are entitled to one free glass of lemonade per shift, except the lemonade chef, who needs to taste each new batch of lemonade
 - All employees make $8/hour, except the stand builder, who makes $10/hour (need to be concerned about safety)

Each standsperson also has some unique behavior:
 - Lemonade chefs (and only the chefs) know the recipe, and also how to mix it
 - Advertising people know how to twirl the sign
 - Stand builders know how to build new stands and repair old stands
   - accounts receivable (takes your money) also knows how to do minor repairs. When s/he does these repairs, he can ask for an additional $1/hour on that shift

### Designing `LemonadeStandsperson` class:
```java
public class LemonadeStandsperson {
  public int getHours() {
    return 20;
  }

  public double getWage() {
    return 8.0;
  }

  public String getRuleFormColor() {
    return "yellow"; // use the yellow form
  }

  public int getNumFreeGlasses() {
    return 1;
  }
}
```
If we were to implement a lemonade chef class, it might look something like the previous class:
```java
public class LemonadeChef {
  public int getHours() {
    return 20;
  }

  public double getWage() {
    return 8.0;
  }

  public String getRuleFormColor() {
    return "blue"; // use the yellow form
  }

  public int getNumFreeGlasses() {
    return 20; // one glass per hour
  }

  public String getRecipe() {
    return "I'm not allowed to say";
  }
}
```

The only differences are the `getNumFreeGlasses()` method and the `getRecipe()` method. We'd like to be able to reuse code.

### Inheritance
**inheritance**: A way to form new classes based on existing classes, taking on their attributes/behavior
 * a way to group related classes
 * a way to share code between one or more classes

One class can *extend* another, absorbing its data/behavior
 * **superclass**: The parent class that is being extended
 * **subclass**: The child class that is being extended
   * a subclass gets a copy of every field and method from superclass
   * instead of using the keyword `private`, you should use the keyword **`protected`** to allow subclass variables to actually edit this variable.

Syntax:
```java
public class <name> extends <superclass>
```
Example:
```java
public class LemonadeChef extends LemonadeStandsperson {
  public String getRuleFormColor() {
    return "blue";
  }
  public int getNumFreeGlasses() {
    return 20; // one glass per hour
  }

  public String getRecipe() {
    return "I'm not allowed to say";
  }
}
```

### Changes to common behavior
Suddenly, your company is doing much better, and you'd like to give everyone a raise--plus, since the chef is mainly responsible for your good fortune, you'd like to give her an extra $0.50/hour raise.

How should the code be modified?

```java
public class LemonadeStandsperson {
  ...
  public double getWage() {
    return 9.0;
  }
}

public class LemonadeChef extends LemonadeStandsperson {
  ...
  public double getWage() {
    return super.getWage() + 0.5;
  }
}
```

By using the `super` keyword, we can call the method that belongs to the superclass. Then, when we want to change the wage for all employees, we only need to change it in one place.

## Homework
 - Implement a `User` class that uses much of the `Dot` class, except it goes toward the mouse instead of moving toward a random location
 - Implement a `Food` class that uses much of the `Dot` class, except it doesn't move at all.

## More Info
 - http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/Topic31_inheritance.pdf
 - http://www.cs.utexas.edu/%7Escottm/cs312/handouts/slides/topic32_polymorphism_4Up.pdf

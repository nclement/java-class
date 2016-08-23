# Java II: Day 8
*(A link to these notes may be found at http://www.cs.utexas.edu/~nclement/aces/javaII/8-classes-case-study.html)*

## Intro

Last time: assertions; class constructors

This time: case study in creating classes

## Warmup

 - https://practiceit.cs.washington.edu/problem/view/cs1/exams/midterms/midterm10/assertions
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e18%2DclassRectangle

## Deck of Cards Case Study
By this point in time, you should be comfortable with classes and objects. The material today is meant to be more practice of the same material. We won't learn any new concepts (hopefully), but we will probably gain new insight.

The goal of this class period is to design a deck of cards, suitable for playing any game.

### Functionality of `Card`
Needed state (member variables):
 - card suit (spade, heart, diamond, club)
 - card number (ace, two, three, ..., king)

Needed functionality (member methods):
 - getters and setters (?)
 - methods for printing the type of card (`getColor()`, `getRank()`)
 - method for getting the "alternate" value (if it exists, like an ace)
 - return `true`/`false` if two cards are of the same rank (static method)
 - return `true`/`false` if two cards are of the same color (static method)

### Functionality of `Deck`
Needed state (member variables):
 - deck of cards
 - cards already dealt

Needed functionality (member methods):
 - method to draw the next card (randomly)
 - method to shuffle and/or reset the deck

### Functionality for Blackjack
The goal is to have a hand of cards where the value equals 21. Aces can count as either 1 or 11.

The game commences as follows:
 - The dealer deals every player two cards, face up.
 - The dealer deals himself one card face up, one card face down
 - Each player can either "stand" (no more cards) or "hit" (take one more card from the deck). Each card after the first two are dealt face-down.

Each player needs to get as close as s/he can to 21 without going over. Once all the players have played, the dealer plays. The dealer has two rules:
 - If the dealer's points total less than or equal to 16, s/he must take another "hit"
 - If the dealer's points total 17 or more, s/he must "stand"

Each player is trying to beat the dealer. Betting can ensue if needed.

### Functionality for the game of war
Rules can be found [here](https://www.pagat.com/war/war.html)
 - Two players start playing cards. Each player plays one card.
 - Whichever player is highest gets to keep that card
 - If there is a tie, a game of 'war' will commence:
   - each player plays one card face down, then the next card face up
   - if the cards are the same, repeat above step
   - otherwise, the winner gets all cards (6 at the first step)
 - Game continues until there are no more cards left.

How would this game differ from Blackjack? This should be played with two decks of cards
 - methods for removing cards from a deck and adding more to a deck.

## Case study on Critters
Given time, we will go over the Critters program (found [here](http://cs.utexas.edu/~nclement/aces/javaII/Critters.zip))

## Homework
### Programming
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e11%2DtransactionFeeBankAccount
 - https://practiceit.cs.washington.edu/problem/view/bjp3/chapter8/e13%2DtransferBankAccount

## More Info
 - http://www.cs.utexas.edu/~scottm/cs312/handouts/slides/topic28_classes_objects_2_4Up.pdf

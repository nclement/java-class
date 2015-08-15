import java.util.Scanner;

public class HumanVsComputer {
  public static void main(String[] args) {
    System.out.println("Prisoner's Dilemma!");

    Scanner console = new Scanner(System.in);

    int total1 = 0;
    int total2 = 0;

    for (int i = 0; i < 20; i++) {
      char action1 = choose1(console);
      char action2 = choose2();
      System.out.println("Player 1 chooses " + action1 +
                         ", Player 2 chooses " + action2);
      int s1 = score1(action1, action2);
      int s2 = score2(action1, action2);
      System.out.println("Player 1 gets " + s1 + ", Player 2 gets " + s2);
      total1 += s1;
      total2 += s2;
      System.out.println("Score so far: " + total1 + " (Player 1) vs " +
                         total2 + " (Player 2)");
    }

    System.out.println("Final score: " + total1 + " (Player 1) vs " +
                       total2 + " (Player 2)");
  }

  public static int score1(char action1, char action2) {
    if (action1 == 'c' && action2 == 'c') {
      return 2;
    } else if (action1 == 'c' && action2 == 'd') {
      return 0;
    } else if (action1 == 'd' && action2 == 'd') {
      return 1;
    } else {  // this covers the case: action1 == 'd' && action2 == 'c'
      return 3;
    }
  }

  public static int score2(char action1, char action2) {
    if (action1 == 'c' && action2 == 'c') {
      return 2;
    } else if (action1 == 'c' && action2 == 'd') {
      return 3;
    } else if (action1 == 'd' && action2 == 'd') {
      return 1;
    } else {  // this covers the case: action1 == 'd' && action2 == 'c'
      return 0;
    }
  }

  public static char choose1(Scanner console) {
    //return 'c';
    System.out.println();
    System.out.print("Choose an action (c or d): ");
    return console.next().charAt(0);
  }

  public static char choose2() {
    return 'd';
  }

  public static char choose3() {
    return (Math.random() < 0.5) ? 'c' : 'd';
  }
}

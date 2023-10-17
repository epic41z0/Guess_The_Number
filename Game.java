package GameMaking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
    private Menu menu = new Menu();

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int randomNum = random.nextInt(100) + 1;
    private List<Integer> score = new ArrayList<>();
    
    

    private boolean gamePlay = true;
    private int playerGuess;
    private int tryCount = 0;
    private int gissning = 1;    


    

    public void startGame() {

        System.out.println("Välkommen till gissa talet!");
        System.out.println("Gissa ett tal mellan 1 och 100: ");

        while (gamePlay) {
            try {
                playerGuess = scanner.nextInt();
                tryCount++;
                System.out.println("Gissning " + gissning + ": " + playerGuess);
                gissning++;

             
                if (playerGuess == randomNum) {
                    System.out.println("\nGrattis du gissade rätt!\n");
                    gamePlay = false;
                    score.add(tryCount);
                    Collections.sort(score);
                    if (score.size() > 5) {
                        score.remove(score.size() - 1);
                    }
                    displayMenu();
                } 
                
                else if (playerGuess < randomNum) {
                    System.out.println("Talet är högre än det du har matat in. Försök igen!");
                }

                else {
                    System.out.println("Talet är lägre än det du har matat in. Försök igen!");
                }
            } 
            
            catch (InputMismatchException e) {
                System.out.println("Du måste mata in en siffra mellan 1-100:");
                scanner.next();
            }

    
        }
        
    }


    private void startNewGame() {
        randomNum = random.nextInt(100) + 1;
        System.out.println("Gissa ett tal mellan 1 och 100: ");
        gamePlay = true;
        tryCount = 0;
        gissning = 1;
    }
    
    private void displayMenu() {
    while (true) {
        int choice = menu.getUserChoice();
        if (choice == 1) {
            startNewGame();
            break;
            
        } else if (choice == 2) {
            System.out.println("Tack för att du spelade!");
            break;

        } else if (choice == 3) {
            System.out.println("Ditt score är: " + score + "\n");
            displayMenu();
            break;
        }
    }

}
}
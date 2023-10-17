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
    private List<ScoreEntry> lowScoreList = new ArrayList<>();
    
    

    private boolean gamePlay = true;
    private int playerGuess;
    private int tryCount = 0;
    private int maxGuesses = 5;
    private int gissning = 1;    


    

    public void startGame() {

        System.out.println("Välkommen till gissa talet!");
        System.out.println("Gissa ett tal mellan 1 och 100: ");
        System.out.println(randomNum);
        while (gamePlay) {
            try {
                playerGuess = scanner.nextInt();
                tryCount++;
                System.out.println("Gissning " + gissning + ": " + playerGuess);
                gissning++;

             
                if (playerGuess == randomNum) {
                    System.out.println("\nGrattis du gissade rätt!\n");
                    gamePlay = false;

                    boolean saveScore = false;
                    while (true) {
                        System.out.println("Vill du spara ditt score? (Ja/Nej)");
                        String choice = scanner.next().toLowerCase();
                        if (choice.equals("ja")) {
                            saveScore = true;
                            break;
                        } else if (choice.equals("nej")) {
                            break;
                        } else {
                            System.out.println("Ogiltigt val. Mata in Ja eller Nej.");
                        }
                    }

                    System.out.println("Ange ditt namn för att spara ditt score: ");
                    String playerName = scanner.next();
                    ScoreEntry entry = new ScoreEntry(tryCount, playerName);
                    lowScoreList.add(entry);
                
                    Collections.sort(lowScoreList, (a, b) -> a.getScore() - b.getScore());

                    if (lowScoreList.size() > maxGuesses) {
                        lowScoreList.remove(lowScoreList.size() - 1);
                    }

                    if (saveScore) {
                        saveScore(tryCount);
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
        System.out.println(randomNum );
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
            System.out.println("Ditt score är: ");
            for (ScoreEntry entry : lowScoreList) {
                System.out.println(entry.getName() + " " + entry.getScore());
            }
            System.out.println();
            displayMenu();
            break;
        }
    }

}

    private void saveScore(int score) {
        if (lowScoreList.size() < maxGuesses || score < lowScoreList.get(maxGuesses - 1).getScore()) {
            System.out.println("Ditt score har sparats!");
        } else {
            System.out.println("Tyvärr, ditt score var inte tillräckligt bra för att sparas.");}
    }
}
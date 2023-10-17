package GameMaking;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public int getUserChoice() {
        int choice = 0;
        while (choice < 1 || choice > 3) {
            System.out.println("Spelmeny:");
            System.out.println("1. Spela igen.");
            System.out.println("2. Avsluta spelet.");
            System.out.println("3. Se ditt score.");
            System.out.println("Ange en siffra: ");

            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Ogiltigt val. Mata in en siffra mellan 1-3."+"\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ogiltigt val. Mata in en siffra mellan 1-3."+"\n");
                scanner.next();
            }
        }
        return choice;
    }

    
}

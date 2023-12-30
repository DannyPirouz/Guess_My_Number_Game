import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class NumberGuessingGame {
    public static void main(String[] args) {

        System.out.println("Let's play a game. I will think of a whole number between 1 - 100 and you try to guess my number.");
        System.out.println("If you guess my number in 6 or less attempts, you win. Otherwise, I win.");
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("I have a number in mind. What is your guess?");
        int guess = scanner.nextInt();
        int numberofguesses = 0;

        while (number != guess) {
            if (number > guess) {
                try {
                    System.out.println("My number is higher than " + guess + ". Try again.");
                    guess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a whole number. \n");
                    numberofguesses--;
                    scanner.next();
                }
                numberofguesses++;
            } else {
                try {
                    System.out.println("My number is lower than " + guess + ". Try again.");
                    guess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a whole number. \n");
                    numberofguesses--;
                    scanner.next();
                }
                numberofguesses++;
            }
        }

        numberofguesses++;

        if (numberofguesses == 1) {
            System.out.println("You guessed my number in 1 try. Good job!");
        } else if (numberofguesses > 6) {
            System.out.println("You guessed my number in " + numberofguesses + " tries. I win!");
        } else {
            System.out.println("You guessed my number in " + numberofguesses + " tries. You win! Good job!");
        }
    }
}


package guessthenumber;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    public static final int LOW_BOUND = 0;
    public static final int UP_BOUND = 21;

    private final InputControl inputControl = new InputControl();
    private static Scanner input = new Scanner(System.in);

    private Random rand = new Random();
    private int rngNumber = rand.nextInt(UP_BOUND);

    private String name = "EMPTY";
    private int tries = 6;
    private int triesCount = 0;

    private boolean notDone = true;

    public void play() {

        gameIntroduction();

        do {

            while ((triesCount < tries) && notDone) {

                boolean wrong = true;
                while (wrong) {
                    try {
                        verifyGuess(inputControl.getGuess(input.nextInt()));
                        wrong = false;
                    } catch (Exception e) {
                        System.out.println("Answer not numerical try again. From 0 to 20.");
                        // resets broken scanner
                        input = new Scanner(System.in);
                    }
                }

                triesCount++;
            }

        } while (playAgain());

    }

    public static Scanner getInput() {
        return input;
    }

    public static void setInput(Scanner input) {
        GameEngine.input = input;
    }

    private void gameIntroduction() {

        System.out.println("Hello! What is your name?");

        name = input.next();

        System.out
                .println("Well, " + name + ", I am thinking of a number from 0 and 20\nTake a Guess. You have 6 tries");

    }

    private void verifyGuess(int guess) {

        if (guess == rngNumber) {

            System.out.println(
                    "Congrats " + name + "! " + rngNumber + " was the correct number.\nIt took you " + triesCount
                            + " tries to guess the number.");

            notDone = false;

        } else if (guess > rngNumber) {

            System.out.println("Your guess is higher. Try again you have " + (tries - triesCount - 1) + " tries left.");

        } else {

            System.out.println("Your guess is lower. Try again you have " + (tries - triesCount - 1) + " tries left.");

        }

    }

    private boolean playAgain() {

        System.out.println("Would you like to play again? y / n");

        if (inputControl.getYN(input.next()).equals("y")) {
            reset();
            return true;
        }

        return false;
    }

    private void reset() {

        System.out.println("So you've deciced to play again " + name + ". Take a guess.");
        triesCount = 0;
        rngNumber = rand.nextInt(UP_BOUND);
        notDone = true;

    }

}

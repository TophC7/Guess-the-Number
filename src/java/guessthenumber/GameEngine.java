package guessthenumber;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {

    // lower and upper bound of guesses [0,21)
    public static final int LOW_BOUND = 0;
    public static final int UP_BOUND = 21;

    private final InputControl inputControl = new InputControl();
    private static Scanner input = new Scanner(System.in);

    // desicion of random number for first playthrough
    private Random rand = new Random();
    private int rngNumber = rand.nextInt(UP_BOUND);

    private String name = "EMPTY";
    private int tries = 6;
    private int triesCount = 0;

    // true while the players still has guesses left
    private boolean notDone = true;

    /**
     * Runs game engine
     */
    public void play() {

        // displays game intro
        gameIntroduction();

        // do this again if the player wants to play again
        do {

            // logic for guessing numebers
            // while still got tries and not yet guessed correctly
            while ((triesCount < tries) && notDone) {

                // we check if they input a nuumber or something else
                boolean wrong = true;
                while (wrong) {
                    try { // try to verify their guess
                        verifyGuess(inputControl.getGuess(input.nextInt()));
                        wrong = false;
                    } catch (Exception e) { // if not numerical input again
                        System.out.println("Answer not numerical try again. From 0 to 20.");
                        // resets broken scanner
                        input = new Scanner(System.in);
                    }
                }

                // if guess not correct keep trying and count the tried
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

    /**
     * Prints game introduction and asks for name
     */
    private void gameIntroduction() {

        System.out.println("Hello! What is your name?");

        name = input.next();

        System.out
                .println("Well, " + name + ", I am thinking of a number from 0 and 20\nTake a Guess. You have 6 tries");

    }

    /**
     * logic to verify if guess is correct, lower or higher
     * 
     * @param guess - numeric input of the player
     */
    private void verifyGuess(int guess) {
        // if same as picked rng number
        if (guess == rngNumber) {

            System.out.println(
                    "Congrats " + name + "! " + rngNumber + " was the correct number.\nIt took you " + triesCount
                            + " tries to guess the number.");

            // player is now done
            notDone = false;

            // if bigger than rng number
        } else if (guess > rngNumber) {

            System.out.println("Your guess is higher. Try again you have " + (tries - triesCount - 1) + " tries left.");

            // if smaller than rng number
        } else {

            System.out.println("Your guess is lower. Try again you have " + (tries - triesCount - 1) + " tries left.");

        }

    }

    /**
     * @return boolean wether to play again or not
     */
    private boolean playAgain() {

        System.out.println("Would you like to play again? y / n");

        // if yes return true
        if (inputControl.getYN(input.next()).equals("y")) {
            reset();
            return true;
        }

        // other wise they dont want to play again
        return false;
    }

    /**
     * resets variables tracked for the playthrough
     */
    private void reset() {

        System.out.println("So you've deciced to play again " + name + ". Take a guess.");
        triesCount = 0;
        rngNumber = rand.nextInt(UP_BOUND);
        notDone = true;

    }

}

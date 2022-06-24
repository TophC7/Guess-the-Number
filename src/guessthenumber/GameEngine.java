package guessthenumber;

import java.util.Random;

public class GameEngine {

    public static final int LOW_BOUND = 0;
    public static final int UP_BOUND = 21;

    private final InputControl input = new InputControl();

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
               verifyGuess(input.getGuess());
               triesCount++;
            }            

        } while (playAgain());

    }

    private void gameIntroduction() {

        System.out.println("Hello! What is your name?");

        name = input.getName();

        System.out.println("Well, " + name +", I am thinking of a number from 0 and 20\nTake a Guess. You have 6 tries");

    }

    private void verifyGuess(int guess) {

        if (guess == rngNumber) {

            System.out.println("Congrats " + name + "! " + rngNumber + " was the correct number.\nIt took you " + tries
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


       if(input.getYesOrNo().equals("y")) {
            reset();
            return true;
        }

        return false;
    }

    private void reset() {

        System.out.println("So you've deciced to play again " + name + ". Take a guess.");
        triesCount = 0;
        rngNumber = rand.nextInt(UP_BOUND);

    }

}

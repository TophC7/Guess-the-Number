package guessthenumber;

import java.util.Scanner;

public class InputControl {

    static Scanner input = new Scanner(System.in);

    public int getGuess() {

        try {

            int answer = input.nextInt();

            if (answer < GameEngine.LOW_BOUND || answer > GameEngine.UP_BOUND - 1) {

                System.out.println("Answer out of bounds try again. From 1 to 20.");

                return getGuess();

            }

            return answer;

        } catch (Exception e) {

            System.out.println("Answer not numerical try again. From 0 to 20.");
            input = new Scanner(System.in); // this is not the best but scanners are not fun
            return getGuess();
        }

    }

    public String getName() {
        try {
            return input.next();
        } catch (Exception e) {
            System.out.println("Somehting when wrong try again. Input your name: ");
            return getName();
        }

    }

    public String getYesOrNo() {

        try {
            String answer = input.next();
            if (answer.equals("y") || answer.equals("n"))
                return answer;

            System.out.println("Wrong input. y / n");

            return getYesOrNo();

        } catch (Exception e) {
            System.out.println("Somehting when wrong try again. y / n? ");
            return getName();
        }

    }

}

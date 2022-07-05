package guessthenumber;

public class InputControl {

    public int getGuess(int answer) {

        while (answer < GameEngine.LOW_BOUND || answer > GameEngine.UP_BOUND - 1) {

            System.out.println("Answer out of bounds try again. From 0 to 20.");

            answer = GameEngine.getInput().nextInt();
        }

        return answer;

    }

    public String getYN(String answer) {
        try {

            if (answer.equals("y") || answer.equals("n")) {
                return answer;
            }

            throw new WrongInputException("Not y or n");

        } catch (WrongInputException e) {

            boolean wrong = true;

            do {

                System.out.println("Wrong Input Try Again. y / n?");

                answer = GameEngine.getInput().next();

                if (answer.equals("y") || answer.equals("n")) {
                    wrong = false;
                }

            } while (wrong);

            return answer;

        }
    }
}

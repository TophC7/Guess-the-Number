package guessthenumber;

public class InputControl {

    /**
     * Makes sure guess is between [0,20] promting for input again when its out of
     * bounds
     * 
     * @param answer - numeric guess from player
     * @return number between [0, 20]
     */
    public int getGuess(int answer) {

        while (answer < GameEngine.LOW_BOUND || answer > GameEngine.UP_BOUND - 1) {

            System.out.println("Answer out of bounds try again. From 0 to 20.");

            answer = GameEngine.getInput().nextInt();
        }

        return answer;

    }

    /**
     * Makes sure answer is y or n promting for input again when its not
     * 
     * @param answer - answer from player
     * @return y or n
     */
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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import guessthenumber.GameEngine;
import guessthenumber.InputControl;

public class InputControlTest {

    InputControl inputControl;

    @BeforeEach
    void setUp() {
        inputControl = new InputControl();
    }

    @DisplayName("Test numeric Guesses")
    @Test
    void testGetGuess() {

        assertEquals(0, inputControl.getGuess(0), "Input 0 and didnt get 0 back");
        assertEquals(3, inputControl.getGuess(3), "Input 3 and didnt get 3 back");
        assertEquals(20, inputControl.getGuess(20), "Input 20 and didnt get 20 back");

        // user inputs wrong input moo so program should aks again for input and we
        // inject 0 so it should pass test
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        GameEngine.setInput(new Scanner(in));
        assertEquals(0, inputControl.getGuess(-1), "Input -1 and expected to get 0 back");

        in = new ByteArrayInputStream("0".getBytes());
        GameEngine.setInput(new Scanner(in));
        assertEquals(0, inputControl.getGuess(21), "Input 21 and expected to get 0 back");

    }

    @Test
    void testGetYN() {

        assertEquals("y", inputControl.getYN("y"), "Input y and didnt get back y");
        assertEquals("n", inputControl.getYN("n"), "Input n and didnt get back n");

        // user inputs wrong input moo so program should aks again for input and we
        // inject y so it should pass test
        ByteArrayInputStream in = new ByteArrayInputStream("y".getBytes());
        GameEngine.setInput(new Scanner(in));
        assertEquals("y", inputControl.getYN("moo"), "Input moo and expected to get y back");

    }
}

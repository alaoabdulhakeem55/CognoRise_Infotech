package com.alaoabdulhakeem;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        // Set up Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Initialize attempt counter and set attempt limit
        int attempts = 0;
        int attemptLimit = 10;
        boolean hasWon = false;

        // Game loop for multiple attempts
        while (attempts < attemptLimit) {
            System.out.println("Enter your guess (1-100): ");
            int userGuess = scanner.nextInt();
            attempts++;

            // Compare user's guess with the generated number
            if (userGuess < randomNumber) {
                System.out.println("Too low!");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                hasWon = true;
                break;
            }
        }

        // Check if the game was won or lost
        if (!hasWon) {
            System.out.println("Sorry, you've used all " + attemptLimit + " attempts. The correct number was " + randomNumber + ".");
        }

        // Close the scanner
        scanner.close();
    }
}


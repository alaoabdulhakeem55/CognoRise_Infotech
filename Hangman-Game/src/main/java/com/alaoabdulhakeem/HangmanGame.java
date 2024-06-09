package com.alaoabdulhakeem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        // List of words to choose from
        String[] words = {"java", "python", "hangman", "programming", "algorithm"};

        // Select a random word
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];
        char[] wordArray = wordToGuess.toCharArray();
        char[] guessedWord = new char[wordArray.length];
        Arrays.fill(guessedWord, '_');

        // Initialize variables for game state
        ArrayList<Character> guessedLetters = new ArrayList<>();
        int incorrectGuesses = 0;
        int maxAttempts = 6;
        boolean hasWon = false;

        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (incorrectGuesses < maxAttempts) {
            System.out.println("Current word: " + String.valueOf(guessedWord));
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Incorrect guesses: " + incorrectGuesses);
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            guessedLetters.add(guess);
            boolean correctGuess = false;

            for (int i = 0; i < wordArray.length; i++) {
                if (wordArray[i] == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                incorrectGuesses++;
            }

            // Display hangman figure based on incorrect guesses
            displayHangman(incorrectGuesses);

            if (String.valueOf(guessedWord).equals(wordToGuess)) {
                hasWon = true;
                break;
            }
        }

        // Check if the game was won or lost
        if (hasWon) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you've been hanged. The correct word was: " + wordToGuess);
        }

        // Close the scanner
        scanner.close();
    }

    public static void displayHangman(int incorrectGuesses) {
        switch (incorrectGuesses) {
            case 0 -> {
                System.out.println("  +---+");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("     ===");
            }
            case 1 -> {
                System.out.println("  +---+");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("     ===");
            }
            case 2 -> {
                System.out.println("  +---+");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("     ===");
            }
            case 3 -> {
                System.out.println("  +---+");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("     ===");
            }
            case 4 -> {
                System.out.println("  +---+");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("     ===");
            }
            case 5 -> {
                System.out.println("  +---+");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("     ===");
            }
            case 6 -> {
                System.out.println("  +---+");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("     ===");
            }
        }
    }
}


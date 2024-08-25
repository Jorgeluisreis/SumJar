package com.sumjar;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Random random;

    public Game() {
        this.random = new Random();
    }

    public void play(Scanner scanner) {
        Settings.clearConsole();
        String[] introLines = {
                "SumJar - Par ou Impar",
                "Escolha seu número de 0 a 10"
        };
        TextBoxFormatter.printBox(introLines);

        int yourNumber = readInt(scanner);

        if (yourNumber < 0 || yourNumber > 10) {
            printInvalidNumberMessage();
            return;
        }

        Settings.clearConsole();
        String[] optionLines = {
                "SumJar - Par ou Impar",
                "Escolha Par(P) ou Ímpar(I)"
        };
        TextBoxFormatter.printBox(optionLines);

        char yourOption = readChar(scanner);

        int opponentNumber = random.nextInt(11);
        int total = yourNumber + opponentNumber;

        if (isValidOption(yourOption)) {
            evaluateResult(total, yourNumber, opponentNumber, yourOption);
        } else {
            printInvalidOptionMessage();
        }
    }

    private void evaluateResult(int total, int yourNumber, int opponentNumber, char yourOption) {
        boolean isEven = total % 2 == 0;
        boolean isUserWin = (yourOption == 'P' || yourOption == 'p') ? isEven : !isEven;

        Settings.clearConsole();
        String[] resultLines = {
                String.format("Máquina: %d", opponentNumber),
                String.format("Você: %d", yourNumber),
                String.format("Sua Escolha: %s", yourOption),
                isUserWin ? String.format("Você ganhou, %d é %s!", total, isEven ? "Par" : "Ímpar")
                        : String.format("Você perdeu, %d é %s!", total, isEven ? "Par" : "Ímpar")
        };
        TextBoxFormatter.printBox(resultLines);
        waitForUserInput();
    }

    private boolean isValidOption(char option) {
        return option == 'P' || option == 'p' || option == 'I' || option == 'i';
    }

    private void printInvalidOptionMessage() {
        Settings.clearConsole();
        String[] lines = {
                "Opção inválida!",
                "Pressione qualquer tecla para tentar novamente..."
        };
        TextBoxFormatter.printBox(lines);
        waitForUserInput();
    }

    private void printInvalidNumberMessage() {
        Settings.clearConsole();
        String[] lines = {
                "Número inválido!",
                "Pressione qualquer tecla para tentar novamente..."
        };
        TextBoxFormatter.printBox(lines);
        waitForUserInput();
    }

    private int readInt(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Escolha: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                Settings.clearConsole();
                String[] errorLines = {
                        "Entrada inválida! Por favor, insira um número inteiro.",
                        "Pressione qualquer tecla para tentar novamente..."
                };
                TextBoxFormatter.printBox(errorLines);
                scanner.next(); // Clear the invalid input
                waitForUserInput();
                Settings.clearConsole();
                String[] introLines = {
                        "SumJar - Par ou Impar",
                        "Escolha seu número de 0 a 10"
                };
                TextBoxFormatter.printBox(introLines);
            }
        }
    }

    private char readChar(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Escolha: ");
                return scanner.next().charAt(0);
            } catch (InputMismatchException e) {
                Settings.clearConsole();
                String[] errorLines = {
                        "Entrada inválida! Por favor, insira um caractere.",
                        "Pressione qualquer tecla para tentar novamente..."
                };
                TextBoxFormatter.printBox(errorLines);
                scanner.next(); // Clear the invalid input
                waitForUserInput();
                Settings.clearConsole();
                String[] optionLines = {
                        "SumJar - Par ou Impar",
                        "Escolha Par(P) ou Ímpar(I)"
                };
                TextBoxFormatter.printBox(optionLines);
            }
        }
    }

    private void waitForUserInput() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package com.sumjar;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        Scanner read = new Scanner(System.in);
        while (true) {
            Settings.clearConsole();
            String[] menuLines = {
                    "SumJar - Par ou Impar",
                    "1- Jogar",
                    "2- Sobre",
                    "0- Sair"
            };
            TextBoxFormatter.printBox(menuLines);

            int selectMenu = readInt(read);

            switch (selectMenu) {
                case 1:
                    Game game = new Game();
                    game.play(read);
                    break;
                case 2:
                    About(read);
                    break;
                case 0:
                    Settings.clearConsole();
                    String[] exitLines = {
                            "Aplicação encerrada!"
                    };
                    TextBoxFormatter.printBox(exitLines);
                    read.close();
                    System.exit(0);
                    break;
                default:
                    Settings.clearConsole();
                    String[] invalidOptionLines = {
                            "Opção inválida!",
                            "Pressione qualquer tecla para tentar novamente..."
                    };
                    TextBoxFormatter.printBox(invalidOptionLines);
                    waitForUserInput();
                    break;
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Opção: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                Settings.clearConsole();
                String[] errorLines = {
                        "Entrada inválida! Por favor, insira um número inteiro.",
                        "Pressione qualquer tecla para tentar novamente..."
                };
                TextBoxFormatter.printBox(errorLines);
                scanner.next();
                waitForUserInput();
                Settings.clearConsole();
                String[] menuLines = {
                        "SumJar - Par ou Impar",
                        "1- Jogar",
                        "2- Sobre",
                        "0- Sair"
                };
                TextBoxFormatter.printBox(menuLines);
            }
        }
    }

    private static void About(Scanner read) {
        Settings.clearConsole();
        String[] aboutLines = {
                "SumJar - Par ou Impar",
                "Trata-se de um Jogo de Par ou Ímpar feito em Java",
                "Rodando em CLI",
                "Criado por: Jorgeluisreis",
                "1- Voltar"
        };
        TextBoxFormatter.printBox(aboutLines);

        int sel = readInt(read);

        switch (sel) {
            case 1:
                MainMenu();
                break;
            default:
                Settings.clearConsole();
                String[] invalidOptionLines = {
                        "Opção inválida!",
                        "Pressione qualquer tecla para tentar novamente..."
                };
                TextBoxFormatter.printBox(invalidOptionLines);
                waitForUserInput();
                break;
        }
    }

    private static void waitForUserInput() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
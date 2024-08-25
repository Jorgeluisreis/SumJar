package com.sumjar;

import java.io.IOException;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner;
    private final Game game;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.game = new Game();
    }

    public void show() {
        while (true) {
            Settings.clearConsole();
            String[] menuLines = {
                    "SumJar - Par ou Impar",
                    "1- Jogar",
                    "2- Sobre",
                    "0- Sair"
            };
            TextBoxFormatter.printBox(menuLines);
            System.out.print("Opção: ");
            int selectMenu = scanner.nextInt();

            switch (selectMenu) {
                case 1:
                    game.play(scanner);
                    break;
                case 2:
                    showAbout();
                    break;
                case 0:
                    Settings.clearConsole();
                    TextBoxFormatter.printBox(new String[] {
                            "Aplicação encerrada!"
                    });
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    Settings.clearConsole();
                    TextBoxFormatter.printBox(new String[] {
                            "Opção inválida!",
                            "Pressione qualquer tecla para tentar novamente..."
                    });
                    waitForUserInput();
                    break;
            }
        }
    }

    private void showAbout() {
        Settings.clearConsole();
        TextBoxFormatter.printBox(new String[] {
                "SumJar - Par ou Impar",
                "Trata-se de um Jogo de Par ou Ímpar feito em Java",
                "Rodando em CLI",
                "1- Voltar"
        });
        System.out.print("Opcao: ");
        int sel = scanner.nextInt();

        if (sel == 1) {
            show();
        } else {
            Settings.clearConsole();
            TextBoxFormatter.printBox(new String[] {
                    "Opção inválida",
                    "Aperte qualquer tecla para tentar novamente..."
            });
            waitForUserInput();
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
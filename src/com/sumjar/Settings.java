package com.sumjar;

import java.io.IOException;

public class Settings {
    public static void main(String[] args) {

    }

    public final static void clearConsole() {
        try {
            // Verifica se o sistema operacional é Windows
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                // Executa o comando cls via cmd
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Para Unix/Linux/Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

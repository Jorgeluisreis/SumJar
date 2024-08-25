package com.sumjar;

public class TextBoxFormatter {
    private static final char BORDER_CHAR = '-';
    private static final char CORNER_CHAR = '+';

    public static void printBox(String[] lines) {
        int width = getMaxLineWidth(lines) + 4; // Width including padding and borders
        printBorder(width);
        for (String line : lines) {
            System.out.println(CORNER_CHAR + " " + padLine(line, width - 4) + " " + CORNER_CHAR);
        }
        printBorder(width);
    }

    private static void printBorder(int width) {
        System.out.println(CORNER_CHAR + String.valueOf(BORDER_CHAR).repeat(width - 2) + CORNER_CHAR);
    }

    private static int getMaxLineWidth(String[] lines) {
        int maxWidth = 0;
        for (String line : lines) {
            if (line.length() > maxWidth) {
                maxWidth = line.length();
            }
        }
        return maxWidth;
    }

    private static String padLine(String line, int length) {
        if (line.length() >= length) {
            return line; // No padding needed if the line is already long enough
        }
        int padding = length - line.length();
        int padLeft = padding / 2;
        int padRight = padding - padLeft;
        return " ".repeat(padLeft) + line + " ".repeat(padRight);
    }
}
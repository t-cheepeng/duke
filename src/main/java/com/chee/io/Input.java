package com.chee.io;

import java.util.Scanner;

public class Input {

    private static Scanner scanner;

    private Input() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    public static Input getInstance() {
        return new Input();
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}

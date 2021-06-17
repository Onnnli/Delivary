package services;

import java.util.Scanner;

public class InputReader {
    private Scanner in;

    public InputReader() {

        this.in = new Scanner(System.in);
    }

    public String getString() {
        return this.in.next();
    }

}


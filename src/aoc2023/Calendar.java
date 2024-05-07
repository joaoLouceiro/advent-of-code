package aoc2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Calendar {

    public abstract void run() throws FileNotFoundException;

    protected Scanner getScanner(String filename) throws FileNotFoundException {
        return new Scanner(new File(filename));
    }
}

package aoc2023;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class AbstractAdventDay implements AdventDay {
  protected List<String> inputLines;

  public void parseInput(String filename) {
    try {
      inputLines = Files.readAllLines(Paths.get(filename));
      int i = 1;
    } catch (Exception e) {
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

}

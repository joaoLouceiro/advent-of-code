package aoc2023;

import java.util.HashMap;
import java.util.Map;

import aoc2023.day08.Day08;
import aoc2023.day09.Day09;
import aoc2023.day10.Day10;

public class AdventOfCodeSolver {
  private Map<Integer, AdventDay> days;

  public AdventOfCodeSolver() {
    days = new HashMap<>();
    days.put(8, new Day08());
    days.put(9, new Day09());
    days.put(10, new Day10());
  }

  public void solve(int day) {
    AdventDay solution = days.get(day);
    if (solution == null) {
      System.out.println("Solution for day " + day + " not implemented yet.");
      return;
    }

    String inputFile = "./src/inputs/day" + String.format("%02d", day) + ".txt";
    solution.parseInput(inputFile);

    System.out.println();
    System.out.println("Day " + day + " solutions:");

    long startRun = System.currentTimeMillis();

    System.out.println("Answer part 1:\t" + solution.solvePart1());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

    System.out.println();
    startRun = System.currentTimeMillis();
    System.out.println("Answer part 2:\t" + solution.solvePart2());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));
  }
}

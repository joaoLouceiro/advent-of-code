package aoc2023;

import java.util.HashMap;
import java.util.Map;

import aoc2023.day09.Day09;

public class Calendar_v2 {

  private static Map<Integer, AbstractDay> calendar = new HashMap<>();

  static {
    calendar.put(9, new Day09());
  }

  public void pickDay(int currentDayNum) {
    AbstractDay today = calendar.get(currentDayNum);
    today.setScanner();
    System.out.println();
    long startRun = System.currentTimeMillis();

    // Try to implement a way of passing the current day's instance to the Part.
    // I can avoid having the .runPart methods and call the Part's runner directly
    // today.getPart1().run(today);
    today.runPart1();

    System.out.println("Answer part 1:\t" + today.getTotal());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

    System.out.println();

    startRun = System.currentTimeMillis();

    today.runPart2();

    System.out.println("Answer part 2:\t" + today.getTotal());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));
    today.getScanner().close();
  }
}

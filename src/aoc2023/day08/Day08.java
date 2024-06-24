package aoc2023.day08;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.Calendar;
import aoc2023.day08.parts.Part1;
import aoc2023.day08.parts.Part2;

public class Day08 extends Calendar {

  private String filename = "./src/aoc2023/day08/files/Input.txt";
  protected String moveList = "";
  protected Map<String, String[]> gameMap = new HashMap<String, String[]>();

  @Override
  public void run() throws FileNotFoundException {
    System.out.println();
    long startRun = System.currentTimeMillis();

    Part1 p1 = new Part1();
    p1.run();

    System.out.println("Answer part 1:\t" + p1.getMoveCount());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

    System.out.println();

    startRun = System.currentTimeMillis();

    Part2 p2 = new Part2();
    p2.run();

    System.out.println("Answer part 2:\t" + p2.getMoveCount());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));
  }

  protected void buildMap(Scanner sc) {
    Pattern pattern = Pattern.compile("\\w{3}");

    while (sc.hasNextLine()) {
      Matcher m = pattern.matcher(sc.nextLine());

      String k, l, r;

      m.find();
      k = m.group();
      m.find();
      l = m.group();
      m.find();
      r = m.group();

      gameMap.put(k, new String[] { l, r });

    }
  }

  protected void initSetup() throws FileNotFoundException {
    Scanner sc = super.getScanner(filename);

    moveList = sc.nextLine();
    sc.nextLine();

    buildMap(sc);
    sc.close();
  }
}

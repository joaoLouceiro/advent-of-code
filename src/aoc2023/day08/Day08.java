package aoc2023.day08;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.AbstractAdventDay;
import aoc2023.AbstractDay;
import aoc2023.Calendar;
import aoc2023.day08.parts.Part1;
import aoc2023.day08.parts.Part2;

public class Day08 extends AbstractAdventDay {

  private String moveList = "";
  private Map<String, String[]> gameMap = new HashMap<String, String[]>();

  private void initSetup() {
    moveList = inputLines.get(0);

    Pattern pattern = Pattern.compile("\\w{3}");

    for (int i = 2; i < inputLines.size(); i++) {
      Matcher m = pattern.matcher(inputLines.get(i));

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

  @Override
  public String solvePart1() {
    initSetup();
    Part1 p1 = new Part1();
    p1.run(moveList, gameMap);
    return String.valueOf(p1.getMoveCount());
  }

  @Override
  public String solvePart2() {
    initSetup();
    Part2 p2 = new Part2();
    p2.run(moveList, gameMap);
    return String.valueOf(p2.getMoveCount());
  }
}

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

public class Day08 extends Calendar {

  private String filename = "./src/aoc2023/day08/files/Input.txt";
  private String moveList = "";
  private Map<String, String[]> gameMap = new HashMap<String, String[]>();
  private String startPosition = "AAA", endPosition = "ZZZ";
  private int moveCount = 0;

  @Override
  public void run() throws FileNotFoundException {
    System.out.println();
    long startRun = System.currentTimeMillis();

    initSetup();
    gameLoop();

    System.out.println("Answer:\t" + moveCount);
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

  }

  public void gameLoop() {
    String currentPosition = startPosition;
    while (!currentPosition.equals(endPosition)) {
      for (int i = 0; i < moveList.length(); i++) {
        moveCount++;
        int nextMove = moveList.charAt(i) == 'L' ? 0 : 1;
        currentPosition = gameMap.get(currentPosition)[nextMove];
        if (currentPosition.equals(endPosition))
          break;
      }
    }
  }

  private void buildMap(Scanner sc) {
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

  private void initSetup() throws FileNotFoundException {
    Scanner sc = super.getScanner(filename);

    moveList = sc.nextLine();
    sc.nextLine();

    buildMap(sc);
    sc.close();
  }
}

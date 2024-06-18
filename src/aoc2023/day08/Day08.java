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

  private String filename = "./src/aoc2023/day08/files/Input_test.txt";
  private String moveList = "";
  private List<Map<String, String[]>> gameMap = new ArrayList<Map<String, String[]>>();

  @Override
  public void run() throws FileNotFoundException {

    System.out.println();
    long startRun = System.currentTimeMillis();

    Scanner sc = super.getScanner(filename);

    moveList = sc.nextLine();
    sc.nextLine();

    buildMap(sc);
    sc.close();

    System.out.println("Answer:\t");
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

  }

  private void buildMap(Scanner sc) {
    Pattern pattern = Pattern.compile("\\w{3}");

    while (sc.hasNextLine()) {
      Matcher m = pattern.matcher(sc.nextLine());
      Map<String, String[]> mp = new HashMap<>();

      String k, l, r;

      m.find();
      k = m.group();
      m.find();
      l = m.group();
      m.find();
      r = m.group();

      mp.put(k, new String[] { l, r });

      gameMap.add(mp);

    }
  }

}

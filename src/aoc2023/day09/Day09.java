package aoc2023.day09;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import aoc2023.Calendar;
import aoc2023.day09.parts.Part1;
import aoc2023.day09.parts.Part2;

public class Day09 extends Calendar {

  private String filename = "./src/aoc2023/day09/files/Input.txt";
  protected List<List<Long>> sequenceList = new ArrayList<List<Long>>();

  @Override
  public void run() throws FileNotFoundException {

    System.out.println();
    long startRun = System.currentTimeMillis();

    Part1 p1 = new Part1();
    p1.run();

    System.out.println("Answer part 1:\t" + p1.getTotal());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

    System.out.println();

    startRun = System.currentTimeMillis();

    Part2 p2 = new Part2();
    p2.run();

    System.out.println("Answer part 2:\t" + p2.getTotal());
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));

  }

  protected void initSetup() throws FileNotFoundException {
    Scanner sc = super.getScanner(filename);
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      sequenceList.add(Arrays.stream(s.split(" ")).map(Long::parseLong).collect(Collectors.toList()));
    }
    sc.close();
  }

}

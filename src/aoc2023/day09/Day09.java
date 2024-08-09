package aoc2023.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc2023.AbstractAdventDay;
import aoc2023.day09.parts.Part1;
import aoc2023.day09.parts.Part2;

public class Day09 extends AbstractAdventDay {

  private List<List<Long>> sequenceList;

  public void initSetup() {
    sequenceList = new ArrayList<List<Long>>();
    for (String s : inputLines) {
      sequenceList.add(Arrays.stream(s.split(" ")).map(Long::parseLong).collect(Collectors.toList()));
    }

  }

  @Override
  public String solvePart1() {
    initSetup();
    Part1 p1 = new Part1();
    p1.run(this.sequenceList);
    System.out.println(p1.getTotal());
    return String.valueOf(p1.getTotal());
  }

  @Override
  public String solvePart2() {
    initSetup();
    Part2 p2 = new Part2();
    p2.run(this.sequenceList);
    return String.valueOf(p2.getTotal());
  }

}

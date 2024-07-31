package aoc2023.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import aoc2023.AbstractDay;
import aoc2023.day09.parts.Part1;
import aoc2023.day09.parts.Part2;

public class Day09 extends AbstractDay {

  public Day09() {
    this.setFilename("./src/aoc2023/day09/files/Input.txt");
    this.setPart1(new Part1());
  }

  private List<List<Long>> sequenceList = new ArrayList<List<Long>>();

  @Override
  public void initSetup() {
    while (this.getScanner().hasNextLine()) {
      String s = this.getScanner().nextLine();
      sequenceList.add(Arrays.stream(s.split(" ")).map(Long::parseLong).collect(Collectors.toList()));
    }
  }

  @Override
  public void runPart1() {
    initSetup();
    Part1 p1 = new Part1();
    p1.run(this.sequenceList);
    this.setTotal(p1.getTotal());
  }

  @Override
  public void runPart2() {
    initSetup();
    Part2 p2 = new Part2();
    p2.run(this.sequenceList);
    this.setTotal(p2.getTotal());
  }

}

package aoc2023.day10;

import aoc2023.AbstractAdventDay;

import java.nio.file.Path;

public class Day10 extends AbstractAdventDay {

  private void initSetup() {

  }

  @Override
  public String solvePart1() {
    initSetup();
    gameLoop();
    return String.valueOf(graph.size() / 2);
  }

  @Override
  public String solvePart2() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'solvePart2'");
  }

}

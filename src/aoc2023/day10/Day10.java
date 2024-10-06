package aoc2023.day10;

import aoc2023.AbstractAdventDay;

public class Day10 extends AbstractAdventDay {

  Graph graph;

  private void initSetup() {
    graph = new Graph(inputLines);
  }

  @Override
  public String solvePart1() {
    initSetup();
    return String.valueOf(graph.getGraph().size() / 2);
  }

  @Override
  public String solvePart2() {
    return String.valueOf(graph.countInnerTiles());
  }

}

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
    // int[][] matrix = {
    // { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    // { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
    // { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
    // { 0, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
    // { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 },
    // { 0, 1, 0, 1, 1, 1, 1, 1, 0, 0 },
    // { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
    // { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 },
    // { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
    // { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    // };
    // System.out.println(inside(matrix, 7, 3));
    //
    // return "";
    return String.valueOf(graph.countInnerTiles());
  }

  private boolean inside(int[][] matrix, int x, int y) {
    int x_count = 0;
    for (int i = 0; i < x; i++)
      if (matrix[y][i] == 1) {

        x_count++;
      }

    int y_count = 0;
    for (int i = 0; i < y; i++)
      if (matrix[i][x] == 1)
        y_count++;

    return x_count % 2 != 0 || y_count % 2 != 0;
  };

}

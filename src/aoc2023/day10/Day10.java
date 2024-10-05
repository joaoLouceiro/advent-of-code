package aoc2023.day10;

import aoc2023.AbstractAdventDay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day10 extends AbstractAdventDay {

  static Map<Character, Pipe> pipeMap = new HashMap<>();
  private ArrayList<Vertex> graph = new ArrayList<>();

  static {
    Movement N = new Movement(0, -1);
    Movement S = new Movement(0, 1);
    Movement E = new Movement(1, 0);
    Movement W = new Movement(-1, 0);

    pipeMap.put('|', new Pipe(N, S));
    pipeMap.put('-', new Pipe(E, W));
    pipeMap.put('L', new Pipe(N, E));
    pipeMap.put('J', new Pipe(N, W));
    pipeMap.put('F', new Pipe(S, E));
    pipeMap.put('7', new Pipe(S, W));
  }

  private void initSetup() {
    int[] start = findStart();
    graph.add(new Vertex(start[0], start[1]));
    graph.add(findFirstMove());
  }

  @Override
  public String solvePart1() {
    initSetup();
    gameLoop();
    return String.valueOf(graph.size() / 2);
  }

  @Override
  public String solvePart2() {
    return "";
  }

  public int[] findStart() {
    for (int i = 0; i < inputLines.size(); i++) {
      for (int j = 0; j < inputLines.get(i).length(); j++) {
        if (inputLines.get(i).charAt(j) == 'S') {
          return new int[] { j, i };
        }
      }
    }
    return null;
  }

  public Vertex findFirstMove() {
    Vertex startVertex = graph.get(0);
    int x = startVertex.getX(), y = startVertex.getY();
    for (int i = y - 1; i <= y + 1; i++) {
      for (int j = x - 1; j <= x + 1; j++) {
        char pipeLabel = inputLines.get(i).charAt(j);
        if (null != pipeMap.get(pipeLabel)) {
          Pipe pipe = pipeMap.get(pipeLabel);
          Vertex currentVertex = new Vertex(j, i, pipeLabel),
              vertexA = pipe.getMoveA().getNewVertex(currentVertex),
              vertexB = pipe.getMoveB().getNewVertex(currentVertex);
          if (startVertex.equals(vertexA) || startVertex.equals(vertexB)) {
            return currentVertex;
          }
        }
      }
    }
    return null;
  }

  public void gameLoop() {
    Vertex newV;
    do {
      Vertex currentVertex = graph.get(graph.size() - 1);
      Pipe pipe = pipeMap.get(currentVertex.getLabel());
      newV = pipe.getMoveA().getNewVertex(currentVertex);
      if (graph.contains(newV) && !newV.equals(graph.get(0))) {
        newV = pipe.getMoveB().getNewVertex(currentVertex);
      }
      char label = inputLines.get(newV.getY()).charAt(newV.getX());
      newV.setLabel(label);
      graph.add(newV);
    } while (!newV.equals(graph.get(0)));
  }

}

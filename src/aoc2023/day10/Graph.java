package aoc2023.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
  private ArrayList<Vertex> graph;
  private List<String> inputLines;
  private PipeMap pipeMap = new PipeMap();

  public Graph(List<String> inputLines) {
    this.inputLines = inputLines;
    this.graph = new ArrayList<Vertex>();
    graph.add(findStart());
    graph.add(findFirstMove());
    buildGraph();
  }

  private Vertex findStart() {
    int columnSize = inputLines.size(),
        rowLength = inputLines.get(0).length();

    for (int i = 0; i < columnSize; i++) {
      for (int j = 0; j < rowLength; j++) {
        if (inputLines.get(i).charAt(j) == 'S') {
          return new Vertex(j, i);
        }
      }
    }
    return null;
  }

  private Vertex findFirstMove() {
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

  private void buildGraph() {
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

  // =========================================
  // ============ End of Part 1
  // =========================================

  public int countInnerTiles() {
    int columnSize = inputLines.size(),
        rowLength = inputLines.get(0).length(),
        innerTile = 0;

    for (int i = 0; i < columnSize; i++) {
      for (int j = 0; j < rowLength; j++) {
        Vertex currentVertex = new Vertex(j, i);
        if (!graph.contains(currentVertex)) {
          // if (inputLines.get(i).charAt(j) == '.') {
          // System.out.println("found .: " + currentVertex.toString());
          if (isInside(j, i)) {
            // System.out.println("is inside: " + currentVertex.toString());
            innerTile++;
          }
        }
      }
    }
    return innerTile;
  }

  private boolean isInside(int x, int y) {
    // int preXIntercept = 0, postXIntercept = 0, preYIntercept = 0, postYIntercept
    // = 0;
    ArrayList<Vertex> interceptionsX = new ArrayList<>();
    for (int i = 0; i < x; i++) {
      Vertex v = new Vertex(i, y, inputLines.get(y).charAt(i));
      if (graph.contains(v)) {
        interceptionsX.add(v);
      }
    }

    ArrayList<Vertex> interceptionsY = new ArrayList<>();
    for (int i = x; i < inputLines.get(0).length(); i++) {
      Vertex v = new Vertex(i, y);
      if (graph.contains(v)) {
        interceptionsY.add(v);
      }
    }

    if (interceptionsX.size() == 0 || interceptionsY.size() == 0) {
      return false;
    }

    HashMap<Character, Character> auxMapX = new HashMap<>();
    auxMapX.put('L', 'J');
    auxMapX.put('F', '7');

    HashMap<Character, Character> auxMapY = new HashMap<>();
    auxMapY.put('F', 'L');
    auxMapY.put('7', 'J');

    return getShenanigans(interceptionsX, auxMapX) && getShenanigans(interceptionsY, auxMapY);
  }

  private boolean getShenanigans(ArrayList<Vertex> interceptions, HashMap<Character, Character> auxMap) {
    int count = 0;
    ArrayList<Vertex> segment = new ArrayList<>();

    for (int i = 1; i < interceptions.size(); i++) {
      Vertex current = interceptions.get(i);
      Vertex previous = interceptions.get(i - 1);
      System.out.println(i);
      if (graph.indexOf(current) > 0 && previous.equals(graph.get(graph.indexOf(current) - 1))
          || graph.indexOf(current) < graph.size() && previous.equals(graph.get(graph.indexOf(current) + 1))) {
        segment.add(previous);
      } else if (segment.size() > 0) {
        System.out.println("Last in segment");
        Vertex firstInSegment = segment.get(0),
            lastInSegment = segment.get(segment.size() - 1);
        if (null != auxMap.get(firstInSegment.getLabel())
            && auxMap.get(firstInSegment.getLabel()) == lastInSegment.getLabel()) {
          count += 2;
        } else {
          count += 1;
        }
        segment = new ArrayList<>();
      } else {
        count++;
      }
    }
    return count % 2 != 0;
  }

  public ArrayList<Vertex> getGraph() {
    return graph;
  }

}

package aoc2023.day10;

import java.util.HashMap;
import java.util.Map;

public class PipeMap {
  static Map<Character, Pipe> pipeMap = new HashMap<>();

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

  public Pipe get(char key) {
    return pipeMap.get(key);
  }

}

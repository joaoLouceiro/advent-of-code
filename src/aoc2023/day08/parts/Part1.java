package aoc2023.day08.parts;

import java.util.Map;

public class Part1 {
  private String startPosition = "AAA", endPosition = "ZZZ";
  private long moveCount = 0;

  public void run(String moveList, Map<String, String[]> gameMap) {
    String currentPosition = startPosition;
    while (!currentPosition.equals(endPosition)) {
      for (int i = 0; i < moveList.length(); i++) {
        moveCount++;
        int nextMove = moveList.charAt(i) == 'L' ? 0 : 1;
        currentPosition = gameMap.get(currentPosition)[nextMove];
        if (currentPosition.equals(endPosition))
          break;
      }
    }
  }

  public long getMoveCount() {
    return moveCount;
  }

}

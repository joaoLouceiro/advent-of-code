package aoc2023.day08.parts;

import java.io.FileNotFoundException;

import aoc2023.day08.Day08;

public class Part1 extends Day08 {
  private String startPosition = "AAA", endPosition = "ZZZ";
  private int moveCount = 0;

  public void run() throws FileNotFoundException {
    initSetup();
    gameLoop();
  }

  private void gameLoop() {
    String currentPosition = startPosition;
    while (!currentPosition.equals(endPosition)) {
      for (int i = 0; i < super.moveList.length(); i++) {
        moveCount++;
        int nextMove = moveList.charAt(i) == 'L' ? 0 : 1;
        currentPosition = gameMap.get(currentPosition)[nextMove];
        if (currentPosition.equals(endPosition))
          break;
      }
    }
  }

  public int getMoveCount() {
    return moveCount;
  }

}

package aoc2023.day08.parts;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Part2 {
  private Map<String, Integer> startMap = new HashMap<>();
  private long moveCount = 0;
  private String moveList;
  private Map<String, String[]> gameMap;

  /*
   * Run initial setup.
   * Besides the steps taken in pt 1, we need a new Map to store all starting
   * positions and respective count.
   */
  public void run(String moveList, Map<String, String[]> gameMap) {
    this.moveList = moveList;
    this.gameMap = gameMap;
    buildStartMap();
    startMap.entrySet().parallelStream().forEach(m -> gameLoop(m));
    Integer[] moveArray = startMap.values().toArray(new Integer[0]);
    moveCount = getLCM(moveArray);
  }

  /*
   * Since each "game" always takes the same number of moves to get to and return
   * to the ending house (thanks @JonnyDom), we don't need to use an iteration and
   * wait for every game to fall on a winning house.
   * 
   * We can simply find how many steps each game takes to finish and then use the
   * Least Common Multiple to find our solution.
   */
  private void gameLoop(Map.Entry<String, Integer> m) {
    String startPosition = m.getKey();
    boolean isEndPosition = false;
    while (!isEndPosition) {
      for (int i = 0; i < moveList.length(); i++) {
        m.setValue(m.getValue() + 1);
        int nextMove = moveList.charAt(i) == 'L' ? 0 : 1;
        startPosition = gameMap.get(startPosition)[nextMove];
        if (startPosition.charAt(2) == 'Z') {
          isEndPosition = true;
          break;
        }
      }
    }
  }

  /*
   * Filter the gameMap for all positions ending in an 'A'.
   * Create a Map with the starting position and a counter set to 0.
   */
  private void buildStartMap() {
    startMap = gameMap.keySet().stream().filter(str -> str.charAt(2) == 'A')
        .collect(Collectors.toMap(p -> p, p -> 0));
  }

  /*
   * Using Euclids' algorythm to find the Greatest Common Denominator
   */
  private long getGCD(long a, long b) {
    if (b == 0) {
      return a;
    }
    return getGCD(b, a % b);
  }

  /*
   * Get the LCM iteratively using the formula
   * LCM(a, b) = (a * b) / GCM(a, b)
   */
  private long getLCM(Integer[] moveArray) {
    long lcm = moveArray[0];
    for (int i = 1; i < moveArray.length; i++) {
      long gcd = getGCD(lcm, moveArray[i]);
      lcm = (lcm * moveArray[i]) / gcd;
    }
    return lcm;
  }

  public long getMoveCount() {
    return moveCount;
  }

}

package aoc2023.day06;

import java.io.FileNotFoundException;
import java.util.Scanner;

import aoc2023.Calendar;

public class Day06 extends Calendar {

  private String filename = "./src/aoc2023/day06/files/Input.txt";

  /**
   * Distance = TimeHoldingButton * (RaceDuration - TimeHoldingButton)
   * The race follows a normal distribution curve.
   * I only need to calculate until TimeHoldingButton = RaceDuration / 2.
   */
  @Override
  public void run() throws FileNotFoundException {
    long startRun = System.currentTimeMillis();
    System.out.println();
    Scanner sc = super.getScanner(filename);

    // For pt1, array must be long[2][4]
    System.out.println("Answer:\t" + getAllRacesWins(buildRaceMatrix_pt2(sc, new long[2][1])));
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));
  }

  /*
   * First, calculate all possible distances for the given RaceDuration (top row);
   * Then, verify if that value is over the TopDistance (bottom row)
   */
  private long getAllRacesWins(long[][] raceMatrix) {
    long total = 1;
    for (int i = 0; i < raceMatrix[0].length; i++) {
      total *= getNumberOfPossibleWinsPerRace(raceMatrix[0][i], raceMatrix[1][i]);
    }
    return total;
  }

  private long getNumberOfPossibleWinsPerRace(long raceDuration, long bestDistance) {
    long numberOfPossibleWins = 0;
    /*
     * No need of going to the end of the race duration as the results are symetric
     */
    for (long i = 0; i <= raceDuration / 2; i++) {
      if (getDistance(raceDuration, i) > bestDistance)
        numberOfPossibleWins += 2;
    }
    return raceDuration % 2 != 0 ? numberOfPossibleWins : numberOfPossibleWins - 1;
  }

  private long[][] buildRaceMatrix_pt2(Scanner sc, long[][] raceMatrix) {
    int i = 0;
    String[] sArr = { "", "" };
    while (sc.hasNext()) {
      sc.next();
      while (sc.hasNextLong()) {
        sArr[i] += sc.next();
      }
      i++;
    }
    raceMatrix[0][0] = Long.valueOf(sArr[0]);
    raceMatrix[1][0] = Long.valueOf(sArr[1]);
    return raceMatrix;
  }

  private long[][] buildRaceMatrix(Scanner sc, long[][] raceMatrix) {
    int i = 0;
    while (sc.hasNext()) {
      sc.next();
      for (int j = 0; sc.hasNextInt(); j++) {
        raceMatrix[i][j] = sc.nextLong();
      }
      i++;
    }
    return raceMatrix;
  }

  private long getDistance(long tRace, long tHold) {
    return tHold * (tRace - tHold);
  }

}

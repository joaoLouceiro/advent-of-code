package aoc2023.day09.parts;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import aoc2023.day09.Day09;

public class Part2 extends Day09 {

  private long total = 0;

  /*
   * Really fun to solve
   * Should have more DRY (most of the code in the buildSequence() is duplicated)
   * and no maths should be done inside the .forEach, but oh well
   */
  @Override
  public void run() throws FileNotFoundException {
    super.initSetup();
    sequenceList.forEach(e -> total += e.get(0) - buildSequence(e));
  }

  private Long buildSequence(List<Long> sequence) {
    List<Long> newSequence = new ArrayList<>();
    for (int i = 1; i < sequence.size(); i++) {
      newSequence.add(sequence.get(i) - sequence.get(i - 1));
    }
    if (newSequence.stream().allMatch(e -> e == 0)) {
      return (long) 0;
    }
    return newSequence.get(0) - buildSequence(newSequence);

  }

  public long getTotal() {
    return total;
  }

}

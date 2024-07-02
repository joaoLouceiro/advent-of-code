package aoc2023.day09.parts;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import aoc2023.day09.Day09;

public class Part1 extends Day09 {

  private long total = 0;

  @Override
  public void run() throws FileNotFoundException {
    super.initSetup();

    sequenceList.forEach(e -> total += buildSequence(e) + e.get(e.size() - 1));
  }

  private Long buildSequence(List<Long> sequence) {
    List<Long> newSequence = new ArrayList<>();
    for (int i = 1; i < sequence.size(); i++) {
      newSequence.add(sequence.get(i) - sequence.get(i - 1));
    }
    if (newSequence.stream().allMatch(e -> e == 0)) {
      return (long) 0;
    }
    return buildSequence(newSequence) + newSequence.get(newSequence.size() - 1);
  }

  public long getTotal() {
    return total;
  }

}

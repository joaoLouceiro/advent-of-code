package aoc2023.day09.parts;

import java.util.ArrayList;
import java.util.List;

import aoc2023.AbstractPart;

public class Part1 extends AbstractPart {

  private long total = 0;

  @Override
  public void run(List<List<Long>> sequenceList) {
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

  @Override
  public long getTotal() {
    return total;
  }

}

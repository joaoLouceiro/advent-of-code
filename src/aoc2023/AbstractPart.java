package aoc2023;

import java.util.List;

public abstract class AbstractPart {

  protected long total = 0;

  public abstract long getTotal();

  public void run(Day day) {
    throw new UnsupportedOperationException(
        "run(Day) method is not implemented for " + this.getClass().getSimpleName());
  }

  public void run(List<List<Long>> sequenceList) {
    throw new UnsupportedOperationException(
        "run(List<List<Long>>) method is not implemented for " + this.getClass().getSimpleName());
  }
}

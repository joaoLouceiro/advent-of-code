package aoc2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractDay {
  private long total;
  private Scanner scanner;
  private String filename;
  private AbstractPart part1;
  private AbstractPart part2;

  public abstract void initSetup();

  public abstract void runPart1();

  public abstract void runPart2();

  /* ============ Getters & Setters ============ */

  public Scanner getScanner() {
    return scanner;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public void setScanner() {
    File f = new File(filename);
    try {
      this.scanner = new Scanner(f);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public AbstractPart getPart1() {
    return part1;
  }

  public void setPart1(AbstractPart part1) {
    this.part1 = part1;
  }

  public AbstractPart getPart2() {
    return part2;
  }

  public void setPart2(AbstractPart part2) {
    this.part2 = part2;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

}

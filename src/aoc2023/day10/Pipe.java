package aoc2023.day10;

public class Pipe {
  private Movement moveA, moveB;

  public Pipe(Movement moveA, Movement moveB) {
    this.moveA = moveA;
    this.moveB = moveB;
  }

  public Movement getMoveA() {
    return moveA;
  }

  public Movement getMoveB() {
    return moveB;
  }

}

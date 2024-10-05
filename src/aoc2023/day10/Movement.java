package aoc2023.day10;

public class Movement {
  private int x, y;

  public Movement(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Vertex getNewVertex(Vertex v) {
    int x = v.getX() + this.x;
    int y = v.getY() + this.y;
    return new Vertex(x, y);
  }
}

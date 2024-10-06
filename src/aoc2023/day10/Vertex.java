package aoc2023.day10;

public class Vertex {
  private int x, y;
  private char label;

  public Vertex(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Vertex(int x, int y, char label) {
    this.x = x;
    this.y = y;
    this.label = label;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Vertex other = (Vertex) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    return true;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public char getLabel() {
    return label;
  }

  public void setLabel(char label) {
    this.label = label;
  }

}

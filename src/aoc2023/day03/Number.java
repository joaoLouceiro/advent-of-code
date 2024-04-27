package aoc2023.day03;

public class Number {
    private int[] start = new int[2];
    private int[] end = new int[2];
    private int value;

    public Number(int[] start, int[] end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    public int[] getStart() {
        return start;
    }

    public int[] getEnd() {
        return end;
    }

    public int getValue() {
        return value;
    }

}

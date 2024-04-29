import aoc2023.NoDay;
import aoc2023.SuperDay;
import aoc2023.day01.Day01;
import aoc2023.day02.Day02;
import aoc2023.day03.Day03;
import aoc2023.day04.Day04;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        SuperDay d = getDay(4);
        d.run();
    }

    private static SuperDay getDay(int day) {
        switch (day) {
            case 1:
                return new Day01();
            case 2:
                return new Day02();
            case 3:
                return new Day03();
            case 4:
                return new Day04();
            default:
                return new NoDay();
        }
    }
}

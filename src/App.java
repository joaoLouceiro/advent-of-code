import aoc2023.NoDay;
import aoc2023.SuperDay;
import aoc2023.day01.Day01;
import aoc2023.day02.Day02;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        SuperDay d = getDay(2);
        d.run();
    }

    private static SuperDay getDay(int day) {
        switch (day) {
            case 1:
                return new Day01();
            case 2:
                return new Day02();
            default:
                return new NoDay();
        }
    }
}

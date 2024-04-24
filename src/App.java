import aoc2023.NoDay;
import aoc2023.SuperDay;
import aoc2023.day01.Day01;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        SuperDay d = getDay(1);
        d.run();
    }

    private static SuperDay getDay(int day) {
        switch (day) {
            case 1:
                return new Day01();
            default:
                return new NoDay();
        }
    }
}

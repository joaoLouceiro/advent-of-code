package aoc2023.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.Calendar;

public class Day02 extends Calendar {
    private static Map<String, Integer> map = new HashMap<>();
    private static Pattern outRegex = Pattern.compile("(?:Game\\s(\\d+))|(\\d.+?(;|$))");
    private static Pattern inRegex = Pattern.compile("(\\d+)\\s(\\w+)");
    static {
        map.put("red", 12);
        map.put("green", 13);
        map.put("blue", 14);
    }

    public void run() throws FileNotFoundException {
        part1();
        part2();
    }

    private void part1() throws FileNotFoundException {
        File file = new File("./src/aoc2023/day02/files/Input.txt");
        Scanner sc = new Scanner(file);
        int total = 0;
        while (sc.hasNextLine()) {
            String gString = sc.nextLine();
            Matcher m = outRegex.matcher(gString);
            m.find();
            int gameNum = Integer.valueOf(m.group(1));
            boolean flag = true;
            while (flag && m.find()) {
                String s = m.group(2);
                Matcher inMatcher = inRegex.matcher(s);
                while (flag && inMatcher.find()) {
                    String cubeColor = inMatcher.group(2);
                    int cubesNumber = Integer.valueOf(inMatcher.group(1));
                    if (map.get(cubeColor) < cubesNumber)
                        flag = false;
                }
            }
            if (flag)
                total += gameNum;
        }
        System.out.println("Part 1: " + total);
        sc.close();
    }

    private void part2() throws FileNotFoundException {
        File file = new File("./src/aoc2023/day02/files/Input.txt");
        Scanner sc = new Scanner(file);
        int total = 0;
        while (sc.hasNextLine()) {
            String gString = sc.nextLine();
            Matcher m = outRegex.matcher(gString);
            m.find();
            int minRed = 0;
            int minGreen = 0;
            int minBlue = 0;
            while (m.find()) {
                String s = m.group(2);
                Matcher inMatcher = inRegex.matcher(s);
                while (inMatcher.find()) {
                    String cubeColor = inMatcher.group(2);
                    int cubesNumber = Integer.valueOf(inMatcher.group(1));
                    switch (cubeColor) {
                        case "red":
                            if (minRed < cubesNumber)
                                minRed = cubesNumber;
                            break;
                        case "green":
                            if (minGreen < cubesNumber)
                                minGreen = cubesNumber;
                            break;
                        case "blue":
                            if (minBlue < cubesNumber)
                                minBlue = cubesNumber;
                            break;
                    }
                }
            }
            total += (minRed * minBlue * minGreen);
        }
        System.out.println("Part 2: " + total);
        sc.close();

    }

}

package aoc2023.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.SuperDay;

public class Day02 extends SuperDay {
    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("red", 12);
        map.put("green", 13);
        map.put("blue", 14);
    }

    public void run() throws FileNotFoundException {

        File file = new File("./src/aoc2023/day02/files/Input.txt");
        Scanner sc = new Scanner(file);
        Pattern outRegex = Pattern.compile("(?:Game\\s(\\d+))|(\\d.+?(;|$))");
        Pattern inRegex = Pattern.compile("(\\d+)\\s(\\w+)");
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
        System.out.println(total);
        sc.close();
    }

}

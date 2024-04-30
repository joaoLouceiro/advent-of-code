package aoc2023.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.SuperDay;

public class Day04 extends SuperDay {

    private static Pattern p = Pattern.compile("(?:Game \\d+:)|(\\d+)");
    private static List<String> scratchList = new ArrayList<>();
    private static int p2Total = 0;

    @Override
    public void run() throws FileNotFoundException {
        part1();
        part2();
    }

    private void part1() throws FileNotFoundException {
        File file = new File("./src/aoc2023/day04/files/Input.txt");
        Scanner sc = new Scanner(file);
        // Pattern p = Pattern.compile("(\\d+)");
        int total = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            Matcher m = p.matcher(s);
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            int gameTotal = 0;
            for (int i = 0; m.find(); i++) {
                String gString = m.group(0);
                if (i == 0) {
                    continue;
                }
                if (gString != null && i <= 10) {
                    map.put(gString, true);
                } else {
                    if (map.get(gString) != null)
                        gameTotal = gameTotal > 0 ? gameTotal * 2 : 1;
                }
            }
            total += gameTotal;
        }
        System.out.println(total);
        sc.close();
    }

    private void part2() throws FileNotFoundException {
        File file = new File("./src/aoc2023/day04/files/Input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            scratchList.add(s);
        }
        checkScratch(0, scratchList.size());
        System.out.println(p2Total);
        sc.close();
    }

    private void checkScratch(int begin, int end) {
        for (int i = begin; i < end; i++) {
            p2Total += 1;
            String s = scratchList.get(i);
            Matcher m = p.matcher(s);
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            m.find();
            int gameTotal = 0;
            for (int j = 0; m.find(); j++) {
                String gString = m.group(0);
                if (gString != null && j < 10) {
                    map.put(gString, true);
                } else {
                    if (map.get(gString) != null) {
                        gameTotal += 1;
                    }
                }
            }
            if (gameTotal > 0) {
                checkScratch(i + 1, i + 1 + gameTotal);
            }
        }
    }
}

package aoc2023.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.Calendar;

public class Day03 extends Calendar {

    @Override
    public void run() throws FileNotFoundException {
        File file = new File("./src/aoc2023/day03/files/Input.txt");
        Scanner sc = new Scanner(file);
     // System.out.println(part1(sc));
        System.out.println(part2(sc));
        sc.close();
    }

    private int part1(Scanner sc) {
        Pattern p = Pattern.compile("\\d+|[^.]");
        Matcher m;
        int total = 0;
        int y = 0;
        List<Number> numberList = new ArrayList<>();
        List<Symbol> symbolList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            m = p.matcher(s);
            while (m.find()) {
                String group = m.group(0);
                if (group.matches("\\d+")) {
                    int[] start = { m.start(), y };
                    int[] end = { m.end() - 1, y };
                    numberList.add(new Number(start, end, Integer.valueOf(group)));
                } else {
                    symbolList.add(new Symbol(m.start(), y));
                }
            }
            y++;
        }
        /*
         * Horrible performance... O(n) + O(n²) or something
         */
        for (Number n : numberList) {
            for (Symbol s : symbolList) {
                if (s.getY() > n.getStart()[1] + 1) {
                    break;
                }
                if (s.getX() >= n.getStart()[0] - 1 && s.getX() <= n.getEnd()[0] + 1
                        && s.getY() >= n.getStart()[1] - 1 && s.getY() <= n.getStart()[1] + 1) {
                    total += n.getValue();
                }
            }
        }
        return total;
    }

    private long part2(Scanner sc) {
        Pattern p = Pattern.compile("\\d+|\\*");
        Matcher m;
        long total = 0;
        int y = 0;

        List<Number> numberList = new ArrayList<>();
        List<Symbol> symbolList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            m = p.matcher(s);
            while (m.find()) {
                String group = m.group(0);
                if (group.matches("\\d+")) {
                    int[] start = { m.start(), y };
                    int[] end = { m.end() - 1, y };
                    numberList.add(new Number(start, end, Integer.valueOf(group)));
                } else {
                    symbolList.add(new Symbol(m.start(), y));
                }
            }
            y++;
        }
        for (Symbol s : symbolList) {
            int n1 = 1;
            int n2 = 1;
            for (Number n : numberList) {
                int numberY = n.getStart()[1];
                int minX = n.getStart()[0];
                if (numberY > s.getY() + 1)
                    break;
                if (minX > s.getX() + 1)
                    continue;
                int maxX = n.getEnd()[0];
                if ((numberY >= s.getY() - 1 && numberY <= s.getY() + 1)
                        && (s.getX() >= minX - 1 && s.getX() <= maxX + 1)) {
                    if (n1 == 1) {
                        n1 = n.getValue();
                    } else {
                        n2 = n.getValue();
                    }
                }
            }
            total += (n1 > 1 && n2 > 1) ? n1 * n2 : 0;
        }

        return total;
    }
}

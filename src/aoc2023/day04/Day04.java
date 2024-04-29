package aoc2023.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.SuperDay;

public class Day04 extends SuperDay{

    @Override
    public void run() throws FileNotFoundException {
    
        File file = new File("./src/aoc2023/day04/files/Input.txt");
        Scanner sc = new Scanner(file);
        Pattern p = Pattern.compile("(\\d+)");
        int total = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            Matcher m = p.matcher(s);
            Map<String, Boolean> map = new HashMap<String, Boolean>();
            int gameTotal = 0;
            for(int i = 0; m.find(); i++) {
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
    }
}

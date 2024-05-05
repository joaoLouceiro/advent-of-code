package aoc2023.day05.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aoc2023.SuperDay;

public class Day05 extends SuperDay {

    private List<List<long[]>> almanac = new ArrayList<>();

    @Override
    public void run() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/aoc2023/day05/files/Input.txt"));

        // Get the array of seeds from the first line of the input file
        long[] seeds = getNumbersFromString(sc.nextLine().split(": ")[1]);
        buildAlmanac(sc);
        System.out.println(getMinLocation(seeds));
        sc.close();
    }

    private void buildAlmanac(Scanner sc) {
        while (sc.hasNextLine()) {
            if (!sc.hasNextLong()) {
                sc.nextLine();
                continue;
            }
            almanac.add(buildAlmanacMap(sc));
        }
    }

    private List<long[]> buildAlmanacMap(Scanner sc) {
        List<long[]> list = new ArrayList<>();
        while (sc.hasNextLine() && sc.hasNextLong()) {
            list.add(getNumbersFromString(sc.nextLine()));
        }
        return list;
    }

    private long getMinLocation(long[] seeds) {
        long minLocation = Long.MAX_VALUE;
        for (long seed : seeds) {
            minLocation = Math.min(minLocation, getSeedLocation(seed));
        }
        return minLocation;
    }

    private long getSeedLocation(long seed) {
        for (List<long[]> almanacMap : almanac) {
            seed = getNewValueFromMap(seed, almanacMap);
        }
        return seed;
    }

    private long getNewValueFromMap(long currentValue, List<long[]> almanacMap) {
        for (long[] entry : almanacMap) {
            if (findInRange(currentValue, entry[1], entry[2]))
                return calculateNewValue(currentValue, entry[0], entry[1]);
        }
        return currentValue;
    }

    private boolean findInRange(long value, long begin, long end) {
        return value >= begin && value < begin + end;
    }

    private long calculateNewValue(long value, long sourceBegin, long destinationBegin) {
        return value - (destinationBegin - sourceBegin);
    }

    private long[] getNumbersFromString(String s) {
        String[] sArr = s.split(" ");
        long[] numbers = new long[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            numbers[i] = Long.valueOf(sArr[i]);
        }
        return numbers;
    }

}

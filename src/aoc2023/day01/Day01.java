package aoc2023.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import aoc2023.Calendar;

public class Day01 extends Calendar{
	private static Map<String, Integer> mp = new HashMap<String, Integer>();

	public void run() throws FileNotFoundException {

		File file = new File("./src/aoc2023/day01/files/Input.txt");
		Scanner sc = new Scanner(file);
		mp.put("one", 1);
		mp.put("two", 2);
		mp.put("three", 3);
		mp.put("four", 4);
		mp.put("five", 5);
		mp.put("six", 6);
		mp.put("seven", 7);
		mp.put("eight", 8);
		mp.put("nine", 9);

		Pattern pattern = Pattern.compile("(?=(\\d|one|two|three|four|five|six|seven|eight|nine))");

		int total = 0;

		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			Matcher m = pattern.matcher(s);
			m.find();
			String g1 = m.group(1);
			String g2 = g1;
			while (m.find()) {
				g2 = m.group(1);
			}
			total += getValue(g1) * 10 + getValue(g2);

		}

		sc.close();
		System.out.println(total);

	}

	static int getValue(String s) {
		return s.length() > 1 ? mp.get(s) : Integer.valueOf(s);
	}

}

package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01 {
    	private static Map<String, Character> mp = new HashMap<String, Character>();
        
        public int run() throws FileNotFoundException {


		File file = new File("./src/day01/Input.txt");
		Scanner sc = new Scanner(file);
		mp.put("one", '1');
		mp.put("two", '2');
		mp.put("three", '3');
		mp.put("four", '4');
		mp.put("five", '5');
		mp.put("six", '6');
		mp.put("seven", '7');
		mp.put("eight", '8');
		mp.put("nine", '9');

		Pattern pattern = Pattern.compile("\\d|one|two|three|four|five|six|seven|eight|nine");

		int total = 0;

		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			Matcher m = pattern.matcher(s);
			m.find();
			int iStart1 = m.start();
			int iEnd1 = m.end();
			int iStart2 = iStart1;
			int iEnd2 = iEnd1;
			while (m.find()) {
				iStart2 = m.start();
				iEnd2 = m.end();
			}
			char v1 = getCharValue(s, iStart1, iEnd1);
			char v2 = getCharValue(s, iStart2, iEnd2);
			System.out.println(s);
			System.out.print(v1);
			System.out.println(v2);
			System.out.println();
			total += Integer.valueOf(v1 + "" + v2);
		}

		sc.close();

        return total;
	}

	static char getCharValue(String s, int start, int end) {
		return end - start > 1 ? mp.get(s.substring(start, end)) : s.charAt(start);
	}

}

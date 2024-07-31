import java.io.FileNotFoundException;
import java.util.Scanner;

import aoc2023.Calendar;
import aoc2023.Calendar_v2;
import aoc2023.NoDay;
import aoc2023.day01.Day01;
import aoc2023.day02.Day02;
import aoc2023.day03.Day03;
import aoc2023.day04.Day04;
import aoc2023.day05.Day05;
import aoc2023.day06.Day06;
import aoc2023.day07.Day07;
import aoc2023.day08.Day08;
import aoc2023.day09.Day09;
import aoc2023.day10.Day10;

public class App {
  public static void main(String[] args) throws Exception {
    // Scanner sc = new Scanner(System.in);
    // pseudoDayFactory(9).run();
    Calendar_v2 c = new Calendar_v2();
    c.pickDay(9);
    // gameLoop(sc);
    // sc.close();
  }

  private static void gameLoop(Scanner sc) throws FileNotFoundException {

    System.out.println("Welcome to the advent of code 2023");
    System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
    int input = 0;
    do {
      System.out.println("Scratch your day");
      System.out.println("Enter 0 to exit");
      input = sc.nextInt();
      pseudoDayFactory(input).run();
    } while (input != 0);
    System.out.println("Goodbye");
  }

  private static Calendar pseudoDayFactory(int day) {
    switch (day) {
      case 1:
        return new Day01();
      case 2:
        return new Day02();
      case 3:
        return new Day03();
      case 4:
        return new Day04();
      case 5:
        return new Day05();
      case 6:
        return new Day06();
      case 7:
        return new Day07();
      case 8:
        return new Day08();
      case 9:
        return new Day09();
      case 10:
        return new Day10();
      default:
        return new NoDay();
    }
  }
}

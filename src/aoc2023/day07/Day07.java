package aoc2023.day07;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import aoc2023.Calendar;

/**
 * Day07
 */
public class Day07 extends Calendar {

  private String filename = "./src/aoc2023/day07/files/Input.txt";
  private static Map<Character, Integer> cardValueMap = new HashMap<>();

  private static void fillCardMapPart1() {
    cardValueMap.put('A', 13);
    cardValueMap.put('K', 12);
    cardValueMap.put('Q', 11);
    cardValueMap.put('J', 10);
    cardValueMap.put('T', 9);
    cardValueMap.put('9', 8);
    cardValueMap.put('8', 7);
    cardValueMap.put('7', 6);
    cardValueMap.put('6', 5);
    cardValueMap.put('5', 4);
    cardValueMap.put('4', 3);
    cardValueMap.put('3', 2);
    cardValueMap.put('2', 1);
  }

  private static void fillCardMapPart2() {
    cardValueMap.put('A', 13);
    cardValueMap.put('K', 12);
    cardValueMap.put('Q', 11);
    cardValueMap.put('T', 10);
    cardValueMap.put('9', 9);
    cardValueMap.put('8', 8);
    cardValueMap.put('7', 7);
    cardValueMap.put('6', 6);
    cardValueMap.put('5', 5);
    cardValueMap.put('4', 4);
    cardValueMap.put('3', 3);
    cardValueMap.put('2', 2);
    cardValueMap.put('J', 1);

  }

  /**
   * Parse the document
   * Build HandBidMap<String, Integer>
   * Build RankedHandMap<Integer (value of hand), List<HandBidMap>>
   * Sort each List<HandBidMap>
   * Merge all List<HandBidMap>
   * Return List<HandBidMap>.value * index
   */

  @Override
  public void run() throws FileNotFoundException {
    System.out.println();
    fillCardMapPart2();
    long startRun = System.currentTimeMillis();
    Scanner sc = super.getScanner(filename);
    Map<Integer, ArrayList<HandBidMap>> rankedHandMap = buildRankedHandMap(sc);
    List<HandBidMap> mergeList = getSortedHandList(rankedHandMap);

    System.out.println("Answer:\t" + getTotalBids(mergeList));
    System.out.println("Time:\t" + (System.currentTimeMillis() - startRun));
    sc.close();
  }

  private long getTotalBids(List<HandBidMap> mergeList) {
    long total = 0;
    for (int i = 0; i < mergeList.size(); i++) {
      total += (i + 1) * mergeList.get(i).getBid();
      System.out.println(i + "\t" + mergeList.get(i) + "\t" + total);
    }
    return total;
  }

  private List<HandBidMap> getSortedHandList(Map<Integer, ArrayList<HandBidMap>> rankedHandMap) {
    List<HandBidMap> mergeList = new ArrayList<>();
    rankedHandMap.forEach((k, v) -> {
      sortHandsInRange(v, 0, v.size(), 0);
      mergeList.addAll(v);
    });
    return mergeList;
  }

  private List<HandBidMap> sortHandsInRange(List<HandBidMap> list,
      int start,
      int end,
      int charIndex) {
    // List<HandBidMap> newList = list.subList(start, end);
    // newList.sort((a, b) -> {
    // return cardValueMap.get(a.getKey().charAt(charIndex)) -
    // cardValueMap.get(b.getKey().charAt(charIndex));
    // });

    list.subList(start, end).sort((a, b) -> {
      return cardValueMap.get(a.getKey().charAt(charIndex)) - cardValueMap.get(b.getKey().charAt(charIndex));
    });

    // if ai == ai + n, rStart = i, rEnd = i + n
    if (charIndex < list.get(0).getKey().length() - 1) {

      boolean isRepeatedCard = false;

      for (int i = start + 1; i < end && i < list.size(); i++) {

        char prevHandCard = list.get(i - 1).getKey().charAt(charIndex);
        char currHandCard = list.get(i).getKey().charAt(charIndex);

        if (prevHandCard == currHandCard && !isRepeatedCard) {
          isRepeatedCard = true;
          start = i - 1;
        }

        if (isRepeatedCard && (prevHandCard != currHandCard || i == end - 1)) {
          int rEnd = i;
          if (prevHandCard == currHandCard && i == end - 1) {
            rEnd = end;
          }
          sortHandsInRange(list, start, rEnd, charIndex + 1);
          isRepeatedCard = false;
        }

      }
    }

    return list;
  }

  private Map<Integer, ArrayList<HandBidMap>> buildRankedHandMap(Scanner sc) {
    Map<Integer, ArrayList<HandBidMap>> rankedHandMap = new TreeMap<Integer, ArrayList<HandBidMap>>();
    while (sc.hasNext()) {
      String hand = sc.next();
      int bid = sc.nextInt();
      int handValue = getHandValuePart2(hand);
      ArrayList<HandBidMap> handList = rankedHandMap.getOrDefault(handValue, new ArrayList<HandBidMap>());
      handList.add(new HandBidMap(hand, bid));
      rankedHandMap.put(handValue, handList);
    }
    return rankedHandMap;
  }

  private int getHandValuePart2(String hand) {
    Map<Character, Integer> mp = new HashMap<Character, Integer>();
    int jokerCount = 0;
    for (int i = 0; i < 5; i++) {
      char c = hand.charAt(i);
      if (c == 'J') {
        jokerCount += 1;
      } else {
        mp.put(c, mp.getOrDefault(c, 1) * 4);
      }
    }

    if (jokerCount == 5) {
      mp.put('J', (int) Math.pow(4, jokerCount));
    } else if (jokerCount > 0) {
      char maxKey = Collections.max(mp.entrySet(), Map.Entry.comparingByValue()).getKey();
      mp.put(maxKey, mp.get(maxKey) * jokerCount * 4);
    }
    int total = 0;

    for (char c : mp.keySet()) {
      total += mp.get(c);
    }
    return total;
  }

  private int getHandValue(String hand) {
    Map<Character, Integer> mp = new HashMap<Character, Integer>();
    for (int i = 0; i < 5; i++) {
      char c = hand.charAt(i);
      mp.put(c, mp.getOrDefault(c, 1) * 4);
    }
    int total = 0;

    for (char c : mp.keySet()) {
      total += mp.get(c);
    }
    return total;
  }

}

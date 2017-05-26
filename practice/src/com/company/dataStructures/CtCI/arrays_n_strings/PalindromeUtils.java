package com.company.dataStructures.CtCI.arrays_n_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromeUtils {

  public static void main(String[] args) {
    System.out.printf("rotor is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("rotor"));
    System.out.printf("troor is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("troor"));
    System.out.printf("bag is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("bag"));
    System.out.printf("zzzz is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("zzzz"));
    System.out.printf("zzz is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("zzz"));
    System.out.printf("zza is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("zza"));
    System.out.printf("zzaz is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("zzaz"));
    System.out.printf("'Negative, I am a meat popsicle' is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("Negative, I am a meat popsicle"));
    System.out.printf("'able was i ere i saw elba' is palindrome permutation? %s\n", PalindromeUtils.isPalindromePermutation("able was i ere i saw elba"));
  }

  public static boolean isPalindromePermutation(String candidate) {
    char[] sorted = candidate.toCharArray();
    Arrays.sort(sorted);
    Map<Character, Integer> counts = new HashMap<>(sorted.length);
    for (Character c : sorted) {
      int count = counts.getOrDefault(c, 0);
      if (count == 0) {
        counts.put(c, 1);
      } else {
        counts.put(c, ++count);
      }
    }
    int numberOfOdds = 0;
    for (Character c : counts.keySet()) {
      int count = counts.get(c);
      if (count % 2 > 0) {
        numberOfOdds++;
      }
      if (numberOfOdds > 1) {
        return false;
      }
    }

    return true;
  }

}

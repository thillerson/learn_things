package com.company.khan.recursion;

public class Palindromes {

  public static Boolean test(String candidate) {
    return testEnds(candidate, 0);
  }

  /**
   * Notes:
   * If string.length == 1 || string.length == 0
   * return true
   * Else if string[offset] != string[string.length - 1 - offset]
   * return false
   * Else
   * return palindrome(string, offset + 1)

   * ada
   * abba

   * ada, 0
   * 0, 3-1-0 (2), [a,a]
   * 1, 3-1-1 (1), [b,b]
   * 2, 3-1-2 (0) - bail

   * abba, 0
   * 0, 4-1-0 (3), [a,a]
   * 1, 4-1-1 (2), [b,b]
   * 2, 4-1-2 (1) - bail

   */
  private static Boolean testEnds(String candidate, int offset) {
    int rightOffset = candidate.length() - 1 - offset;
    if (rightOffset < offset) {
      return true;
    } else if (candidate.charAt(offset) != candidate.charAt(rightOffset)) {
      return false;
    } else {
      return testEnds(candidate, offset + 1);
    }
  }

}

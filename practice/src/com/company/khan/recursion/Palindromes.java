package com.company.khan.recursion;

public class Palindromes {

  public static Boolean test(String candidate) {
    return testEnds(candidate, 0);
  }

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

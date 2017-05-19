package com.company.dataStructures.CtCI.arrays_n_strings;

public class URLUtils {

  public static void main(String[] args) {
    String test     = "The Quick Brown Fox      ";
    String expected = "The%20Quick%20Brown%20Fox";
    char[] input = test.toCharArray();
    encodeStringsInPlace(input);
    System.out.printf("Result: %s\n", new String(input));
  }

  public static void encodeStringsInPlace(char[] paddedString) {
    int finalRestingPlace = paddedString.length - 1,
        unprocessed = paddedString.length - 1;
    while(unprocessed > 0) {
      System.out.printf("unprocessed: %s, frp: %s\n", unprocessed, finalRestingPlace);
      if(paddedString[unprocessed] != ' ') {
        while (unprocessed > 0 && paddedString[unprocessed] != ' ') {
          swap(paddedString, unprocessed, finalRestingPlace);
          System.out.printf("After swap: %s\n", new String(paddedString));
          finalRestingPlace--;
          unprocessed--;
        }
        finalRestingPlace = finalRestingPlace - 2;
        addEncodedSpace(paddedString, finalRestingPlace--);
        System.out.printf("After encode: %s\n", new String(paddedString));
      }
      unprocessed--;
    }
  }

  private static void addEncodedSpace(char[] string, int i) {
    string[i] = '%';
    string[i + 1] = '2';
    string[i + 2] = '0';
  }

  private static void swap(char[] array, int a, int b) {
    System.out.printf("Swapping %s with %s\n", array[a], array[b]);
    char temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

}

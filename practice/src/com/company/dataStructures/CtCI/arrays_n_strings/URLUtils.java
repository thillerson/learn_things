package com.company.dataStructures.CtCI.arrays_n_strings;

public class URLUtils {

  public static void main(String[] args) {
    String test     = "The Quick Brown Fox      ";
    String expected = "The%20Quick%20Brown%20Fox";
    char[] input = test.toCharArray();
    encodeSpacesInPlace(input);
    System.out.printf("Result: %s\n", new String(input));
  }

  public static void encodeSpacesInPlace(char[] paddedString) {
    int finalRestingPlace = paddedString.length - 1,
        unprocessed = paddedString.length - 1;
    while(unprocessed > 0) {
      if(paddedString[unprocessed] != ' ') {
        while (unprocessed > 0 && paddedString[unprocessed] != ' ') {
          swap(paddedString, unprocessed, finalRestingPlace);
          finalRestingPlace--;
          unprocessed--;
        }
        finalRestingPlace = finalRestingPlace - 2;
        addEncodedSpace(paddedString, finalRestingPlace);
        finalRestingPlace--;
      }
      unprocessed--;
    }
  }

  private static void addEncodedSpace(char[] string, int i) {
    if (i > 2) {
      string[i] = '%';
      string[i + 1] = '2';
      string[i + 2] = '0';
    }
  }

  private static void swap(char[] array, int a, int b) {
    char temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }

}

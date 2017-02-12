package com.company.dataStructures.arrays;

public class SelectionSort {

  static public void sort(int[] array) {
    int mindex;
    for (int i = 0; i < array.length; i++) {
       mindex = findMindexInSubArray(array, i, array.length);
       swap(array, i, mindex);
    }
  }

  private static void swap(int[] array, int one, int theOther) {
    int placeholder = array[one];
    array[one] = array[theOther];
    array[theOther] = placeholder;
  }

  private static int findMindexInSubArray(int[] array, int left, int right) {
    int min = left;
    for (int i = left + 1; i < right; i++) {
      if (array[i] < array[min]) {
        min = i;
      }
    }
    return min;
  }

}

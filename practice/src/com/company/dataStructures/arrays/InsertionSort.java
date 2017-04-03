package com.company.dataStructures.arrays;

public class InsertionSort {

  public static void sort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      insert(a, i-1, a[i]);
    }
  }

  public static void insert(int[] a, int rightIndex, int value) {
    int valueIndex;
    for (valueIndex = rightIndex;
         valueIndex >= 0 && a[valueIndex] > value;
         valueIndex--
        ) {
      a[valueIndex+1] = a[valueIndex];
    }
    a[valueIndex+1] = value;
  }

}

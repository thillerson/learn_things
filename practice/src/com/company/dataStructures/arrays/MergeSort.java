package com.company.dataStructures.arrays;

import java.util.Arrays;

public class MergeSort {

  public static int[] sort(int[] in) {
    mergeSort(in, 0, in.length);
    return in;
  }

  private static void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      int m = (l + r) / 2;
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);
      merge(arr, l, m, r);
    }
  }

  private static void merge(int[] arr, int l, int m, int r) {
    int leftLength = m - l + 1,
        rightLength = r - m;
    System.out.printf("arr: %s\n", Arrays.toString(arr));
    System.out.printf("left length: %s, right length %s\n", leftLength, rightLength);
    int[] temporaryLeft = new int[leftLength],
          temporaryRight = new int[rightLength];

    for (int i = 0; i < leftLength; i++) {
      temporaryLeft[i] = arr[l + i];
    }
    for (int i = 0; i < rightLength; i++) {
      temporaryRight[i] = arr[m + i + i];
    }
  }
}


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
    int offset, rightIndex;
    int leftLength = m - l + 1,
        rightLength = r - m;
    System.out.printf("arr: %s\n", Arrays.toString(arr));
    System.out.printf("left length: %s, right length %s\n", leftLength, rightLength);
    int[] temporaryLeft = new int[leftLength],
          temporaryRight = new int[rightLength];

    for (int i = l; i <= m; i++) {
      offset = l + i;
      rightIndex = m + 1 + offset;
      temporaryLeft[offset] = arr[i];
      if (rightIndex <= r && rightIndex < arr.length) {
        temporaryRight[offset] = arr[rightIndex];
      }
    }

    int left, right, leftPointer = 0, rightPointer = 0, mergePointer = l;
    while (leftPointer <= m && rightPointer <= r) {
      System.out.printf("left pointer: %s, right pointer %s\n", leftPointer, rightPointer);
      left = temporaryLeft[leftPointer];
      right = temporaryRight[rightPointer];
      if (left < right) {
        arr[mergePointer++] = left;
        arr[mergePointer++] = right;
      } else {
        arr[mergePointer++] = right;
        arr[mergePointer++] = left;
      }
      leftPointer++;
      rightPointer++;
    }
  }
}


package com.company.dataStructures.arrays;

public class QuickSort {

  public static void quickSort(int[] array) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int[] array, int left, int right) {
    if (right > left) {
      int pivot = partition(array, left, right);
      sort(array, left, pivot - 1);
      sort(array, pivot + 1, right);
    }
  }

  private static int partition(int[] array, int left, int right) {
    int lowSide = left,
        index = left,
        pivot = right;

    for (; index < right; index++) {
      if (array[index] < array[pivot]) {
        swap(array, index, lowSide++);
      }
    }
    swap(array, pivot, lowSide);
    return lowSide;
  }

  private static void swap(int[] array, int i1, int i2) {
    int temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }

}

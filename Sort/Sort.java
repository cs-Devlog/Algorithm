/*
 * Bubble Sort
 * Selection Sort
 * Insertion Sort
 * Quick Sort
 * Merge Sort
 * */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] num = {2, 5, 3, 4, 1, 6, 8, 9};
        System.out.println("Start : " + Arrays.toString(num));
//        BubbleSort(num);
//        SelectionSort(num);
//        InsertioinSort(num);
//        QuickSort(0, num.length - 1, num);
//        MergeSort(num, new int[num.length], 0, num.length - 1);
        System.out.println("Final : " + Arrays.toString(num));
    }

    public static void BubbleSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) swap(i, j, num);
            }
        }
    }

    public static void SelectionSort(int[] num) {
        for (int i = 0; i < num.length; i++) {
            int min = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[min] > num[j]) min = j;
            }
            if (num[min] < num[i]) swap(min, i, num);
        }
    }

    public static void InsertioinSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int tmp = num[i];
            for (int j = i - 1; j >= 0; j--) {
                if (tmp < num[j]) {
                    num[j + 1] = num[j];
                    num[j] = tmp;
                }
            }
        }
    }

    //pivot 기준으로 정렬하기
    public static int partition(int left, int right, int[] num) {
        int pivot = num[(left + right) / 2];
        while (left <= right) {
            while (num[left] < pivot) left++;
            while (num[right] > pivot) right--;
            if (left <= right) {
                swap(left, right, num);
                left++;
                right--;
            }
        }
        return left;
    }

    //pivot 기준 좌우 재귀함수
    public static void QuickSort(int left, int right, int[] num) {
        if (left < right) {
            int pivot = partition(left, right, num);
            if (left < pivot - 1) QuickSort(left, pivot - 1, num);
            if (right > pivot) QuickSort(pivot, right, num);
        }
    }

    //배열 쪼개기
    public static void MergeSort(int[] num, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            MergeSort(num, tmp, start, mid);
            MergeSort(num, tmp, mid + 1, end);
            Merge(num, tmp, start, mid, end);
        }
    }

    //배열 합치기
    public static void Merge(int[] num, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = num[i];
        }
        int left = start;
        int right = mid + 1;
        int idx = start;
        while (left <= mid && right <= end) {
            if (tmp[left] <= tmp[right]) {
                num[idx] = tmp[left];
                left++;
            } else {
                num[idx] = tmp[right];
                right++;
            }
            idx++;
        }
        //남은 left의 값들을 num으로 옮기기
        for (int i = 0; i <= mid - left; i++) {
            num[i + idx] = tmp[i + left];
        }
    }

    public static void swap(int left, int right, int[] num) {
        int tmp = num[left];
        num[left] = num[right];
        num[right] = tmp;
        System.out.println("Swap  : " + Arrays.toString(num));
    }
}
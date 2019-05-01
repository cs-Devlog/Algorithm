import java.io.*;
import java.util.*;

public class Main {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n * 2];
        for (int i = 0; i < n; i++) {
            num[0] = Integer.parseInt(br.readLine());
            merge(num, new int[n * 2], 0, n * 2 - 1, num[0]);
        }
        System.out.println(sb);
    }

    public static void merge(int[] num, int[] tmp, int start, int end, int target) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge(num, tmp, start, mid, target);
            merge(num, tmp, mid + 1, end, target);
            mergeSort(num, tmp, start, mid, end, target);
        }
    }

    public static void mergeSort(int[] num, int[] tmp, int start, int mid, int end, int target) {
        for (int i = start; i <= end; i++) {
            tmp[i] = num[i];
        }
        int left = start;
        int right = mid + 1;
        int idx = start;
        int go = 1;
        while (left <= mid && right <= end) {
            if (tmp[left] <= tmp[right]) {
                num[idx++] = tmp[left++];
            } else {
                if (mid == (num.length - 1) / 2 && tmp[left] == target && tmp[right] < target) {
                    go = num.length - right;
                }
                num[idx++] = tmp[right++];
            }
        }
        if (mid == (num.length - 1) / 2) sb.append(go + "\n");
        for (int i = 0; i <= mid - left; i++) {
            num[i + idx] = tmp[i + left];
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[][] num = new int[2][n];
        for (int i = 0; i < 2; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(stk.nextToken());
            }
            num[i] = merge(num[i], new int[n], 0, n - 1);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[0][i] * num[1][n - i - 1];
        }
        System.out.println(sum);
    }

    public static int[] merge(int[] num, int[] tmp, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            merge(num, tmp, start, mid);
            merge(num, tmp, mid + 1, end);
            num = mergeSort(num, tmp, start, mid, end);
        }
        return num;
    }

    public static int[] mergeSort(int[] num, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = num[i];
        }
        int left = start;
        int right = mid + 1;
        int idx = start;
        while (left <= mid && right <= end) {
            if (tmp[left] <= tmp[right]) {
                num[idx++] = tmp[left++];
            } else {
                num[idx++] = tmp[right++];
            }
        }
        for (int i = 0; i <= mid - left; i++) {
            num[i + idx] = tmp[i + left];
        }
        return num;
    }
}
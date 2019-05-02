import java.io.*;
import java.util.*;

public class Main {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());
        int[] lan = new int[k];
        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        long ans = BinarySearch(lan, k, n);
        System.out.println(ans);
    }

    public static long BinarySearch(int[] lan, int k, int n) {
        long left = 1;
        long right = Integer.MAX_VALUE;
        long sum = 0;
        long ans = 0;
        while (left <= right) {
            sum = 0;
            long mid = (left + right) / 2;
            for (int i = 0; i < k; i++) {
                sum += lan[i] / mid;
            }
            if (sum < n) {
                right = mid - 1;
            } else {
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
        }
        return ans;
    }
}
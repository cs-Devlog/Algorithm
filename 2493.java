import java.io.*;
import java.util.*;
/*
    Blog : https://sophia2730.tistory.com/
    Baekjoon
    탑 - 2493
*/
public class Main {
    public static StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(stk.nextToken());
            if (stack.isEmpty()) {
                stack.push(new Pair(i, val));
                bw.write("0 ");
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek().val >= val) {  //stack.peek에 부딪히면
                    bw.write(stack.peek().idx + " ");
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) bw.write("0 ");
            stack.push(new Pair(i, val));
        }
        bw.close();
    }

    public static class Pair {
        int idx, val;

        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
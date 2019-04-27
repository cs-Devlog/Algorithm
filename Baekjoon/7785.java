import java.io.*;
import java.util.*;

public class Main {
    public static StringTokenizer stk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (s[1].equals("enter")) {
                hs.add(s[0]);
            } else {
                hs.remove(s[0]);
            }
        }
        int idx = 0;
        String[] ans = new String[hs.size()];
        for (String s : hs
        ) {
            ans[idx++] = s;
        }
        Arrays.sort(ans, Comparator.reverseOrder());
        for (int i = 0; i < ans.length; i++) {
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        HashSet<String> hs = new HashSet<>();
        while (m-- > 0) {
            String[] line = br.readLine().split(" ");
            switch (line[0]) {
                case "add":
                    hs.add(line[1]);
                    break;
                case "remove":
                    if (hs.contains(line[1])) hs.remove(line[1]);
                    break;
                case "check":
                    sb.append(hs.contains(line[1]) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if (hs.contains(line[1])) hs.remove(line[1]);
                    else hs.add(line[1]);
                    break;
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        hs.add(String.valueOf(i));
                    }
                    break;
                case "empty":
                    hs = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);
    }
}
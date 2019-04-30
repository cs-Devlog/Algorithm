import java.io.*;
import java.util.*;

public class Main {
    static int[] dist = new int[501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        Edge[] edge = new Edge[m + 1];

        // 시작점에서 각 정점으로 가는 최단 거리 저장 배열 초기화
        for (int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= m; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            edge[i] = new Edge(u, v, w);

        }
        dist[1] = 0;        // 1번 정점이 시작점, 시작점까지의 최단거리는 0
        for (int i = 1; i < n; i++) {       // 정점의 수 - 1 번 수행
            for (int j = 1; j <= m; j++) {  // 모든 간선을 사용하여 최단거리가 줄어들면 정보 갱신
                Edge curr = edge[j];
                //u로 가는 최단거리가 바뀌고(무한이 아니고)
                //v로 가는 최단거리 > u까지 필요한 가중치(dist[curr.u]) + u->v 간선 가중치(curr.w)
                if (dist[curr.u] != Integer.MAX_VALUE && dist[curr.v] > dist[curr.u] + curr.w) {
                    dist[curr.v] = dist[curr.u] + curr.w;
                }
            }
        }

        // 음수 cycle 확인
        // 만약 음수 cycle이 없다면 시작점에서 모든 점으로 가는 최단거리는 갱신되어 있어야 한다.
        for (int j = 1; j <= m; j++) {
            // 만약 갱신되는 간선이 있다면 음수 cycle 존재
            if (dist[edge[j].u] != Integer.MAX_VALUE && dist[edge[j].v] > dist[edge[j].u] + edge[j].w) {
                bw.write("-1");
                bw.flush();
                bw.close();
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                bw.write(dist[i] + "\n");
            } else {
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
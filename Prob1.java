import java.io.*;
import java.util.*;

public class Prob1 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] key = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            key[i] = Integer.parseInt(st.nextToken());
        }
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

       
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        int[] pathXor = new int[n + 1];

        Queue<Integer> queue = new ArrayDeque<>();

        // Root node
        parent[1] = 0;
        pathXor[1] = key[1];
        queue.add(1);

        int answer = 0;

        // BFS traversal
        while (!queue.isEmpty()) {

            int current = queue.poll();

            
            if (pathXor[current] >= k) {
                answer++;
            }

            for (int next : graph.get(current)) {

             
                if (next == parent[current]) {
                    continue;
                }

                parent[next] = current;

               
                pathXor[next] = pathXor[current] ^ key[next];

                queue.add(next);
            }
        }

        System.out.println(answer);
    }
}
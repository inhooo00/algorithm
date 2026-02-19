package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S5643_키순서 {
    static int N, M;
    static List<List<Integer>> graph1;
    static List<List<Integer>> graph2;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            graph1 = new ArrayList<>();
            graph2 = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                graph1.add(new ArrayList<>());
                graph2.add(new ArrayList<>());
            }
            for (int j = 0; j < M; j++) {
                String[] input = br.readLine().split(" ");
                graph1.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
                graph2.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
            }
            for (int j = 1; j <= N; j++) {
                int num1 = bfs(j,0);
                int num2 = bfs(j,1);
                //System.out.println(num1 +" " + num2);
                if (num1+num2==N-1) answer++;
            }
            System.out.println("#"+i+" "+answer);
        }
    }
    private static int bfs(int start, int judge){
        int count = 0;
        boolean[] visited = new boolean[N+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;
        if (judge==0){
            while (!deque.isEmpty()){
                int now = deque.remove();
                count++;
                for(Integer g : graph1.get(now)){
                    if (!visited[g]){
                        visited[g] = true;
                        deque.add(g);
                    }
                }
            }
        }else {
            while (!deque.isEmpty()){
                int now = deque.remove();
                count++;
                for(Integer g : graph2.get(now)){
                    if (!visited[g]){
                        visited[g] = true;
                        deque.add(g);
                    }
                }
            }
        }
        return count-1;
    }
}

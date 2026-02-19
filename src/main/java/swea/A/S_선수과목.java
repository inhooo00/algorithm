package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class S_선수과목 {
    static int N;
    static int[] indeg;
    static List<List<Integer>> graph;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            indeg = new int[N+1];
            graph = new ArrayList<>();
            answer = Integer.MIN_VALUE;
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");

                for (int k = 1; k < input.length; k++) {
                    // 먼저해서 -> 다음 가능
                    graph.get(Integer.parseInt(input[k])).add(j+1);
                    // 내 앞 개수
                    indeg[j+1]++;
                }
            }

            Deque<Node> deque = new ArrayDeque<>();
            for (int j = 1; j < indeg.length; j++) {
                if (indeg[j]==0) deque.add(new Node(j,1));
            }

            while (!deque.isEmpty()){
                Node now = deque.remove();
                answer = Math.max(answer, now.depth);
                for(Integer g : graph.get(now.num)){
                    indeg[g]--;
                    if (indeg[g]==0) {
                        deque.add(new Node(g,now.depth+1));
                    }
                }
            }
            boolean check = true;
            for(int j=1;j<indeg.length;j++)
                if (indeg[j]!=0) {
                check = false;
                break;
            }
            if (answer==Integer.MIN_VALUE || !check){
                System.out.println("#"+i+" "+ (-1));
            }else {
                System.out.println("#"+i+" "+answer);
            }

        }
    }
    static class Node{
        int num,depth;
        Node(int num, int depth){
            this.num = num;
            this.depth = depth;
        }
    }
}

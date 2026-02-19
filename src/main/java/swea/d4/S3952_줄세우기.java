package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class S3952_줄세우기 {
    static int N, M;
    static int[] indeg;
    static List<List<Integer>> graph;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            indeg = new int[N + 1];
            answer = new ArrayList<>();
            graph = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                String[] input2 = br.readLine().split(" ");
                // 내 다음 와야하는 수
                graph.get(Integer.parseInt(input2[0])).add(Integer.parseInt(input2[1]));
                // 해당 값 앞에 몇 명이 있는지 누적
                indeg[Integer.parseInt(input2[1])]++;
            }

            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 1; j < indeg.length; j++) {
                if (indeg[j] == 0) {
                    deque.add(j);
                    answer.add(j);
                }
            }

            while (!deque.isEmpty()) {
                int now = deque.remove();
                for(Integer g : graph.get(now)){
                    indeg[g]--;
                    if (indeg[g]==0){
                        deque.add(g);
                        answer.add(g);
                    }
                }
            }

            System.out.print("#" + i + " ");
            for (int j = 0; j < answer.size(); j++) {
                System.out.print(answer.get(j) + " ");
            }
            System.out.println();
        }
    }
}

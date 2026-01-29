package BJ.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

// 먼저 푸는 게 좋은 문제가 있으면 그 문제부터 풀어야함. 즉 그런 조건이 있으면 먼저 풀어야한다는 뜻.
public class B1766_문제집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 전체 문제
        int M = Integer.parseInt(input[1]); // 주어지는 우선순위
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] count = new int[N+1];
        List<Integer> answer = new ArrayList<>();
        // 조건 받기.
        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" "); // A가 B보다 먼저 푸는 게 좋다. 즉 B 앞에 A가 있어야한다.
            int first = Integer.parseInt(input2[0]);
            int second = Integer.parseInt(input2[1]);
            graph.get(first).add(second);
            count[second] ++;
        }

        // bfs
        // 우선순위가 0이 여러개가 있을텐데, 이 0들 중 난이도가 더 낮은 것부터 풀도록 ㅇㅇ.
        PriorityQueue<Integer> deque = new PriorityQueue<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i]==0){
                deque.add(i); // 넣으면 저절로 낮은 것부터 오름차순되니
            }
        }
        while (!deque.isEmpty()){
            int now = deque.remove();
            answer.add(now);
            for (Integer i : graph.get(now)){
                count[i]--;
                if (count[i]==0) deque.add(i);
            }
        }
        for (int i : answer){
            System.out.print(i+" ");
        }
    }
}

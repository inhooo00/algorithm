package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class B2623_음악프로그램 {
    static int N,M;
    static int[] count;
    static List<List<Integer>> degree = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        count = new int[N+1];
        for (int i = 0; i <= N; i++) {
            degree.add(new ArrayList<>());
        }
        // 겹치면 안 됨. 순서가.
        // 할 일의 순서 정하기.
        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 1; j < input2.length-1; j++) {
                degree.get(Integer.parseInt(input2[j])).add(Integer.parseInt(input2[j+1]));
                count[Integer.parseInt(input2[j+1])] ++; // 내 앞에 뭐 잇다. 그 개수
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i]==0){
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            int now = deque.remove();
            answer.add(now);
            for(Integer num : degree.get(now)){
                count[num] --;
                if (count[num]==0){
                    deque.add(num);
                }
            }
        }
        if (answer.size() == N){
            for(Integer i :answer){
                System.out.println(i);
            }
        }
        else {
            System.out.println(0);
        }
    }
}
//6 3
//3 1 4 3
//4 6 2 5 4
//2 2 3
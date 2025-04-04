package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) Q.add(i);
        while (true) {
            if (Q.size() == 1) break;
            Q.poll();
            if (Q.size() == 1) break;
            int num = Q.poll();
            Q.add(num);
        }
        System.out.println(Q.peek());
    }
}

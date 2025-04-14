package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue();
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0) {
                if (queue.isEmpty()) {
                    sb.append(0 +"\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            }else {
                queue.add(num);
            }
        }
        System.out.println(sb);
    }
}

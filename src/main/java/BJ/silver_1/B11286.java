package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class B11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return a - b;
            return Math.abs(a) - Math.abs(b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(num); i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if (inputNum == 0) {
                if (queue.isEmpty()){
                    sb.append(0 +"\n");
                }
                else {
                    sb.append(queue.poll() + "\n");
                }
            }else {
                queue.add(inputNum);
            }
        }
        System.out.println(sb);
    }

}

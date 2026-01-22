package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            field[i][0] = Integer.parseInt(input[0]);
            field[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(field, (a,b) ->{
            if (a[0]==b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        //System.out.println(Arrays.deepToString(field));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(field[0][1]);
        for (int i = 1; i < N; i++) {
            int now = queue.peek();
            if (now <= field[i][0]){
                queue.remove();
            }
            queue.add(field[i][1]);
        }
        System.out.println(queue.size());
    }
}
// 1 4 (1) 4시작
// 3 5 (2) 5시작
// 0 6 (3) 6시작
// 5 7 (1)
// 3 8 (4) 시8작
// 5 9 (2)
// 6 10 (3)
// 8 11 (1)
// 8 12 (4)
// 2 13 (5) 13시작
// 12 14 (1)
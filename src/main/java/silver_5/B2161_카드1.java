package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//예제 입력 1
//7
//예제 출력 1
//1 3 5 7 4 2 6
public class B2161_카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= S; i++) Q.add(i); //값 저장

        while (!Q.isEmpty()) {
            int num = Q.poll();
            list.add(num);
            if (!Q.isEmpty()) {
                int num1 = Q.poll();
                Q.add(num1);
            }
        }

        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");

    }
}

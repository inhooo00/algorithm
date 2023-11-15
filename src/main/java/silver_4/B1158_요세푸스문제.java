package silver_4;//예제 입력 1
//7 3
//예제 출력 1
//<3, 6, 2, 7, 5, 1, 4>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        int N = Integer.parseInt(S[0]); //개수
        int K = Integer.parseInt(S[1]); //순서
        List<Integer> list = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 1; i <= N; i++) Q.add(i); //Q에 저장
        int count = 0;
        while (!Q.isEmpty()) {
            count++;
            int A = Q.poll();
            if (count % K == 0) list.add(A);
            else Q.add(A);
        }
        System.out.println(list.toString().replace("[", "<").replace("]", ">"));
    }
}

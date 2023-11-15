package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); //큐의 크기
        int M = Integer.parseInt(arr[1]); //뽑아내려는 수의 개수
        //Deque<Integer> D = new ArrayDeque<>();
        LinkedList<Integer> LL = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= N; i++) LL.add(i);
        String[] arr_I = br.readLine().split(" ");

        for (int i = 0; i < M; i++) { //뽑아내려는 수의 개수번 만큼
            int target = LL.indexOf(Integer.parseInt(arr_I[i])); //인덱스 찾기
            int half;
            if (LL.size() % 2 == 0) half = LL.size() / 2 - 1;
            else half = LL.size() / 2;

            if (target <= half) {
                for (int j = 0; j < target; j++) {
                    int num = LL.pollFirst();
                    LL.offerLast(num);
                    count++;
                }
            } else {
                for (int j = 0; j < LL.size() - target; j++) {
                    int num = LL.pollLast();
                    LL.offerFirst(num);
                    count++;
                }
            }
            LL.pollFirst();
        }
        System.out.println(count);
    }
}

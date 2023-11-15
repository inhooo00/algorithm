package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class B5555_반지 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        } //배열에 저장


        for (int i = 0; i < N; i++) { //N번
            for (int j = 0; j < 10; j++) { //자리 바꿔가며 넣어주기
                if (arr[i].contains(S)) {
                    answer++;
                    break;
                } else {
                    Queue<String> Q = new LinkedList<>();
                    String[] arr_S = arr[i].split("");
                    for (int k = 0; k < 10; k++) Q.add(arr_S[k]);
                    String st = Q.poll();
                    Q.add(st);
                    arr[i] = "";
                    for (int l = 0; l < 10; l++) arr[i] += Q.poll();
                }

            }

        }
        System.out.println(answer);


    }
}

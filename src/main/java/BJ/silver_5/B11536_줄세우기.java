package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//collections.reversorder
//예제 입력 1
//5
//JOE
//BOB
//ANDY
//AL
//ADAM
//예제 출력 1
//DECREASING, INCREASING, NEITHER
public class B11536_줄세우기 {
    public static void main(String[] args) throws IOException {
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list_1 = new ArrayList<>(); //기본 비열
        List<String> list_origin = new ArrayList<>();
        for (int i = 0; i < N; i++) list_1.add(br.readLine());
        for (int i=0;i<N;i++) list_origin.add(list_1.get(i));
        Collections.sort(list_1);
        List<String> list_2 = new ArrayList<>(); //오름차순 저장
        for (int i = 0; i < list_1.size(); i++) list_2.add(list_1.get(i));
        List<String> list_3 = new ArrayList<>(); //내림차순 저장
        Collections.sort(list_1, Collections.reverseOrder());
        for (int i = 0; i < list_1.size(); i++) list_3.add(list_1.get(i));

        int I_count = 0;
        int D_count = 0;
        for (int i = 0; i < N; i++) {
            if (list_origin.get(i) == list_2.get(i)) I_count += 1;
            if (list_origin.get(i) == list_3.get(i)) D_count += 1;
            //System.out.println(list_1.get(i)+" "+list_2.get(i));
        }
        if (I_count == N) answer = "INCREASING";
        else if (D_count == N) answer = "DECREASING";
        else answer = "NEITHER";

        // System.out.println(I_count);
        System.out.println(answer);


    }
}

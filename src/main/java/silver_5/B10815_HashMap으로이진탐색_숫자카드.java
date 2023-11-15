package silver_5;

import java.io.*;
import java.util.HashMap;

public class B10815_HashMap으로이진탐색_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫번째 숫자 hashmap으로 입력받기 키에 '6 3 2 10 -10' 넣기
        int n = Integer.parseInt(bf.readLine());
        HashMap<Integer, Integer> arrn = new HashMap<>();
        for (int i = 0; i < 1; i++) {
            String[] x = bf.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arrn.put(Integer.parseInt(x[j]), j);
            }
        }


        // 두번째 숫자 배열로 입력받기
        int m = Integer.parseInt(bf.readLine());
        int[] arrm = new int[m];

        // 배열 안에 입력 받기
        for (int i = 0; i < 1; i++) {
            // split 로 잘라서 arr 배열 안에 넣기
            String[] y = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arrm[j] = Integer.parseInt(y[j]);
            }
        }


        // arrn 에 arrm[i] 키가 포함되어있는지 확인하고
        for (int i = 0; i < m; i++) {
            int a = 0;
            if (arrn.containsKey(arrm[i])) {
                // 있으면 a에 +1
                a += 1;
            }else {
                // 없으면 a에 +0
                a += 0;
            }
            // 결과를 출력
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();
    }
}
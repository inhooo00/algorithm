package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//예제 입력 1
//mobitel
//예제 출력 1
//bometil

public class B1251_단어나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr = br.readLine(); //단어 저장
        List<String> list = new ArrayList<>();

        for (int i = 2; i < arr.length(); i++) {
            for (int j = 1; j < i; j++) {
                StringBuilder sb1 = new StringBuilder(arr.substring(0, j));
                StringBuilder sb2 = new StringBuilder(arr.substring(j, i));
                StringBuilder sb3 = new StringBuilder(arr.substring(i));
                String S1 = sb1.reverse().toString();
                String S2 = sb2.reverse().toString();
                String S3 = sb3.reverse().toString();
                list.add(S1 + S2 + S3);
            }

        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}

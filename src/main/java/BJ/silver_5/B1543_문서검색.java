package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String string = br.readLine();
        int count = 0;

        S = S.replaceAll(string,"1");
        for (int i=0;i<S.length();i++){
            if (S.charAt(i)=='1') count++;
        }

        System.out.println(count);

    }
}

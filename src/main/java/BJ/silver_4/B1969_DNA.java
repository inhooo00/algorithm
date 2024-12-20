package BJ.silver_4;//4 10
//ACGTACGTAC
//CCGTACGTAG
//GCGTACGTAT
//TCGTACGTAA
//예제 출력 2
//ACGTACGTAA
//6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1969_DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        String[] dna = new String[Integer.parseInt(arr[0])];
        int answer = 0;
        String answer_arr ="";

        for (int i = 0; i < Integer.parseInt(arr[0]); i++) { //dna 입력 받기
            dna[i] = br.readLine();
        }

        for (int i = 0; i < Integer.parseInt(arr[1]); i++) { //dna 길이만큼
            int a=0,t=0,g=0,c =0;

            for (int j = 0; j < Integer.parseInt(arr[0]); j++) { //각 항들을 비교
                if(dna[j].charAt(i)=='A') a++;
                else if(dna[j].charAt(i)=='T') t++;
                else if(dna[j].charAt(i)=='G') g++;
                else c++;
            }
            answer += Integer.parseInt(arr[0])-Math.max(Math.max(a,t),Math.max(g,c));
            if(Math.max(Math.max(a,t),Math.max(g,c))==a) answer_arr +="A";
            else if(Math.max(Math.max(a,t),Math.max(g,c))==c) answer_arr +="C";
            else if(Math.max(Math.max(a,t),Math.max(g,c))==g) answer_arr +="G";
            else if(Math.max(Math.max(a,t),Math.max(g,c))==t) answer_arr +="T";
        }
        System.out.println(answer_arr);
        System.out.println(answer);
    }
}

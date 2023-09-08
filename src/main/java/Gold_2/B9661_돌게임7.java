package Gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9661_돌게임7 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long N = Long.parseLong(br.readLine());
//        int num = 0;
//        while (0 < N - Math.pow(4, num)) {
//            num++;
//        }
//        num--;
//        // System.out.println(Math.pow(4,num)+1 +" " + N);
//
//        if (Math.pow(4, num) + 1 == N) System.out.println("CY");
//        else System.out.println("SK");
        //처음엔 4의 N승 +1 만 승부가 다르게 나오는 줄 알았음
        //다시 규칙을 찾아보니 승패승승패 반복
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long num = N % 5;
        if (num == 1 || num == 3 || num== 4) System.out.println("SK");
        else System.out.println("CY");

    }
}

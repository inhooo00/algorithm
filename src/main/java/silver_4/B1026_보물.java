package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//예제 입력 2
//3
//1 1 3
//10 30 20
//예제 출력 2
//80
public class B1026_보물 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        String[] arr_A = br.readLine().split(" ");
        String[] arr_B = br.readLine().split(" ");
        int[] arrA = new int[arr_A.length];
        int[] arrB = new int[arr_B.length];
        for (int i = 0; i < arrA.length; i++) arrA[i] = Integer.parseInt(arr_A[i]);
        for (int i = 0; i < arrB.length; i++) arrB[i] = Integer.parseInt(arr_B[i]);
        Arrays.sort(arrA);
        Arrays.sort(arrB);


        for (int i = 0; i < S; i++) {
            answer += arrA[i] * arrB[S - 1 - i];
        }
        System.out.println(answer);


    }
}

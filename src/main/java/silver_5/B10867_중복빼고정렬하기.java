package silver_5;//예제 입력 1
//10
//1 4 2 3 1 4 2 3 1 2
//예제 출력 1
//1 2 3 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10867_중복빼고정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[] arr = new int[S];
        String[] S_arr = br.readLine().split(" ");

        for (int i=0;i<S;i++){
            arr[i] = Integer.parseInt(S_arr[i]);
        }
        Arrays.sort(arr);
        System.out.print(arr[0]+" ");
        for (int i=1;i<arr.length;i++){
            if(arr[i-1]!=arr[i]) System.out.print(arr[i]+" ");
        }
    }
}

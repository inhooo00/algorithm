package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1012 {
    static int[][] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            field = new int[arr[0]][arr[1]];
            for (int j = 0; j < arr[3]; j++) {
                int[] arr2 = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                field[arr2[0]][arr2[1]] = 1;
            }
        }
        System.out.println(Arrays.deepToString(field));
    }
}

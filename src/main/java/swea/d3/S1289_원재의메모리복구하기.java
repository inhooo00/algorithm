package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1289_원재의메모리복구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split("");
            int[] arr = new int[input.length];
            int[] startNum = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                arr[j] = Integer.parseInt(input[j]);
            }
            for (int j = 0; j < input.length; j++) {
                startNum[j] = 0;
            }
            boolean check = true;
            int answer = 0;

            for (int j = 0; j < arr.length; j++) {
                if (check) {
                    for (int k = j + 1; k < arr.length; k++) {
                        startNum[k] = 1;
                    }
                    answer++;
                    check = false;
                } else {
                    for (int k = j + 1; k < arr.length; k++) {
                        startNum[k] = 0;
                    }
                    answer++;
                    check = true;
                }
            }
            System.out.println("#" + T + " " + answer);
        }
    }
}

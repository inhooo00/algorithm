package Bronze_5;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int answer = 0;
        for (int i = 0; i < 5; i++)
            answer += Integer.parseInt(arr[i]) * Integer.parseInt(arr[i]);
        System.out.println(answer % 10);
    }
}

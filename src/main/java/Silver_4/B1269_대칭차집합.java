package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B1269_대칭차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        String[] arr_A = br.readLine().split(" ");
        String[] arr_B = br.readLine().split(" ");
        int num = arr_A.length + arr_B.length;
        HashSet<String> list = new HashSet<>();

        for (int i = 0; i < arr_A.length; i++) list.add(arr_A[i]);
        for (int i = 0; i < arr_B.length; i++) list.add(arr_B[i]);
        num -= list.size();
        int answer = arr_A.length - num + arr_B.length - num;
        System.out.println(answer);

    }
}

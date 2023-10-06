package Bronze_4.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2178_미로찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [ ] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<N;i++) list.add(Integer.parseInt(br.readLine()));


    }
}

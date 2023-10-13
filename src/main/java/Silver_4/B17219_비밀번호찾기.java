package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 저장된 사이트 수
        int M = Integer.parseInt(input[1]); // 찾을 거
        HashMap<String, String> H = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            H.put(arr[0], arr[1]);
        }
        for (int i = 0; i < M; i++) {
            list.add(H.get(br.readLine()));
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

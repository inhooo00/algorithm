package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> H = new HashMap<>();
        int input = Integer.parseInt(br.readLine());
        int enter = -1; // 시작 value
        int answer = 0;

        for (int i = 0; i < input; i++) {
            String st = br.readLine();
            if (st.equals("ENTER")) {
                H.clear();
                enter++;
                continue;
            }
            if (H.containsKey(st)) H.put(st, enter + 1);
            else H.put(st, enter);

            if (H.get(st) == enter) answer++;
        }
        System.out.println(answer);
    }
}

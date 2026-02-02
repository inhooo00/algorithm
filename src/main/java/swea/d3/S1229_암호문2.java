package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S1229_암호문2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            List<Integer> sec = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                sec.add(Integer.parseInt(st.nextToken()));
            }

            int T = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String command = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    for (int k = 0; k < y; k++) {
                        sec.add(x + k, Integer.parseInt(st.nextToken()));
                    }
                } else if (command.equals("D")) {
                    for (int k = 0; k < y; k++) {
                        sec.remove(x);
                    }
                }
            }

            System.out.print("#" + i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(sec.get(j) + " ");
            }
            System.out.println();
        }
    }
}
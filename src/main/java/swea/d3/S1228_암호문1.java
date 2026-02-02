package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S1228_암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());

            String[] original = br.readLine().trim().split("\\s");
            List<Integer> sec = new ArrayList<>();
            for (String s : original) {
                sec.add(Integer.parseInt(s));
            }
            int T = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().split("I");

            for (int j = 1; j < input.length; j++) {
                String[] changeList = input[j].trim().split("\\s+");

                int insertLocation = Integer.parseInt(changeList[0]);
                int count = Integer.parseInt(changeList[1]);

                for (int k = 0; k < count; k++) sec.add(insertLocation + k, Integer.parseInt(changeList[k + 2]));
            }

            System.out.print("#" + i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(sec.get(j) + " ");
            }
            System.out.println();
        }
    }
}
package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        list.add(Integer.parseInt(input1[0]));
        list.add(Integer.parseInt(input1[1]));
        list.add(Integer.parseInt(input2[0]));
        list.add(Integer.parseInt(input2[1]));

        int N = list.get(0) * list.get(3) + list.get(1) * list.get(2); // 분자
        int M = list.get(1) * list.get(3); // 분모
        int gcd = getGcd(N, M);
        System.out.println(N / gcd + " " + M / gcd);
    }

    public static int getGcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGcd(b, a % b);
    }
}

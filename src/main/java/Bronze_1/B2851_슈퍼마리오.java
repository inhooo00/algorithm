package Bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2851_슈퍼마리오 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(Integer.parseInt(br.readLine()));
        int sum = 0;
        int count = 0;
        while (true) {
            sum += list.get(count);
            if (sum >= 100) break;

            count++;
            if (count == 10) {
                count--;
                break;
            }
        }
        int a = sum - list.get(count);
        if (100 - a > sum - 100) System.out.println(sum);
        else if (100 - a == sum - 100) System.out.println(sum);
        else System.out.println(a);

    }
}

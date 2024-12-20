package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2231_반복수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);
        List<String> list = new ArrayList<>();
        list.add(input[0]);
        int count = 0;
        int lastIndex = 0;

        while (true) {
            int num = 0;
            for (int i = 0; i < list.get(count).length(); i++) {
                num += (int) Math.pow(Double.parseDouble(Character.toString(list.get(count).charAt(i))), P);
            }
            if (list.contains(Integer.toString(num))) {
                lastIndex = list.indexOf(Integer.toString(num));
                break;
            } else list.add(Integer.toString(num));
            count++;
        }
        System.out.println(lastIndex);
    }
}

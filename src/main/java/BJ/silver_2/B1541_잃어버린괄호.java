package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.MAX_VALUE;
        String[] arr = br.readLine().split("-");

        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            String[] add = arr[i].split("\\+");
            //split에서 작동을 안 하면 \\붙여봐라

            for (int j = 0; j < add.length; j++) count += Integer.parseInt(add[j]);

            if (num == Integer.MAX_VALUE) num = count;
            else num -= count;
        }
        System.out.println(num);
    }
}

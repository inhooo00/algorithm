package Bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B3009_네번째점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[4][4];
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i][0]))
                list.remove(list.indexOf(arr[i][0]));

            else
                list.add(arr[i][0]);

        }
        answer[0] = list.get(0);
        list.clear();
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i][1]))
                list.remove(list.indexOf(arr[i][1]));
            else
                list.add(arr[i][1]);

        }
        answer[1] = list.get(0);
        System.out.printf(answer[0] + " " + answer[1]);
    }
}

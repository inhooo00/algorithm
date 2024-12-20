package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class B7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, String> H = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            H.put(input[0],input[1]);
        }
        for (String i : H.keySet()){
            if (H.get(i).equals("enter")) list.add(i);
        }

        Collections.sort(list, Collections.reverseOrder());
        //Collections.reverse(list);
        for (String s : list) System.out.println(s);


    }
}

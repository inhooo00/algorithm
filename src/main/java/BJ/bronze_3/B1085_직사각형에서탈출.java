package BJ.bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1085_직사각형에서탈출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(input[0]));
        list.add(Integer.parseInt(input[1]));
        list.add(Integer.parseInt(input[2]) - Integer.parseInt(input[0]));
        list.add(Integer.parseInt(input[3]) - Integer.parseInt(input[1]));
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}

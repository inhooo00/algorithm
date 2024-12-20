package BJ.silver_3;

import java.io.*;
import java.util.*;

public class B11478_서로다른문자열의개수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
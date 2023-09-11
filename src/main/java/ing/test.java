package ing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, String> map = new HashMap<Integer,String>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String input[] = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            String b = input[1];
            map.put(a,b);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        Set<Integer> keySet = map.keySet();

        for (Integer key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
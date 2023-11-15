package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//예제 입력 3
//koder topcoder
//예제 출력 3
//1

public class B1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        List<Integer> answer = new ArrayList<>();
        for (int i=0;i<=arr[1].length()-arr[0].length();i++){
            int count =0;
            for (int j=0;j<arr[0].length();j++){
                if(arr[0].charAt(j)!=arr[1].charAt(i+j)) count++;
            }
            answer.add(count);
        }
        Collections.sort(answer);
        System.out.println(answer.get(0));
    }
}

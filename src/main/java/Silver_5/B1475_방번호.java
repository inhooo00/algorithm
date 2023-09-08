package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1475_방번호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] numSet = new int[10];
        for(char c : N.toCharArray()) {
            int num = c - '0';
            if(num==9) {
                num = 6;
            }
            numSet[num]++;
        }

        // 6과 9는 바꿀 수 있으므로 2로 나눔
        numSet[6] = numSet[6]/2 + numSet[6]%2;

        Arrays.sort(numSet);
        // 오름차순 정렬이므로 마지막 요소 출력
        System.out.println(numSet[9]);
    }
}


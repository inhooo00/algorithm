package Bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2745_진법변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        int num = 0;
        int result = 0;
        int plus = 0;
        for (int i=0;i<S[0].length();i++){
            if(S[0].charAt(i)>='0'&&S[0].charAt(i)<='9') num=S[0].charAt(i)-'0';
            else num=S[0].charAt(i)-55;
            result+=num*Math.pow(Integer.parseInt(S[1]),plus++);
        }
        System.out.println(result);
    }
}

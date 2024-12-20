package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//예제 입력 1
//XXXXXX
//예제 출력 1
//AAAABB
// AA, BBBB or -1
public class B1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int count = 0;
        String answer = "";
        String string = "";
        string = S.replaceAll("XXXX","AAAA");
        answer = string.replaceAll("XX","BB");
        if(answer.contains("X")) answer = "-1";
        System.out.println(answer);


    }
}

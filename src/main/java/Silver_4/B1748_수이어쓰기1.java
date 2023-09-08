package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 1ㅇㅢ자리 9 10의자리
public class B1748_수이어쓰기1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int answer =0;
        int num = 10;
        int mul = 1;
        for (int i =1;i<=s;i++){
            if(i%num==0){
                num*=10;
                mul++;
            }
            answer += mul;
        }
        System.out.println(answer);


    }
}

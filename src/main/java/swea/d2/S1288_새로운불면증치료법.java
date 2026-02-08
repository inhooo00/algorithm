package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// n이 주어지면 배수씩 증가시키면서 확인한 숫자가 0~9 만족할 때까지의 순서 구하기
// 2 4 6 8 10
// 완탐은 안 됨.
// 배수씩 증가. 그리고 숫자 체크

// 1. N의 배수 처리 반복문이 필요
// 2. 그 숫자를 문자열로 바꿔서 한 숫자씩 확인
// 3. 10자리 비트로, 각 자리마다 6번 비트면 비트에다 체크하는 느낌으로. 즉 visited.
// 4. visited 처음에 0으로 써있을 텐데 언젠가 전부 1로 바뀌면 된다.
public class S1288_새로운불면증치료법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int total = (1<<10) -1;
        for (int i = 1; i <= T; i++) {
            int visited = 0;
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            while (true){
                String[] strNum = String.valueOf(N*(++count)).split("");
                for (int j = 0; j < strNum.length; j++) {
                    int num = Integer.parseInt(strNum[j]);
                    visited |= 1<<num;
                }
                if (visited==total) break;
            }
            System.out.println("#"+i+" "+N*count);
        }

    }
}

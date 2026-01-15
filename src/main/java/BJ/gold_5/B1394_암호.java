package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class B1394_암호 {
    static int MOD = 900528;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        String M = br.readLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N.length(); i++) {
            map.put(N.charAt(i), i);
        }

        int nLen = N.length();
        int mLen = M.length();

        // powers는 자리수. 1의자리부터 2자리 3자리.. powers[0] = 1의자리의 가중치
        long[] powers = new long[mLen + 1];
        powers[0] = 1;
        for (int i = 1; i <= mLen; i++) {
            powers[i] = (powers[i - 1] * nLen) % MOD;
        }

        long count = 0;

        // 자릿수 먼저 더하기
        for (int i = 1; i < mLen; i++) {
            count = (count + powers[i]) % MOD;
        }

        // 자릿수는 같은데 내 앞에 있는 숫자 더하기
        for (int i = 0; i < mLen; i++) { // 타깃 문자 길이만큼
            char target = M.charAt(i);
            int index = map.get(target); // 지금 검사할 문자의 위치
            if (index > 0) { // 문자의 위치가 맨 처음이 아니면 그 앞의 경우의 수들을 계산해야함
                long cases = (index * powers[mLen - 1 - i]) % MOD; // 내 앞에 있는 자릿수 * 그 자릿수의 가중값.
                count = (count + cases) % MOD;
            }
        }

        System.out.println((count + 1) % MOD); // +1 해서 나 자체를 선택하는 경우도 추가.
    }
}
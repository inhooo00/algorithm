package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B1107_리모컨 {
    static int N, M; // 이동하려는 채널, 고장 개수
    static List<Integer> list = new ArrayList<>(); // 누를 수 있는 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if (M >0) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                int btn = Integer.parseInt(input[i]);
                broken[btn] = true;
            }
        }

            int minPress = Math.abs(N-100); // 일단 100에서 눌렀을 경우를 최소값으로 두고 시작

            for (int i = 0; i < 1000000; i++) {
                String num = String.valueOf(i);

                boolean isBroken = false;

                for (int j = 0; j < num.length(); j++) { // 현재 내가 처음에 누를거라고 예상한 숫자들 중에 부서진 숫자가 있는지 확인하고 있으면 break;
                    int digit = num.charAt(j) - '0';
                    if (broken[digit]){
                        isBroken = true;
                        break;
                    }
                }
                if (!isBroken){
                    int press = num.length() + Math.abs(N-i);
                    minPress = Math.min(minPress,press);
                }
            }

            System.out.println(minPress);
        }
    }
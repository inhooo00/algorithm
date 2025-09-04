package BJ.silver_4;

// 남학생은 받은 수의 배수의 값을 반대로 변경
// 여학생은 좌우 대칭일 때까지 찾고 그 누적된 값들을 전부 변경

// 전체 개수
// 스위치 상태
// 학생 수
// 여기부터 마지막 줄까지 성별과 번호. (1은 남 2는 여)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 배열 만들고
// for로 하나씩 처내기
public class B1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String 전체개수 = br.readLine();
        String[] 스위치상태 = br.readLine().split(" ");

        int 학생수 = Integer.parseInt(br.readLine());
        String arr[] = new String[학생수];
        for (int i = 0; i < 학생수; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < 학생수; i++) {
            if (arr[i].charAt(0) == '1') { // 남자일 때
                for (int j = 0; j < Integer.parseInt(전체개수); j++) {
                    if ((j + 1) % Integer.parseInt(arr[i].substring(2)) == 0) {
                        if (스위치상태[j].equals("0")) {
                            스위치상태[j] = "1";
                        } else {
                            스위치상태[j] = "0";
                        }
                    }
                }
            }
            if (arr[i].charAt(0) == '2') { // 여자일 때
                int num = Integer.parseInt(arr[i].substring(2));
                if (스위치상태[num - 1].equals("0")) {
                    스위치상태[num - 1] = "1";
                } else {
                    스위치상태[num - 1] = "0";
                }
                int count = 1;
                while (true) {
                    if (num - 1 + count < Integer.parseInt(전체개수) && num - 1 - count >= 0 && 스위치상태[num - 1
                            + count].equals(스위치상태[num - 1 - count])) {
                        if (스위치상태[num - 1 + count].equals("0")) {
                            스위치상태[num - 1 + count] = "1";
                        } else {
                            스위치상태[num - 1 + count] = "0";
                        }
                        if (스위치상태[num - 1 - count].equals("0")) {
                            스위치상태[num - 1 - count] = "1";
                        } else {
                            스위치상태[num - 1 - count] = "0";
                        }
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < 스위치상태.length; i++) {
            System.out.print(스위치상태[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}

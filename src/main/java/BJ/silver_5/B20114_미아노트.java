package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//예제 입력 1
//3 2 2
//a?????
//???bcc
//예제 출력 1
//abc
public class B20114_미아노트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int H = Integer.parseInt(arr[1]);
        int W = Integer.parseInt(arr[2]);
        String answer = "";

        List<String> list = new ArrayList<>();
        List<String> blow = new ArrayList<>();

        for (int i = 0; i < H; i++) list.add(br.readLine());
        for (int i = 0; i < H; i++) {// 가로 갯수 만큼
            String push = "";
            int num = 0;
            for (int j = 0; j < N; j++) { //문자 수
                char C = '?';

                for (int k = 0; k < W; k++) { // 퍼진 수
                    if (list.get(i).charAt(num) != '?') C = list.get(i).charAt(num);
                    num++;
                }
                push += C;
            }
            blow.add(push);
        }
        Character[] arr_I = new Character[N];
        for (int i = 0; i < blow.size(); i++) {
            for (int j = 0; j < N; j++) {
                if (blow.get(i).charAt(j) != '?') arr_I[j] = blow.get(i).charAt(j);
            }

        }
        for (int i = 0; i < arr_I.length; i++) {
            if (arr_I[i] == null) arr_I[i] = '?';
            System.out.print(arr_I[i]);
        }
    }
}

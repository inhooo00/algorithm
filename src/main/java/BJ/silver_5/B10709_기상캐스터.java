package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//예제 입력 1
//3 4
//c..c
//..c.
//....
//예제 출력 1
//0 1 2 0
//-1 -1 0 1
//-1 -1 -1 -1
public class B10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        List<String> list = new ArrayList<>();

        for (int i = 0; i < H; i++) list.add(br.readLine()); //저장


        for (int i = 0; i < H; i++) {
            List<Integer> answer = new ArrayList<>(); //답
            if (list.get(i).charAt(0) == '.') answer.add(-1);
            else answer.add(0);

            for (int j = 1; j < W; j++) {
                if (list.get(i).charAt(j) == '.' && answer.get(j - 1) == -1) answer.add(-1);
                else if (list.get(i).charAt(j) == 'c') answer.add(0);
                else answer.add(answer.get(j - 1) + 1);
            }
            for (int j = 0; j < answer.size(); j++) System.out.print(answer.get(j) + " ");
            System.out.println();
        }


    }
}

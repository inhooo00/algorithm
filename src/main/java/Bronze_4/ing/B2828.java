package Bronze_4.ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//예제 입력 1
//5 1
//3
//1
//5
//3
//예제 출력 1
//6
public class B2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 칸 수
        int M = Integer.parseInt(input[1]); // 바구니 넓이
        int J = Integer.parseInt(br.readLine()); // 사과의 개수
        for (int i=0;i<J;i++) list.add(Integer.parseInt(br.readLine()));
        int count = list.get(0);
        int answer = 0;

        for (int i=1;i<=J;i++){
            int num = count + M - 1;
            int list_num = list.get(i);
            while (true){
                if (count<list_num){ // 시작 부분이 작을 때
                    list_num -= num;
                }
                else list_num += num; // 시작 부분이 클 때
                answer++;
                if(list_num==list.get(i+1)) break;
            }
        }
    }
}

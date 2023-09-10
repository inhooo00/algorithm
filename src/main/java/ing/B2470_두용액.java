package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//예제 입력 1
//5
//-2 4 -99 -1 98
//예제 출력 1
//-99 98
public class B2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String[] arr = br.readLine().split(" ");
        for (int i=0;i<N;i++) list.add(Integer.parseInt(arr[i]));
        Collections.sort(list); //오름차순 정렬

        int[] answer = new int[2]; // 답 도출
        answer[0] = list.get(0); //-값
        answer[1] = list.get(1); //+값
        while (){

        }




    }
}

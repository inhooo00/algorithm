package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 성적, 면접 중 하나가 다른 지원자보다 떨어지지 않ㅇ는 자만 선발.
// A사람의 a가 다른 사람들에 비해 낮으면, b는 다른 사람들에 비해 커야함.
public class B1946_신입사원 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<People> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                list.add(new People(Integer.parseInt(input[0]),Integer.parseInt(input[1])));
            }
            Collections.sort(list, (a,b)->a.paper - b.paper);
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                People now = list.get(j);
                if (min > now.meeting){
                    result[i] ++;
                }
                min = Math.min(now.meeting,min);
            }

        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }
    public static class People{
        int paper, meeting;
        People(int paper, int meeting){
            this.paper = paper;
            this.meeting = meeting;
        }
    }
}

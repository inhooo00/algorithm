package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

// 최대한 많은 상담을 해야함.
// 시간과 값이 있음.

public class B14501_퇴사 {
    static Table[] table;
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new Table[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            table[i] = new Table(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int totalTime, int totalMoney) { // 지금 위치, 지금까지 걸린 시간, 누적 값
        if (totalTime==N){ // 마지막 시간에 도착했을 때의 totalMoney 확인
            answer = Math.max(answer, totalMoney);
            return;
        }
        // 값이 들어오면 2가지로 분기되야함. 안하고 넘어가기, 포함하고 넘어가기
        dfs(totalTime+1,totalMoney);
        if (totalTime+table[totalTime].time <= N) dfs(totalTime+table[totalTime].time, totalMoney+table[totalTime].money);
    }

    private static class Table{
        int time, money;
        Table(int time, int money){
            this.time = time;
            this.money = money;
        }
    }
}

package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 문제 난이도 합 L <= 문제 <= R.
// 최대 난이도 차이 X보다 커야함.
public class B16938_캠프준비 {
    static int N,L,R,X; // 문제 수, 문제 난이도 합 L보다 크거나 같고 R보다 작거나 같음. 문제의 난이도 차이는 X보다 크거나 같다.
    static int[] solution;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>(); // 리스트에 넣으면서 확인
    static List<List<Integer>> resultList = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);
        solution = new int[N]; // 문제
        visited = new boolean[N]; // 방문 처리
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < input2.length; i++) {
            solution[i] = Integer.parseInt(input2[i]);
        }
        // 1. 2문제 이상인 모든 경우 백트래킹으로 처리해서 저장.
        dfs(0,0);

        // 2. 그 문제들 중 조건 충족한 개수 처리.
        for (int i = 0; i < resultList.size(); i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int num : resultList.get(i)){
                sum += num;
                min = Math.min(min,num);
                max = Math.max(max,num);
            }
            if (sum>=L&&sum<=R && Math.abs(max-min)>=X){
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int depth, int start) {
        if (list.size() >= 2){
            List<Integer> innerList = new ArrayList<>(list);
            resultList.add(innerList);
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                list.add(solution[i]);
                dfs(depth+1, i+1);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

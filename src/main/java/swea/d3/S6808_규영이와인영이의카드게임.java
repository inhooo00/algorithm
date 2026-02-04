package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S6808_규영이와인영이의카드게임 {
    static boolean[] visited;
    static int[] answer;
    static List<Integer> kj;
    static List<Integer> ij;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 규영이 카드
            kj = new ArrayList<>(); // 규영이 카드 (고정)
            for (int n : input) {
                kj.add(n);
            }
            ij = new ArrayList<>(); // 인영이 카드
            for (int j = 1; j <= 18; j++) {
                if (!kj.contains(j)) {
                    ij.add(j);
                }
            }
            answer = new int[2]; // 정답
            visited = new boolean[9]; //이미 고른 카드인지 확인

            dfs(0,0); // depth, total
            System.out.println(answer[1] + " " + answer[0]);
        }
    }

    private static void dfs(int depth, int total) {
        if (total > 85) { // 중간 점수 넘는 순간 이겼으니, 이후 경우의수들 다 더하기.
            answer[0] += factorial(depth);
            return;
        }
        if (depth==9) { // 끝까지 도달했으면
            answer[1] ++;
            return;
        }
        for (int i = 0; i < 9; i++) { // 대결
            if (!visited[i]){
                visited[i] = true;
                if (kj.get(depth) < ij.get(i)){
                    dfs(depth+1, total+kj.get(depth)+ij.get(i)); // 이겼을 때
                }
                else{
                    dfs(depth+1, total); // 졌을 때
                }
                visited[i] = false;
            }
        }
    }

    private static int factorial(int depth) {
        int total= 1;
        for (int i = 1; i <= 9-depth; i++) total *= i;
        return total;
    }
}

package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S7206_숫자게임 {
    static int[] memo = new int[100000];
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            Arrays.fill(memo, -1);

            System.out.println("#" + i + " " + solve(N));
        }
    }

    static int solve(int n) {
        if (n < 10) return 0;
        if (memo[n] != -1) return memo[n];

        s = String.valueOf(n);

        boolean[] visited = new boolean[s.length() - 1];

        return memo[n] = dfs(0, visited) + 1;
    }

    static int dfs(int depth, boolean[] visited) {
        if (depth == s.length() - 1) {
            return calculate(visited);
        }

        int maxTurn = 0;

        visited[depth] = true;
        maxTurn = Math.max(maxTurn, dfs(depth + 1, visited));
        visited[depth] = false;

        maxTurn = Math.max(maxTurn, dfs(depth + 1, visited));

        return maxTurn;
    }

    static int calculate(boolean[] visited) {
        int currentMul = 1;
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));

        for (int i = 0; i < visited.length; i++) {
            char nextDigit = s.charAt(i + 1);

            if (visited[i]) {
                currentMul *= Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
            sb.append(nextDigit);
        }
        currentMul *= Integer.parseInt(sb.toString());

        if (currentMul == Integer.parseInt(s)) return 0;

        return solve(currentMul);
    }
}
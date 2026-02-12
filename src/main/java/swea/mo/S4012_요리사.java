package swea.mo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 식제료 반띵해서 맛차이 줄이기.
// n/2뽑 할 때마다, 다른 친구도 결정되니
// 뽑기 조합해서 최소 구하기
public class S4012_요리사 {
    static int N;
    static int[][] field;
    static int min;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            field = new int[N][N];
            visited = new boolean[N];
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    field[j][k] = Integer.parseInt(input[k]);
                }
            }
            min = Integer.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+i+" "+min);
        }
    }
    private static void dfs(int start, int depth){
        if (depth == N/2){
            min = Math.min(min,cal());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                dfs(i+1,depth+1);
                visited[i] = false;
            }
        }
    }
    private static int cal(){
        int first = 0;
        int second = 0;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            if (visited[i]) firstList.add(i);
            else secondList.add(i);
        }

        int size = firstList.size();
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                first += field[firstList.get(i)][firstList.get(j)];
                first += field[firstList.get(j)][firstList.get(i)];
                second += field[secondList.get(i)][secondList.get(j)];
                second += field[secondList.get(j)][secondList.get(i)];
            }
        }
        return Math.abs(first - second);
    }
}

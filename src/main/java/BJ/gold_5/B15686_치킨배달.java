package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import javax.swing.plaf.SpinnerUI;

// 빈칸 0, 집 1, 치킨 2
// 치킨거리는 멘헤튼 거리 (1,2) -> (2,1) = 2
// 가장 많은 수입을 낼 수 있는 치킨집 개수 구하기.
// N과 M 입력.
public class B15686_치킨배달 {
    static int N, M;
    static int[][] field;
    static boolean[] open;
    static List<Node> chickenList = new ArrayList<>();
    static List<Node> homeList = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(input2[j]);
                if (field[i][j] == 2) {
                    chickenList.add(new Node(i, j));
                }else if (field[i][j] == 1){
                    homeList.add(new Node(i,j));
                }
            }
        }
        // 최대 M개 고를 수 있고, 도시의 치킨 거리의 최소값을 구해야함.
        // 1이 2로 도착해야하는데, 일단 2들 중 M개를 골라야 하니까
        // 조합론 써야할 듯.
        // 그렇게 계산하고 나온 거리를 기준으로 배열마다의 멘해튼 거리를 구하고 합을 구한다? 일 듯.
        open = new boolean[chickenList.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int size, int start) {
        if (size == M) {
            result=Math.min(result,cal()); // M개의 치킨리스트만 남으면 각각 치킨거리 계산하고 총합 저장.
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            open[i] =true;
            dfs(size + 1, i + 1);
            open[i] = false;
        }
    }

    private static int cal() {
        int num = 0;
        for (Node node : homeList){ // 집 리스트들
            int total = Integer.MAX_VALUE;
            for (int i = 0; i < chickenList.size(); i++) { // 치킨 리스트들
                if (open[i]){ // 치킨집 열려있으면 거리 구하는데 가장 짧은 값만 취함.
                    Node c = chickenList.get(i);
                    int dist = Math.abs(c.x-node.x)+Math.abs(c.y-node.y);
                    total = Math.min(total,dist);
                }
            }
            num+=total;
        }

        return num;

    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

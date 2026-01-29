package BJ.gold_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// 순서를 구하는 것이니 위상정렬 필요. 내 앞에 누군가가 있는 구조니까.
// 간선 삭제와 추가가 일어남 = 리스트로는 어려우니 배열로 관리해야함.
public class B3665_최종순위 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            List<Integer> answer = new ArrayList<>(); // 답
            int totalTeam = Integer.parseInt(br.readLine());
            boolean[][] connect = new boolean[totalTeam + 1][totalTeam + 1]; // 연결 관리. a가 b보다 앞인지 관리.
            int[] input = Arrays.stream(br.readLine().split(" ")) // 입력 순위. 시작부터 1등
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] count = new int[totalTeam + 1]; // 내 앞에 있는 친구 개수
            for (int j = 0; j < totalTeam; j++) {
                for (int k = j + 1; k < totalTeam; k++) {
                    connect[input[j]][input[k]] = true;
                    count[input[k]]++;
                }
            }
            // 변경 (2,4)
            int changeTeam = Integer.parseInt(br.readLine());
            for (int j = 0; j < changeTeam; j++) {
                int[] team = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                if (connect[team[1]][team[0]]){
                    connect[team[1]][team[0]] = false;
                    connect[team[0]][team[1]] = true;
                    count[team[0]]--;
                    count[team[1]]++;
                }else {
                    connect[team[0]][team[1]] = false;
                    connect[team[1]][team[0]] = true;
                    count[team[1]]--;
                    count[team[0]]++;
                }

            }
            //System.out.println(Arrays.toString(count));
            // bfs로 탐색
            Deque<Integer> deque = new ArrayDeque<>();
            for (int j = 1; j < connect.length; j++) {
                if (count[j] == 0) {
                    deque.add(j);
                }
            }
            boolean isCheck = false;
            while (!deque.isEmpty()) {
                if (deque.size() > 1) {
                    isCheck = true;
                }
                int now = deque.remove();
                answer.add(now);
                for (int j = 1; j < connect[now].length; j++) {
                    if (connect[now][j]) {
                        count[j]--;
                        if (count[j] == 0) {
                            deque.add(j);
                        }
                    }
                }
            }
            // 데이터 일관성은 어떻게 판단하지?
            // 잘못된 거짓말 정보 - impossible
            // 결정 못하는 경우 - ?
            if (answer.size() < totalTeam) {
                System.out.println("IMPOSSIBLE");
            } else if (isCheck) {
                System.out.println("?");
            } else {
                for (int n : answer) System.out.print(n + " ");
                System.out.println();
            }
        }
    }
}
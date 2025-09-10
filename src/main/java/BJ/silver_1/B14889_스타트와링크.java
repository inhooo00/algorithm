package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B14889_스타트와링크 {
    // N개 중에 M 개를 골라서, 차이를 비교해서 최소값을 갱신
    // 4 5 6 이 왔다고 치면 각 값에 대한 배열 값을 더해준다.. 4가 오면 arr[4-1][나머지 값들 -1]을 더해주는 거임..
    // for(뽑은 배열의 길이 만큼(n/2)) 반복을 2번 해서, 각 반복문마다 2중 for문으로 첫 번째를 [값-1][값-1] 을 누적해서 차이를 저장.
    static int N;
    static int MINRESULT = Integer.MAX_VALUE; // 결과값
    static int[][] field; // 필드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }
        dfs(0, new ArrayList<>());
        System.out.println(MINRESULT);
    }

    private static void dfs(int start, List<Integer> list) {
        // 탈출 경우.
        if (list.size() == (N / 2)) { // 순열이 하나 완성되면
            int min = cul(list); // 값을 구하고
            MINRESULT = Math.min(min, MINRESULT); // 최소값 갱신
            return;
        }
        for (int i = start; i < N; i++) {
            list.add(i);
            dfs(i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private static int cul(List<Integer> list) {
        boolean[] booleans = new boolean[N];
        for (int x : list) {
            booleans[x] = true;
        }
        int startSum = 0;
        int linkSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (booleans[i] && booleans[j]) {
                    startSum += (field[i][j] + field[j][i]);
                } else if (!booleans[i] && !booleans[j]) {
                    linkSum += (field[i][j] + field[j][i]);
                }
            }
        }

        return Math.abs(startSum - linkSum);
    }

//    private static int cul(List<Integer> startTeam) {
//        boolean[] isStart = new boolean[N];
//        for (int x : startTeam) {
//            isStart[x] = true;
//        }
//
//        int startSum = 0, linkSum = 0;
//
//        // 팀 점수 계산
//        for (int i = 0; i < N; i++) {
//            for (int j = i+1; j < N; j++) {
//                if (isStart[i] && isStart[j]) {
//                    startSum += field[i][j] + field[j][i];
//                } else if (!isStart[i] && !isStart[j]) {
//                    linkSum += field[i][j] + field[j][i];
//                }
//            }
//        }
//
//        return Math.abs(startSum - linkSum);
//    }

    private static int culpre(int num1, int num2) { // 팀 번호에 따른 계산값
        return field[num1][num2];
    }
}


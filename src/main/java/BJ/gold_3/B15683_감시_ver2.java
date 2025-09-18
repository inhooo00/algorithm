package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B15683_감시_ver2 {
    static int[][] field;
    static int N, M;
    static int[][] rows = {
            {-1, 0}, //상
            {1, 0}, // 하
            {0, -1}, // 좌
            {0, 1} // 우
    };
    static int min = Integer.MAX_VALUE;
    static List<CCTV> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(row[j]);
                if (1 <= field[i][j] && field[i][j] <= 5) {
                    cctvs.add(new CCTV(i, j, field[i][j]));
                }
            }
        }

        dfs(0, field);
        System.out.println(min);
    }

    private static void dfs(int depth, int[][] field) {
        if (depth == cctvs.size()) {
            min = Math.min(min, countSopt(field));
            return;
        }
        CCTV cctv = cctvs.get(depth);
        List<String> directionStrs = getDirectionStrings(cctv.type);

        for (String strs : directionStrs) {
            int[] strArr = Arrays.stream(strs.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[][] copy = copyField(field);

            watch(copy, cctv.x, cctv.y, strArr);
            dfs(depth + 1, copy);
        }
    }

    private static void watch(int[][] copy, int x, int y, int[] strArr) {
        for (int num : strArr) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += rows[num][0];
                ny += rows[num][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || copy[nx][ny] == 6) {
                    break;
                }

                if (copy[nx][ny] == 0) {
                    copy[nx][ny] = 7;
                }
            }
        }
    }

    private static int[][] copyField(int[][] field) {
        int[][] copy = new int[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            copy[i] = Arrays.copyOf(field[i], field[i].length);
        }
        return copy;
    }

    private static int countSopt(int[][] field) {
        int count = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == 0) {
                    count++;
                }
            }

        }
        return count;
    }

    private static List<String> getDirectionStrings(int type) {
        List<String> list = new ArrayList<>();
        if (type == 1) {
            list.add("0");
            list.add("1");
            list.add("2");
            list.add("3");
        } else if (type == 2) {
            list.add("0 1");
            list.add("2 3");
        } else if (type == 3) {
            list.add("0 3");
            list.add("0 2");
            list.add("1 3");
            list.add("1 2");
        } else if (type == 4) {
            list.add("0 2 3");
            list.add("1 2 3");
            list.add("0 1 2");
            list.add("0 1 3");
        } else if (type == 5) {
            list.add("0 1 2 3");
        }

        return list;
    }

    static class CCTV {
        int x;
        int y;
        int type;

        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
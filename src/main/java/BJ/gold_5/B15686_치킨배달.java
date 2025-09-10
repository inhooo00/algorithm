package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B15686_치킨배달 {
    static int N, M;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> houses = new ArrayList<>();
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] stringArr = br.readLine().split(" ");
        N = Integer.parseInt(stringArr[0]);
        M = Integer.parseInt(stringArr[1]);
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (arr[j].equals("1")) {
                    houses.add(new int[]{i, j});
                } else if (arr[j].equals("2")) {
                    chickens.add(new int[]{i, j});
                }
            }
        }
        DFS(0, new ArrayList<>());

        System.out.println(minResult);
    }

    // 치킨 조합으로 최소 구하기 DFS
    private static void DFS(int start, List<int[]> list) {
        if(list.size()==M){
            int minChicken = minChicken(list);
            minResult = Math.min(minChicken,minResult);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            list.add(chickens.get(i));
            DFS(i+1,list);
            list.remove(list.size()-1);
        }
    }

    // 위치에 따른 치킨 거리 최소 값 구하기
    private static int minChicken(List<int[]> chickensList) { // 선택 당한 치킨 리스트들이 넘어옴
        int total = 0;
        for (int[] house : houses) {
            int minNum = Integer.MAX_VALUE;
            for (int[] chicken : chickensList) {
                int result = distance(house, chicken);
                minNum = Math.min(result, minNum);
            }
            total+=minNum;
        }
        return total;
    }

    // 거리 구하기
    private static int distance(int[] arr1, int[] arr2) {
        return Math.abs(arr1[0] - arr2[0]) + Math.abs(arr1[1] - arr2[1]);
    }
}

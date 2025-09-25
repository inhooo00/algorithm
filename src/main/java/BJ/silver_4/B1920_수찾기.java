package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1920_수찾기 {
    static int N,M;
    static StringBuffer sb = new StringBuffer();
    static int[] arr1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        M = Integer.parseInt(br.readLine());
        int[] arr2 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int num : arr2){
            int right = arr1.length-1;
            int left = 0;
            boolean check = false;
            while (left <= right){
                int mid = (right+left)/2;
                if (arr1[mid] == num){
                    check = true;
                    break;
                }
                if(check(mid,num)){
                    right = mid-1;
                }else{
                    left = mid +1;
                }
            }
            if (check){
                sb.append(1).append("\n");
            }else sb.append(0).append("\n");

        }
        System.out.println(sb);
    }

    private static boolean check(int mid, int checkNum) { // mid보다 작은지 판단
        return arr1[mid] > checkNum;
    }
}

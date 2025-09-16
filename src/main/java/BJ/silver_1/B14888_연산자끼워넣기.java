package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14888_연산자끼워넣기 {
    static int N;
    static int[] numbers;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        String[] numInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numInput[i]);
        }

        String[] opInput = br.readLine().split(" ");
        int plus = Integer.parseInt(opInput[0]);
        int minus = Integer.parseInt(opInput[1]);
        int multiply = Integer.parseInt(opInput[2]);
        int divide = Integer.parseInt(opInput[3]);

        dfs(1,numbers[0],plus,minus,multiply,divide);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int deput, int number, int plus, int minus, int multiply, int divide) {
        if(deput == N){
            max = Math.max(max,number);
            min = Math.min(min,number);
            return;
        }

        if (plus>0) dfs(deput+1,number+numbers[deput],plus-1,minus, multiply, divide);
        if (minus>0) dfs(deput+1,number-numbers[deput],plus,minus-1, multiply, divide);
        if (multiply>0) dfs(deput+1,number*numbers[deput],plus,minus, multiply-1, divide);
        if (divide>0) dfs(deput+1,divide(number,numbers[deput]),plus,minus, multiply, divide-1);

    }
    static int divide(int a, int b) {
        if (a < 0) {
            return -(-a / b);
        } else {
            return a / b;
        }
    }
}
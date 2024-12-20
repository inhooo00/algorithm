package BJ.silver_3;

import java.util.Scanner;

public class B1463_1로만들기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        System.out.println(recur(N, 0));
    }

    static int recur(int N, int count) {
        // N이 2 미만인 경우 누적된 count값을 반환
        if (N < 2) {
            return count;
        }
        return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));

    }
}

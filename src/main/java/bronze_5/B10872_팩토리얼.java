package bronze_5;

import java.util.Scanner;

public class B10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double answer = 1;
        for (int i = 0; i < N; i++) {
            answer *= (i + 1);
        }

        System.out.println(answer);
    }
}


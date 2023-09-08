package Bronze_1;

import java.util.Scanner;

public class B1934_최소공배수 {


    public static int gcd(int a, int b) { //유클리드 호제법
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = gcd(a, b);
            System.out.println(a * b / d);
        }


    }
}

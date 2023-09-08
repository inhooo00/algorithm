package Bronze_1;

import java.util.Scanner;

public class B2609_least_common_multiple {


    public static int gcd(int a, int b) { //유클리드 호제법
        if (b == 0) return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = gcd(a,b);
        System.out.println(d);
        System.out.println(a*b/d);



    }
}

package BJ.bronze_1;

import java.util.Scanner;

public class B1924_2007년 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] a = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] b = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int x = sc.nextInt();
        int y = sc.nextInt();

        int day = 0;
        for (int i=0; i<x-1; i++) {
            day += b[i];
        }
        int result = (day + y) % 7;
        System.out.println(a[result]);
    }
}

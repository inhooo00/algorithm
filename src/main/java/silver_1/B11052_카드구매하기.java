package silver_1;//예제 입력 1
//4
//1 5 6 7
//예제 출력 1
//10
//예제 입력 2
//5
//10 9 8 7 6
//예제 출력 2

import java.util.Scanner;

public class B11052_카드구매하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i] = Math.max(d[i], d[i - j] + arr[j]);
            }
        }

        System.out.println(d[n]);//


    }
}

package BJ.silver_4;

import java.util.Scanner;

public class B9613_GCD합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i=0;i<n;i++) {
                arr[i] = sc.nextInt();
            }
            long sum=0;//처음에 int여서 틀림..
            for(int i=0;i<n;i++) {
                for(int j=i;j<n;j++) {
                    if(i!=j) {
                        sum+=gcd(arr[i],arr[j]);
                    }
                }
            }
            System.out.println(sum);
        }
    }


    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);

    }
}

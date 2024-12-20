package BJ.silver_3;

import java.util.Scanner;

public class B9095_123더하기 {
    public static void main(String[] args) {
        int[] array = new int[11];
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        array[0]= 0 ;
        array[1]=1;
        array[2]=2;
        array[3]=4;
        for (int i=4;i<11;i++){
            array[i] = array[i-3]+array[i-2]+array[i-1];
        }
        for (int j=0;j<N;j++){
            int num = sc.nextInt();
            System.out.println(array[num]);
        }


    }
}


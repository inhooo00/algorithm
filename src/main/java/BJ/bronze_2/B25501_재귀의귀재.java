package BJ.bronze_2;

import java.util.Scanner;

public class B25501_재귀의귀재 {

    static int count = 0;

    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int i = 0 ; i < testCase ; i++){
            count = 0;
            String str = sc.next();
            System.out.println(isPalindrome(str) + " " + count);
        }
        sc.close();
    }
}

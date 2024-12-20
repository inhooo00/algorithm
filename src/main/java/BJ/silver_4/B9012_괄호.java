package BJ.silver_4;

import java.util.Scanner;

class Solution {
    boolean solution(String s) {
        int openCount = 0;  // 여는 괄호 개수
        int closeCount = 0; // 닫는 괄호 개수

        if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    openCount++;
                } else if (c == ')') {
                    closeCount++;
                }

                // 여는 괄호 개수보다 닫는 괄호 개수가 더 많으면 올바르지 않은 괄호 문자열
                if (closeCount > openCount) {
                    return false;
                }
            }

            // 여는 괄호와 닫는 괄호 개수가 동일하면 올바른 괄호 문자열
            return openCount == closeCount;
        }

        return false;
    }
}
public class B9012_괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0 ; i<N;i++){
            String S = sc.next();
            Solution solution = new Solution();
            if(solution.solution(S)) System.out.println("YES");
            else System.out.println("NO");

        }
    }
}

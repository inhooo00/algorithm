package jobda;

import java.util.*;
class Sheep {
    public int solution(int N, int[] F, int[] S, int[] B, int T, int P, int Q) {
        if(!isPermutation(B)) return -1;
        int first = howFar(F,B);
        int last = howFar(S,B);

        int delta = last- first;
        if(delta==0) return 0;
        int d = Integer.compare(first,last);
        int p = Math.abs(delta * 60);
        int q = T;

        int gcd = gcd(p,q);
        p /=gcd;
        q /=gcd;

        return d*(p+q);
    }

    private boolean isPermutation(int[] B) {
        Arrays.sort(B);
        for (int i = 0; i < B.length; i++) {
            if (B[i] != i + 1) return false;
        }
        return true;
    }

    private int howFar(int[] F, int[] B){
        int limit = F.length - B.length;
        for(int i=0;i<=limit;i++){
            boolean check = true;
            for(int j=0;j<B.length;j++){
                if(F[j+i] != B[j]){
                    check = false;
                    break;
                }
            }
            if(check) return i+1;
        }
        return -1;
    }

    private int gcd(int a, int b){
        while(b != 0) {
            int tmp = a%b;
            a =b;
            b= tmp;
        }
        return a;
    }
}

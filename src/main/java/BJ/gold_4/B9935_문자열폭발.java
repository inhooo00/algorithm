package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9935_문자열폭발 {
    static String  N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        M = br.readLine();

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < N.length()){
            sb.append(N.charAt(idx));
            if (sb.length()>=M.length() && sb.substring(sb.length()-M.length()).equals(M)){
                //System.out.println(sb.substring(sb.length()-M.length()));
                sb.delete(sb.length()-M.length(), sb.length());
            }
            idx++;
        }
        //System.out.println(sb);

        if (sb.length()==0){
            System.out.println("FRULA");
        }else {
            System.out.println(sb);
        }
    }
}

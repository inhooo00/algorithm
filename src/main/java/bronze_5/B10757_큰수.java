package bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B10757_큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        BigInteger B1 = new BigInteger(arr[0]);
        BigInteger B2 = new BigInteger(arr[1]);
        B1 = B1.add(B2);
        System.out.println(B1.toString());
    }
}


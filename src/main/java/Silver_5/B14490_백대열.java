package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14490_백대열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(":");
        int[] arr_i = new int[2];
        for (int i=Math.min(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]));i>=1;i--){
            if(Integer.parseInt(arr[0])%i==0&&Integer.parseInt(arr[1])%i==0){
                arr_i[0] = Integer.parseInt(arr[0])/i;
                arr_i[1] = Integer.parseInt(arr[1])/i;
                break;
            }
        }
        System.out.println(arr_i[0]+":"+arr_i[1]);
    }
}

package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17504_제리와톰2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] arr_i = new int[N];
        for (int i=0;i<N;i++) arr_i[i] = Integer.parseInt(arr[i]);
        long answer = 0;
        int count = 0;
        long BM = 0;
        long BZ = 0;
        for (int i=N-1;i>0;i++){
            BM = arr_i[N]*arr_i[N-1]+1;
            BZ = arr_i[N];
            count++;
            if(count!=N) {
                long A = BM;
                long B = BZ;
                BZ=A;
                BM=B;
            }
        }
        System.out.println(BZ + " "+BM);
    }
}

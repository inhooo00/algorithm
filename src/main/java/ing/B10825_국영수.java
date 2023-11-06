package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10825_국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] member = new String[N][3];

        for (int i=0;i<N;i++){
                String[] input = br.readLine().split(" ");
                for(int j=0;j<4;j++){
                    member[i][j] = input[j];
                }
        }


    }
}

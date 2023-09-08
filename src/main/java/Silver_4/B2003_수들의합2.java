package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//예제 입력 2
//10 5
//1 2 3 4 2 5 3 1 1 2
//예제 출력 2
//3
public class B2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  S_arr_1 = br.readLine().split(" ");
        int N = Integer.parseInt(S_arr_1[0]);
        int M = Integer.parseInt(S_arr_1[1]);
        String[] S_arr_2  = br.readLine().split(" ");
        int count = 0;

        for (int i=0;i<S_arr_2.length;i++){ //문자 길이만큼 반복
            int sum = 0; //sum 초기화
            for (int j=i;j<S_arr_2.length;j++){
                sum+=Integer.parseInt(S_arr_2[j]);
                if (sum==M) { //같아질 때
                    count++;
                    break;
                }
                else if(sum>=M){ //초과될 때
                    break;
                }

            }

        }
        System.out.println(count);




    }
}

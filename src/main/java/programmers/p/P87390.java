package programmers.p;

public class P87390 {

    class Solution {
        public int[] solution(int n, long left, long right) {
            int[] answer = new int[n*n];
            int[][] arr = new int[n+1][n+1];
            int[] answer2 = new int[(int)(right-left)+1];
            for(int i=0 ; i<n; i++) {
                for(int j=0; j<n;j++) {
                    arr[i][j] = i+1;
                }
                for(int j=0; j<n;j++) {
                    arr[j][i] = i+1;
                }
            }
            int count = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    answer[count] = arr[i][j];
                    count++;
                }
            }

            for(int i=0 ; i<=(int)(right-left) ; i++) {
                answer2[i] = answer[(int)(left)+i];
            }
            return answer2;
        }
    }
}

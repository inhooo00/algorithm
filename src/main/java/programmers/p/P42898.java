package programmers.p;

class P42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n+1][m+1];
        boolean[][] not = new boolean[n+1][m+1];
        arr[1][1] = 1;
        for(int[] pud : puddles){
            not[pud[1]][pud[0]] = true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1&&j==1) continue;
                if(not[i][j]) arr[i][j]=0;
                else{
                    arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000007;
                }

            }
        }
        return arr[n][m];
    }
}
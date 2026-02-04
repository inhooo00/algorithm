package programmers.p;

import java.util.*;
class P1829 {
    int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public int[] solution(int m, int n, int[][] picture) {
        int num = 0;
        int[] answer = new int[2];
        visited = new boolean[picture.length][picture[0].length];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    num ++;
                    max = Math.max(dfs(i,j,m,n,picture),max);
                }
            }
        }
        answer[1] = max;
        answer[0] = num;
        return answer;
    }

    private static int dfs(int x, int y, int m, int n, int[][] picture){
        visited[x][y] = true;
        int count = 1;
        for(int[] row : rows){
            if(x+row[0] >=0 && y+row[1] >= 0 && x+row[0]<m && y+row[1]<n){
                if(!visited[x+row[0]][y+row[1]] && picture[x+row[0]][y+row[1]] ==picture[x][y]){
                    count += dfs(x+row[0],y+row[1],m,n,picture);
                }
            }
        }

        return count;
    }
}
// 1110
// 1220
// 1001
// 0001
// 0003
// 0003

// 1122
// 3344
// 5566
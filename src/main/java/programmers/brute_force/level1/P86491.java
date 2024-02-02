package programmers.brute_force.level1;

// 최소 직사각형
//명함 번호	가로 길이	세로 길이
//1	60	50
//2	30	70
//3	60	30
//4	80	40
public class P86491 {

    public static void main(String[] args) {

    }

    public static int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for (int i=0;i<sizes.length;i++){
            max1 = Math.max(Math.max(sizes[i][0],sizes[i][1]),max1); // 가장 큰 값
            max2 = Math.max(Math.min(sizes[i][0],sizes[i][1]),max2);
        }
        return max1*max2;
    }
}

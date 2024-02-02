package programmers.brute_force.level2;

// 카펫
// brown	yellow	return
//10	2	[4, 3]
//8	1	[3, 3]
//24	24	[8, 6]
public class P42842 {
    public static void main(String[] args) {

    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;

        for(int i=1;i<sum;i++) {
            int row =i; //세로
            int cel = sum / row; //가로

            if(row>cel) continue;

            if((row-2)*(cel-2)==yellow) {
                answer[0] = cel;
                answer[1] = row;
                break;
            }
        }


        return answer;
    }
}

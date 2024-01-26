package programmers.greedy.level2;

import java.util.List;

// 큰 수 만들기
// number	k	return
//"1924"	2	"94"
//"1231234"	3	"3234"
//"4177252841"	4	"775841"
public class P42883 {
    public static void main(String[] args) {

    }
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        char max = '0';
        if (number.charAt(0) == '0') {	// 0일 경우
            answer.append("0");
        }
        for (int i = 0; i < number.length() - k; i++) {	//k개를 빼야하기 때문에 -k.
            max = '0';
            for (int j = cnt; j <= k + i; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    cnt = j + 1;

                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}

package programmers.p;

import java.beans.Introspector;

public class P120818 {
    class Solution {
        public int solution(int price) {
            int answer = 0;
            if (price >= 500000) {
                answer = (price * (100 - 20) / 100);
            } else if (price >= 300000) {
                answer = (price * (100 - 10) / 100);
            } else if (price >=100000) {
                answer = (price * (100 - 5) / 100);
            } else {
                answer = price;
            }
            return answer;
        }
    }
}

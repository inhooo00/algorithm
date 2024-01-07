package programmers.level2;

import java.util.LinkedList;

//prices	return
//[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
// 가장 쉬웠던 문제.
public class P42584 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(solution(prices));
    }

    public static LinkedList solution(int[] prices) {
        LinkedList<Integer> queue = new LinkedList<>();

        int answer = 1;

        for (int i = 0; i < prices.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[i] > prices[j]) break;
            }
            queue.add(count);
        }
        queue.add(0);
        return queue;

    }
}

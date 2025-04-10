package programmers.p;

import java.util.PriorityQueue;
import java.util.Queue;

public class P42626 {
    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12, 4};
        int K = 7;
        Solution solution = new Solution();
        System.out.println(solution.solution(scoville, K));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            Queue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                queue.add(scoville[i]);
            }

            while (queue.size() >= 2 && queue.peek() < K) {
                queue.add(queue.poll() + queue.poll() * 2);
                answer++;
            }

            // 마지막 하나가 K보다 작으면 실패
            if (queue.peek() < K) {
                return -1;
            }
            return answer;
        }
    }
}

package programmers.p;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class P42583 {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        Solution solution = new Solution();
        System.out.println(solution.solution(bridge_length, weight, truck_weights));
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> bridge = new LinkedList<>();
            int answer = 0;
            int currentWeight = 0;
            int idx = 0;

            for (int i = 0; i < bridge_length; i++) {
                bridge.add(0);
            }

            while (!bridge.isEmpty()) {
                answer++;
                currentWeight -= bridge.poll();

                if (idx < truck_weights.length) {
                    if (currentWeight + truck_weights[idx] <= weight) {
                        bridge.offer(truck_weights[idx]);
                        currentWeight += truck_weights[idx];
                        idx++;
                    } else {
                        // 무게 초과면 0 삽입 (트럭 이동만)
                        bridge.add(0);
                    }
                }
            }

            return answer;
        }
    }
}

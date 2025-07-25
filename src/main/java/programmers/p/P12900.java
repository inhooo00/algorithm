package programmers.p;

import java.util.*;

public class P12900 {

    // bfs로 접근했다가 시간초과
    class Solution {
        // 패턴이 2개
        // 가로로 배치할 때는 2개 연달아 넣기.
        // 즉 1칸과 2칸으로 순서 관련해서 모든 경우의 수 구하는 거.
        // 큐에 1칸 2칸을 넣고 시작
        // 계속 더하다가 n까지 값이 오면 answer++;
        // n을 넘어가면 큐에 넣지 말고
        public long solution(int n) {
            long answer = 0;
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(new Node(1, 1));
            deque.add(new Node(2, 2));

            while (!deque.isEmpty()) {
                Node now = deque.remove();
                if (now.count == n) {
                    answer++;
                    continue;
                }
                if (now.count < n) {
                    deque.add(new Node(1, now.count + 1));
                    deque.add(new Node(2, now.count + 2));
                }
            }
            return answer % 1000000007;
        }

        public static class Node {
            int num;
            long count;

            Node(int num, long count) {
                this.num = num;
                this.count = count;
            }
        }
    }

    class Solution2 {
        public long solution(int n) {
            // 1 -> 1
            // 2 -> 2
            // 3 -> 111 12 21 3
            // 4 -> 1111 121 22 211 112 5
            // 5 -> 11111 2111 1211 1121 1112 122 212 221 8
            // 피보나치네
            if(n==1) {
                return 1;
            }
            if(n==2) {
                return 2;
            }
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<=n;i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
            }

            return dp[n];
        }
    }
}

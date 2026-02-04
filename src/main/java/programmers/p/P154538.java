package programmers.p;

import java.util.*;


public class P154538 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 10;
        int y = 40;
        int n = 5;
        System.out.println(solution.solution(x, y, n)); // Expected output: 2
    }

    static class Solution {
    /*
    x+n
    x*2
    x*3
    로 y만드는 최소 연산 횟수
    불가능하면 -1
    */

        public int solution(int x, int y, int n) {
            int answer = 0;
            Deque<Node> queue = new ArrayDeque<>();
            queue.add(new Node(x,0));
            Set<Integer> visited = new HashSet<>();
            visited.add(x);
            while(!queue.isEmpty()){
                Node now = queue.remove();

                if(now.num == y) {
                    return now.count;
                }

                int[] arr = {now.num+n,now.num*2,now.num*3};

                for(int i : arr) {
                    if(y>=i&&!visited.contains(i)){
                        queue.add(new Node(i,now.count+1));
                        visited.add(i);
                        System.out.println(i);
                    }
                }
            }
            return -1;
        }

        static class Node{
            int num;
            int count;
            public Node(int num, int count) {
                this.num = num;
                this.count = count;
            }
        }
    }
}

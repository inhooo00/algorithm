package programmers.p;

import java.util.ArrayDeque;
import java.util.Deque;

public class P17680 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int result = solution.solution(cacheSize, cities);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            Deque<String> deque = new ArrayDeque<>();
                for (int i = 0; i < cities.length; i++) {
                    if (cacheSize == 0){
                        answer += 5;
                        continue;
                    }
                    if (deque.size() < cacheSize && !deque.contains(cities[i].toLowerCase())) { // n개 이하일 때 그냥 넣기
                        deque.add(cities[i].toLowerCase());
                        answer += 5;
                    } else if (deque.contains(cities[i].toLowerCase())) { // 꽉 찼는데 겹치는 거 있는지 확인
                        deque.remove(cities[i].toLowerCase());
                        deque.add(cities[i].toLowerCase());
                        answer += 1;
                    } else { // 겹치는 것도 없으면 그냥 빼기
                        deque.removeFirst();
                        deque.add(cities[i].toLowerCase());
                        answer += 5;
                    }
                }
            return answer;
        }
    }
}

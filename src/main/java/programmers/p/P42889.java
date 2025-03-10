package programmers.p;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 입력값 〉 5, [1, 1, 1, 2, 3, 4]
//기댓값 〉 [4, 1, 3, 2, 5]
// 3/6 1/3 1/2 1/1 0
// 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//1. 8번 돌아서
//2. 해당 스테이지보다 크면 배열에 담고, 그 스테이지에 있는 숫자로 비율 구함
//3. 그거를 총 5번
//4. 각 실패율을 내림차순으로 정렬하면 됨.
public class P42889 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 5;
        int[] stages = {1, 1, 1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.solution(N, stages)));
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            LinkedHashMap<Integer, Double> hashMap = new LinkedHashMap<>();
            int over;
            int same;

            for (int i = 0; i < N; i++) {
                over = 0;
                same = 0;
                for (int j = 0; j < stages.length; j++) {
                    if (stages[j] > i) {
                        over++;
                    }
                    if (stages[j] == (i + 1)) {
                        same++;
                    }
                    if (over == 0) {
                        hashMap.put(i + 1, 0.0);
                    } else {
                        hashMap.put(i + 1, same / (double) over);
                    }
                }
            }
            hashMap = hashMap.entrySet()
                    .stream()
                    .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));
//        hashMap = hashMap.entrySet().stream()
//                .sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1,
//                        LinkedHashMap::new
//                ));

            int index = 0;
            for (int key : hashMap.keySet()) {
                answer[index++] = key;
            }
            return answer;
        }
    }
}

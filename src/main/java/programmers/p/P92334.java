package programmers.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
//따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.
//이용자의 ID가 담긴 문자열 배열 id_list,
// 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report,
// 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
// 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.

// 1. hashmap으로 만들고
// 2. 누적될 때마다 값 증가시키고
// 3. 변수 하나 만들고 기준치 넘으면 그 배열 빼고 나머지 증가시키기.
public class P92334 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution.solution(id_list, report, k)));
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] count = new int[id_list.length];
            int[] answer = new int[id_list.length];
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < id_list.length; i++) {
                hashMap.put(id_list[i], i);
            }

            Set<String> set = new HashSet<>(Arrays.asList(report)); // 중복 제거해서 구성
            List<String> list = new ArrayList<>(set);

            String[] re = set.toArray(new String[0]);
            for (int i = 0; i < set.size(); i++) {
                String[] arr = re[i].split(" ");
                count[hashMap.get(arr[1])]++;
            }

            for (int i = 0; i < list.size(); i++) { // 일정치 넘으면 신고한 사람들에게 보내기
                String[] arr = list.get(i).split(" ");
                if (count[hashMap.get(arr[1])] >= k) {
                    answer[hashMap.get(arr[0])]++;
                }
            }
            return answer;
        }
    }
}

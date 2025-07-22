package programmers.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 숫자를 맵에 키로 넣고 시간을 벨류로 넣음
// 넣다가 out을 만나면 들고 있따는 뜻이니까 번호의 숫자만 가져온다. 이걸 또 최종 맵에다가 넣는다.

public class P92341 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };

        Solution solution = new Solution();
        List<Integer> result = solution.solution(fees, records);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    // 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return
// 출차 안 하면 23:59에 나간 거로 판단
    /*
        1. list에 In일 경우 배열로 하나씩 쌓아감. 통째로 넣음
        2. Out을 만났을 때 출차 진행 . split과 substring으로 비교하기. list에서 뺌.
        3. 시간 계산하고 map에 <차번호,가격> 으로 쌓기.
        4. key에 맞춰서 정렬해서 가격 반환.
     */
    static class Solution {
        public List<Integer> solution(int[] fees, String[] records) {
            List<Integer> answer = new ArrayList<>();
            List<String> list = new ArrayList<>();
            Map<String, Integer> map = new TreeMap<>();

            int 기본시간 = fees[0];
            int 기본요금 = fees[1];
            int 초과하는_분 = fees[2];
            int 초과하는_분당_가격 = fees[3];

            for (int i = 0; i < records.length; i++) {
                String[] arr = records[i].split(" ");
                boolean check = false;

                int j = 0;
                while (j < list.size()) {
                    if (list.get(j).substring(6, 10).equals(arr[1]) && list.get(j).startsWith("IN", 11)) {
                        String[] 들어온시간 = list.get(j).substring(0, 5).split(":");
                        String[] 나간시간 = arr[0].split(":");
                        int before = Integer.parseInt(들어온시간[0]) * 60 + Integer.parseInt(들어온시간[1]);
                        int after = Integer.parseInt(나간시간[0]) * 60 + Integer.parseInt(나간시간[1]);
                        int 총시간 = after - before;
                        map.put(arr[1], map.getOrDefault(arr[1], 0) + 총시간);
                        list.remove(j);
                        check = true;
                        break;
                    } else {
                        j++; // 조건 불충족 시 인덱스 증가
                    }
                }

                if (!check){
                    list.add(records[i]); // 리스트에 넣기
                }
//                System.out.println(i + "지금 리스트값 :" + list);
//                System.out.println(i + "지금 맵 값 :" + map);
            }

            int i = 0;
            while (i < list.size()) {
                String[] arr = list.get(i).split(" ");
                String[] 들어온시간 = list.get(i).substring(0, 5).split(":");
                int re = (23 * 60 + 59) - (Integer.parseInt(들어온시간[0]) * 60 + Integer.parseInt(들어온시간[1]));

                map.put(arr[1], map.getOrDefault(arr[1], 0) + re);

                list.remove(i); // 삭제 후 인덱스 증가하지 않음 (다음 요소가 앞으로 당겨짐)
                // i 증가 안 해도 됨 (삭제되면 다음 요소가 현재 위치로 오기 때문)
            }

            System.out.println(map);

            for (String key : map.keySet()) {
                if (map.get(key) < 기본시간) {
                    answer.add(기본요금);
                } else {
                    if (((map.get(key) - 기본시간) % 초과하는_분) == 0) {
                        answer.add(기본요금 + ((map.get(key) - 기본시간) / 초과하는_분) * 초과하는_분당_가격);
                    }else {
                        answer.add(기본요금 + (((map.get(key) - 기본시간) / 초과하는_분)+1) * 초과하는_분당_가격);
                    }
                }
            }
            return answer;
        }
    }
}

package programmers.p;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class P42579 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        int[] answer = solution.solution(genres, plays);
        for (int a : answer) {
            System.out.println(a);
        }
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = new int[genres.length];
            Map<Integer, List<Object>> hashMap = new LinkedHashMap<>();
            Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
            for (int i = 0; i < genres.length; i++) { // 1. 먼저 인덱스 값을 key로, 그 안에 <genres, plays>를 value를 가지는 hashMap 생성
                hashMap.put(i, List.of(genres[i], plays[i]));
            }

            for (int i = 0; i < genres.length;
                 i++) { // 2. plays를 key로 genres를 value로 하는 LinkedHashMap을 만들고 plays 기준으로 내림차순 정렬
                linkedHashMap.put(plays[i], genres[i]);
            }
            linkedHashMap = linkedHashMap.entrySet().stream()
                    .sorted((Map.Entry.<Integer, String>comparingByKey().reversed()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            Map<String, Integer> linkedHashMap2 = new LinkedHashMap<>(); // 3. 가장 많이 들은 장르를 위한 로직
            for (Integer key : linkedHashMap.keySet()) {
                String genre = linkedHashMap.get(key);
                    linkedHashMap2.put(genre, key + linkedHashMap2.getOrDefault(genre, 0));
            }

            linkedHashMap2 = linkedHashMap2.entrySet().stream() // 4. 정렬해서 먼저 삽입할 장르를 인지
                    .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            Map<Integer, List<Object>> sortedMap = hashMap.entrySet()// 5. 내림차순 정렬
                    .stream()
                    .sorted((a, b) -> ((Integer) b.getValue().get(1)).compareTo((Integer) a.getValue().get(1)))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1,
                            LinkedHashMap::new
                    ));

            // 2개 넘지 않도록 answer 배열에 저장
            Map<String, Integer> countMap = new HashMap<>();
            int num = 0;
            for (String genre : linkedHashMap2.keySet()) { // 장르 우선순위에 따라 삽입
                for (Map.Entry<Integer, List<Object>> entry : sortedMap.entrySet()) {
                    int index = entry.getKey();
                    String currentGenre = (String) entry.getValue().get(0);

                    if (currentGenre.equals(genre)) {
                        int count = countMap.getOrDefault(currentGenre, 0);
                        if (count < 2) {
                            answer[num++] = index;
                            countMap.put(currentGenre, count + 1);
                        }
                    }
                }
            }
            answer = Arrays.copyOfRange(answer, 0, num); // 배열 크기 맞추기

            return answer;
        }
    }
}

package programmers.hash.level2;

import java.util.HashMap;

// 의상
//clothes	return
//[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
//[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	3
// 계산을 해보니 옷의 종류들의 갯수를 곱하고 -1을 하면 답임.
public class P42578 {
    public static void main(String[] args) {

    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>(); // <의상 종류, 개수>

        for(int i = 0; i < clothes.length; i++) {
            // 해당 종류의 옷이 해시맵에 있으면 개수 증가, 없으면 1로 설정
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;
        for(int val : clothesMap.values()) {
            answer *= (val+1); // 각 종류별로 옷을 선택하지 않는 경우를 포함하여 계산
        }

        return answer - 1; // 모든 옷을 선택하지 않는 경우를 제외
    }
}

package programmers.hash.level1;

import java.util.HashMap;

// 완주하지 못한 선수
// participant	completion	return
//["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
public class P42576 {
    public static void main(String[] args) {

    }

    public static  String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> H = new HashMap<>();

        for (int i = 0; i < participant.length; i++) H.put(participant[i], H.getOrDefault(participant[i], 0) + 1);
        //값이 없으면 1 반환, 있으면 2
        for (int i = 0; i < completion.length; i++) H.put(completion[i], H.get(completion[i]) - 1);
        //값이 존재하면 0, 중복된 값이 존재하면 1


        for (String S : H.keySet()) {
            if (H.get(S) == 1) answer = S; //값이 없으면 1, 값이 있으면 0, 값이 중복이면 1
        }
        return answer;
    }
}

package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 시작 전 입장 확인 여부 확인. -> 닉네임으로. 총회 시잦ㄱ하자마자 채팅 남긴 학회원도 제 시간에 입장이 확인된 것으로 간주
// 끝나고 스트리밍을 끝낼 때까지 퇴장 확인 여부 확인. 스트리밍이 끝날 때까지 대화를 한 적이 있는 닉네임 보고 체크.

// 즉 3개의 기준이 주어지면,
// 1.첫번째 까지 대화 기록 저장. 00부터 ~
// 2.총회 끝난 후 ~ 스트리밍 종료 전까지
// 위 2가지에 겹친 사람 수 구하기.

public class B19583_싸이버개강총회 {
    static String start, mid, end;
    static Map<String, Integer> map =  new HashMap<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        start = input[0];
        mid = input[1];
        end = input[2];

        // 00:00 ~ start까지 먼저 hashmap에 넣고 사이즈 구하기
        // mid ~ end까지 hashmap에서 빼고 사이즈 구하기
        // 위 둘을 뺀다.
        String line;
        while ((line = br.readLine()) != null){
            String[] input2 = line.split(" ");
            int startS = Integer.parseInt(start.split(":")[0]);
            int startB = Integer.parseInt(start.split(":")[1]);
            int startTotal = startS*60 + startB;
            int midS = Integer.parseInt(mid.split(":")[0]);
            int midB = Integer.parseInt(mid.split(":")[1]);
            int midTotal = midS*60 + midB;
            int endS = Integer.parseInt(end.split(":")[0]);
            int endB = Integer.parseInt(end.split(":")[1]);
            int endTotal = endS*60 + endB;
            int s = Integer.parseInt(input2[0].split(":")[0]);
            int b = Integer.parseInt(input2[0].split(":")[1]);
            int compareTotal = s*60 + b;
            if (startTotal>=compareTotal) map.put(input2[1],compareTotal);
            else if (midTotal<=compareTotal && endTotal >= compareTotal) map.remove(input2[1]);
            max = Math.max(max, map.size());
        }
        System.out.println(max-map.size());
    }
}

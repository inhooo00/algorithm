package programmers.stack_queue.level2;

import java.util.LinkedList;

//bridge_length	/weight	/truck_weights	/return
//2	10	[7,4,5,6]	8
//100	100	[10]	101
//100	100	[10,10,10,10,10,10,10,10,10,10]	110
public class P42583 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length - 1; i++) queue.add(0);

        int allWeights = truck_weights[0]; // 현재 가중치.
        queue.add(allWeights);
        int index = 1; // 트럭 배열 인덱스.
        int answer = 1; // 시간.

        while (!queue.isEmpty()) {
            answer++;
            int truck = queue.poll();
            allWeights -= truck;

            if (index < truck_weights.length) { // 트럭 남아 있다면.
                if (allWeights + truck_weights[index] <= weight) { // 무게 버틸 수 있다면.
                    allWeights += truck_weights[index]; // total 무게 올림.
                    queue.add(truck_weights[index++]); // queue 라는 다리에 다음 트럭이 올라옴.
                } else queue.add(0); // 만약 무게를 버틸 수 없으면 다리에 아무것도 올라오지 않음!
            }

        }
        return answer;
    }
}

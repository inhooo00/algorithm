package programmers.stack_queue.level2;

import java.util.LinkedList;


//1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
//2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
//3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
//priorities	       location	return
//[2, 1, 3, 2]	         2	        1
//[1, 1, 9, 1, 1, 1]	0	        5
// 처음에는 큐에다가 배열을 저장하지 않고 별 지랄을 떨었다가 실패. 우선순위 큐는 앞으로 배열 사용할 것.
public class P42587 {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) { // queue에 우선순위와 위치를 저장.
            queue.add(new int[]{priorities[i], i});
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean maxPriority = true;

            //큐에 있는 다른 요소들과 우선순위 비교
            for(int[] pair : queue) {
                if(current[0] < pair[0]) {
                    queue.offer(current);
                    maxPriority = false;
                    break;
                }
            }

            //현재 요소가 가장 높은 우선순위를 가지면
            if(maxPriority) {
                answer++;
                if(current[1] == location) {
                    break;
                }
            }
        }
        return answer;
    }
}

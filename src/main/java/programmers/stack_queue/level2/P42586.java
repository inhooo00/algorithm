package programmers.stack_queue.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//progresses	speeds	return
//[93, 30, 55]	[1, 30, 5]	[2, 1]
//[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
public class P42586 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1,30,5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < progresses.length; i++) { //stack에 며칠 걸리는지 넣기
            int count = 0;

            for (int j = progresses[progresses.length-1-i]; j < 100; j += speeds[speeds.length-1-i]) count++;
            stack.push(count);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            int count = 1;
            int num = stack.pop(); // 가장 앞 하나를 빼고


            while (!stack.isEmpty()) { // 누적하기 위해 while사용..
                int peek = stack.peek(); // 그 다음 값을 가지고
                if (num >= peek) { // pop한 값과 그 다음 값 비교
                    count++;
                    stack.pop();
                } else break;
            }
            list.add(count);

        }
        int[] arr = new int[list.size()]; //list 배열로 바꾸기
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;

    }
}

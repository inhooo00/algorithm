package programmers.stack_queue.level1;


import java.util.Stack;

// 같은 숫자는 싫어
//arr	answer
//[1,1,3,3,0,1,1]	[1,3,0,1]
//[4,4,4,3,3]	[4,3]
public class P12906 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(solution(arr));

    }

    public static Stack solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1;i<arr.length;i++) {
            if (arr[i-1]!=arr[i]) stack.push(arr[i]);
        }

        return stack;
    }
}

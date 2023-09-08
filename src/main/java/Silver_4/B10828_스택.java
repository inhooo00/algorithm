package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//push X: 정수 X를 스택에 넣는 연산이다.
//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 스택에 들어있는 정수의 개수를 출력한다.
//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//14
//push 1
//push 2
//top
//size
//empty
//pop
//pop
//pop
//size
//empty
//pop
//push 3
//empty
//top
public class B10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr.length == 2) stack.push(Integer.parseInt(arr[1]));
            else {
                if (arr[0].equals("pop") && stack.size() != 0) {
                    int a = stack.pop();
                    System.out.println(a);
                } else if (arr[0].equals("pop") && stack.size() == 0) {
                    System.out.println(-1);
                } else if (arr[0].equals("size")) {
                    System.out.println(stack.size());
                } else if (arr[0].equals("empty")) {
                    if (stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                } else if (arr[0].equals("top") && stack.size() != 0) {
                    System.out.println(stack.get(stack.size() - 1));
                } else if (arr[0].equals("top") && stack.size() == 0) {
                    System.out.println(-1);
                }
            }
        }
    }
}

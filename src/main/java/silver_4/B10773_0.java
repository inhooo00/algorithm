package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//예제 입력 1
//4

//3
//0
//4
//0
//예제 출력 1
//0
public class B10773_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int N_first = Integer.parseInt(br.readLine());
            if (N_first == 0) stack.pop();
            else stack.push(N_first);
        }
        for (int i = 0; i < stack.size(); i++) answer += stack.get(i);
        System.out.println(answer);
    }
}

package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//예제 입력 1
//3
//ABAB
//AABB
//ABBA
//예제 출력 1
//2
public class B3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i=0;i<N;i++){
            Stack<Character> st = new Stack<>();
            String input = br.readLine();
            for (int j=0;j<input.length();j++){
                if(st.size()>0&&st.peek()==input.charAt(j)) st.pop();
                else st.push(input.charAt(j));
            }
            if (st.size()==0) count++;
        }
        System.out.println(count);

    }
}

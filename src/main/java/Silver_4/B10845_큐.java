package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//15
//push 1
//push 2
//front
//back
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
//front
public class B10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();
        for (int i=0;i<N;i++){
            String[] arr = br.readLine().split(" ");
            if(arr.length==2) Q.add(Integer.parseInt(arr[1]));
            else if(arr[0].equals("pop")&&Q.size()!=0) {
                int a = Q.poll();
                System.out.println(a);
            }
            else if(arr[0].equals("pop")&&Q.size()==0){
                System.out.println(-1);
            }
            else if(arr[0].equals("size")) System.out.println(Q.size());
            else if(arr[0].equals("empty")){
                if(Q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(arr[0].equals("front")&&Q.size()!=0) System.out.println(Q.peek());
            else if(arr[0].equals("front")&&Q.size()==0) System.out.println(-1);
            else if(arr[0].equals("back")&&Q.size()!=0) {
                Integer lastValue = ((LinkedList<Integer>) Q).peekLast();
                System.out.println(lastValue);
            }
            else if(arr[0].equals("back")&&Q.size()==0) System.out.println(-1);
        }
    }
}

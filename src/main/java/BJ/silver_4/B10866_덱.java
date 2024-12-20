package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//push_front X: 정수 X를 덱의 앞에 넣는다.
//push_back X: 정수 X를 덱의 뒤에 넣는다.
//pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 덱에 들어있는 정수의 개수를 출력한다.
//empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//15
//push_back 1
//push_front 2
//front
//back
//size
//empty
//pop_front
//pop_back
//pop_front
//size
//empty
//pop_back
//push_front 3
//empty
//front
public class B10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> D = new ArrayDeque<>();
        for (int i=0;i<N;i++){
            String[] arr = br.readLine().split(" ");
            if(arr.length==2) {
                if(arr[0].equals("push_back")) D.add(Integer.parseInt(arr[1]));
                else D.addFirst(Integer.parseInt(arr[1]));
            }
            else if(arr[0].equals("pop_front")&&D.size()!=0) {
                int a = D.pollFirst();
                System.out.println(a);
            }
            else if(arr[0].equals("pop_front")&&D.size()==0){
                System.out.println(-1);
            }
            else if(arr[0].equals("pop_back")&&D.size()!=0) {
                int a = D.pollLast();
                System.out.println(a);
            }
            else if(arr[0].equals("pop_back")&&D.size()==0){
                System.out.println(-1);
            }
            else if(arr[0].equals("size")) System.out.println(D.size());
            else if(arr[0].equals("empty")){
                if(D.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(arr[0].equals("front")&&D.size()!=0) System.out.println(D.peek());
            else if(arr[0].equals("front")&&D.size()==0) System.out.println(-1);
            else if(arr[0].equals("back")&&D.size()!=0) {
                System.out.println(D.getLast());
            }
            else if(arr[0].equals("back")&&D.size()==0) System.out.println(-1);
        }
    }
}

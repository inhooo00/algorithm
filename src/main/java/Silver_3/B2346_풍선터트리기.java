package Silver_3;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Deque;
//import java.util.List;
//
//public class B2346_풍선터트리기 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        String[] arr = br.readLine().split(" ");
//        Deque<Integer> D = new ArrayDeque<>();
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            D.add(Integer.parseInt(arr[i]));
//            list.add(Integer.parseInt(arr[i]));
//        }
//
//
//        int[] answer = new int[N];
//        answer[0] = list.indexOf(D.getFirst()) + 1; //첫번째 값 저장.
//
//        for (int i = 1; i <= N; i++) {
//            if (D.size() == 1) {
//                answer[N - 1] = list.indexOf(D.getFirst());
//                break;
//            }
//            int num = D.pollFirst(); //첫번째 값 빼기.
//            if (num > 0) {
//                for (int j = 0; j < num; j++) {
//                    int re = D.pollFirst();
//                    D.add(re);
//                }
//                answer[i] = list.indexOf(D.getLast()) + 1;
//                num = D.removeLast();
//                D.addFirst(num);
//            } else {
//                Math.abs(num);
//                for (int j = 0; j < num; j++) {
//                    int re = D.pollLast();
//                    D.addFirst(re);
//                }
//                answer[i] = list.indexOf(D.getFirst()) + 1;
//
//            }
//
//        }
//        for (int i = 0; i < answer.length; i++) System.out.print(answer[i] + " ");
//    }
//}
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B2346_풍선터트리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr_s = br.readLine().split(" ");
        Deque<int[]> list = new ArrayDeque<>();
        for (int i=0 ;i<N;i++) { // List에 배열 넣기
            int[] arr = {i+1,Integer.parseInt(arr_s[i])};
            list.add(arr);
        }

        while (list.size()>1){
            int[] num = list.pollFirst();
            sb.append(num[0]).append(" ");
            int n = num[1];
            if(n>0){
                for (int i=1;i<n;i++){
                    list.addLast(list.pollFirst());
                }
            }
            else{
                for (int i=n;i!=0;i++){
                    list.addFirst(list.pollLast());
                }
            }

        }
        sb.append(list.poll()[0]);
        System.out.println(sb);

    }
}

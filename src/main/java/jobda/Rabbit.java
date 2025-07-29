package jobda;

import java.util.*;
class Solution {
    public int solution(int L, int R, int[] D, int[] F, int[] G, int T, int[] C, int[] B, int W, int[] E) {
        int answer = 0;
        int length = 1;
        Map<Integer, int[]> map = new HashMap<>();

        for(int i=0 ;i<R;i++){
            map.put(D[i],new int[]{F[i],G[i]});
        }
        for(int i=0 ;i<T;i++){
            map.put(C[i],new int[]{-B[i],0});
        }

        boolean[] visited = new boolean[L+1];
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1,0));
        while(!deque.isEmpty()){
            Node now = deque.remove();
            if(now.length >= L) return now.count;
            System.out.print(now.length);
            if(map.get(now.length)==null && !visited[now.length]){
                deque.add(new Node(now.length+1,now.count+1));
                visited[now.length] = true;
            }else if(!visited[now.length]){
                deque.add(new Node(now.length+map.get(now.length)[0],now.count+1));
                deque.add(new Node(now.length+map.get(now.length)[1],now.count+1));
                visited[now.length] = true;
            }
        }

        return -1;
    }

    public static class Node{
        int length;
        int count;
        Node(int length, int count){
            this.length = length;
            this.count = count;
        }
    }
}

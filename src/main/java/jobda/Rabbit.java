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

// +마지막 5단계 문제 못 품
// 정후가 각 격자에 도달하면 격자에 있는 동물의 종류에 따라 행동을 취한다.
// 격자에 토끼가 있 으면 1초 동안 토끼에 쓰여 있는 두 수 중 하나를 선택해 그만큼 앞으로 움직이고,
// 자에 거북 이가 있으면 1초 동안 거북이에 쓰여 있는 수만큼 뒤로 움직인다. 늑대가 있는 격자로는 움직 일 수 없다.
// 아무것도 없으면 1초 동안 앞으로 한 칸 움직인다.
// 늑대 정보도 추가되었는데 그 칸으로 못 간다는 거임.
// 늑대로 가면 아예 그 경로가 안 된다는 거네.
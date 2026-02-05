package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 한 번씩 번갈아 이동하다 이동할 말이 없는 사람이 지는 게임
// 성원이가 이길 수 있는지 판별
public class B15900_나무탈출 {
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점 개수
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N-1; i++) { // 그래프 간선 연결
            String[] input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
            graph.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));

        }
        //System.out.println(graph);
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1,0,0));
        while(!deque.isEmpty()){
            Node now = deque.remove();
            if (graph.get(now.num).size() <= 1 && now.num != 1) { // 연결이 하나거나 없으면 지금 깊이 count
                //System.out.println("깊이 더해줌" + now.depth);
                count+=now.depth;
                continue;
            }
            for(int i : graph.get(now.num)){
                if (now.parent != i) deque.add(new Node(i,now.depth+1, now.num)); // 왔던 곳이 아니면 넣기
            }
        }

        //System.out.println(count);
        if (count % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    static class Node{
        int num,depth, parent;
        Node(int num, int depth, int parent){
            this.num = num;
            this.depth = depth;
            this.parent = parent;
        }
    }
}

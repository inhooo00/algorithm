package programmers.p;

import java.util.*;

class P118669 {

    // 간선 정보를 담기 위한 Node 클래스
    static class Node {
        int node;    // 연결된 노드 번호
        int weight;  // 간선의 가중치 (intensity로 사용)
        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        // 그래프 초기화 (1-based index 사용)
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        // 양방향 간선 정보 입력
        for (int[] path : paths) {
            int from = path[0], to = path[1], cost = path[2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        // 출입구(gate)와 산봉우리(summit) 정보를 Set에 저장해 빠른 조회가 가능하도록 구성
        Set<Integer> 시작Set = new HashSet<>();
        for (int gate : gates) 시작Set.add(gate);

        Set<Integer> 목적지Set = new HashSet<>();
        for (int summit : summits) 목적지Set.add(summit);

        // intensity[i]: i번 노드까지 이동하는 경로 중 최대 간선 가중치의 최소값
        int[] 가중치기최소가되는번호 = new int[n + 1];
        Arrays.fill(가중치기최소가되는번호, Integer.MAX_VALUE);  // 초기값을 매우 크게 설정

        // 우선순위 큐: 현재까지의 intensity가 낮은 노드를 먼저 처리
        PriorityQueue<Node> queue = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );

        // 모든 gate를 시작점으로 설정하여 큐에 추가
        for (int gate : gates) {
            queue.add(new Node(gate, 0));     // 시작 지점의 intensity는 0
            가중치기최소가되는번호[gate] = 0;
        }

        // 다익스트라 기반 탐색 시작
        while (!queue.isEmpty()) {
            Node current = queue.remove();

            // 산봉우리는 도착 지점이므로 이후 경로 탐색은 하지 않음
            if (목적지Set.contains(current.node)) continue;

            // 현재 경로가 기존보다 더 많은 intensity를 가진다면 무시
            if (current.weight > 가중치기최소가되는번호[current.node]) continue;

            // 현재 노드에서 연결된 인접 노드 탐색
            for (Node next : graph.get(current.node)) {
                if (시작Set.contains(next.node)) continue; // 다른 gate는 다시 방문하지 않음

                // 현재 경로의 intensity는 지금까지 온 경로와 새 간선 중 더 큰 값
                int maxIntensity = Math.max(current.weight, next.weight);

                // 해당 노드까지의 intensity를 더 낮은 값으로 갱신할 수 있다면 큐에 추가
                if (가중치기최소가되는번호[next.node] > maxIntensity) {
                    가중치기최소가되는번호[next.node] = maxIntensity;
                    queue.add(new Node(next.node, maxIntensity));
                }
            }
        }

        // 결과 계산: summit들 중 intensity가 가장 낮은 것을 선택 (동률이면 번호가 작은 것)
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);  // 번호가 작은 summit을 우선 선택하기 위해 정렬
        for (int summit : summits) {
            if (가중치기최소가되는번호[summit] < minIntensity) {
                minSummit = summit;
                minIntensity = 가중치기최소가되는번호[summit];
            }
        }

        // 결과 반환: [산봉우리 번호, 최소 intensity]
        return new int[] {minSummit, minIntensity};
    }
}

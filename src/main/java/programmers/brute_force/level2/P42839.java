package programmers.brute_force.level2;
// 피로도
//k	dungeons	result
//80	[[80,20],[50,40],[30,10]]	3
public class P42839 {
    public static void main(String[] args) {

    }

    public int answer; // 최대 던전 수
    public boolean[] visited; // 방문 여부

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }

    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 상태면서 k가 최소 필요 피로도보다 크거나 같은 경우
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true; // 방문 처리
                dfs(depth + 1, k - dungeons[i][1], dungeons); // 재귀 호출
                visited[i] = false; // 방문 초기화
            }
        }
        //가장 큰 값을 answer
        answer = Math.max(answer, depth);
    }
    // dfs 메서드 설명 : 모든 경우를 다 보는 것. 근데 이제 이미 들어간 던전이거나 최소 필요 피로도를 충족시키기 못하면 다음 던전을 확인함.
    // 그렇게 하나 들어갈 때마다 depth를 증가시키고 가장 큰 depth를 answer에 저장.
}

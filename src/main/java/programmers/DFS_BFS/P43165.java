package programmers.DFS_BFS;

// 타겟 넘버
//numbers	target	return
//[1, 1, 1, 1, 1]	3	5
//[4, 1, 2, 1]	4	2
public class P43165 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }


    public void dfs(int[] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(target == sum) answer++;
            return;
        }
        dfs(numbers, target, idx+1, sum+numbers[idx]);
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}

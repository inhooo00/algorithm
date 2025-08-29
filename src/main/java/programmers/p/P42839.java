package programmers.p;

import java.util.*;
class P42839 {
    Set<Integer> list = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers,"",visited);
        for(int num : list){
            if(judge(num)) answer++;
        }
        return answer;
    }
    private void dfs(String numbers, String current, boolean[] visited){
        if(!current.equals("")) list.add(Integer.parseInt(current));
        for(int i=0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }

        }
    }
    // 소수인가
    private boolean judge(int num){
        if(num==0) return false;
        if(num==1) return false;
        if(num==2) return true;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
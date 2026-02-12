package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 중복 불가 순열을 짜서 계산 돌리기?
public class S_풍선사격게임 {
    static int N;
    static List<Integer> bl;
    static  boolean[] visited;
    static int max;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=1;i<=T;i++){
            N = Integer.parseInt(br.readLine());
            bl = new ArrayList<>();
            visited = new boolean[N];
            max = Integer.MIN_VALUE;
            list = new ArrayList<>();
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                bl.add(Integer.parseInt(input[j]));
            }
            dfs(0);
            System.out.println("#"+i+" "+max);
        }

    }

    private static void dfs(int depth) {
        if (depth==N) {
            max = Math.max(max,cal());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                list.add(bl.get(i));
                dfs(depth+1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    // 사이에 있으면 양쪽 곱 +
    // 가장자리면 왼쪽, 오른쪽 값 +
    // 하나만 남으면 하나 +
    private static int cal() {
        List<Integer> copyBl = new ArrayList<>(bl);
        int result = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) { // N 번
            if (i==size-1){ // 마지막일 때
                result+= copyBl.remove(0);
            }else if (copyBl.indexOf(list.get(i))==0){ // 왼쪽 끝이면
                result+= copyBl.get(1);
                copyBl.remove(0);
            }else if (copyBl.indexOf(list.get(i))==copyBl.size()-1){
                result+= copyBl.get(copyBl.size()-2);
                copyBl.remove(copyBl.size()-1);
            }else {
                int first = copyBl.get(copyBl.indexOf(list.get(i))+1);
                int second = copyBl.get(copyBl.indexOf(list.get(i))-1);
                result += first*second;
                copyBl.remove(list.get(i));
            }
        }
        return result;
    }
}

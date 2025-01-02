package programmers.p;

public class P340199 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {50, 50};
        int[] arr2 = {100, 241};
        int[] arr3 = {102, 1}; // w
        int[] arr4 = {50, 100}; // b
        System.out.println(solution.solution(arr4, arr3));
    }

    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            while (true) {
                if (bill[0] > wallet[0]) {
                    if (bill[0] > wallet[1]){
                        answer++;
                        bill[0] = bill[0] / 2;
                        continue;
                    }
                    else if (bill[1] < wallet[0]){
                        return answer;
                    } else {
                        answer++;
                        bill[0] = bill[0] / 2;
                        continue;
                    }

                } else if (bill[1] > wallet[1]) {
                    if (bill[1] > wallet[0]){
                        answer++;
                        bill[1] = bill[1] / 2;
                        continue;
                    }
                    else if (bill[0] < wallet[1]){
                        return answer;
                    }else {
                        answer++;
                        bill[1] = bill[1] / 2;
                        continue;
                    }
                }
                return answer;
            }
        }
    }
}

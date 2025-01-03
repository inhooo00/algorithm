package programmers.p;

public class P340199 {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr1 = {30, 15};
//        int[] arr2 = {26, 17};
//        int[] arr3 = {102, 1}; // w
//        int[] arr4 = {50, 100}; // b
//        System.out.println(solution.solution(arr1, arr2));
//    }

    static class Solution {
        public int solution(int[] wallet, int[] bill) {
            int answer = 0;
            while (true){
                int wallet_max = Math.max(wallet[0], wallet[1]);
                int wallet_min = Math.min(wallet[0], wallet[1]);
                int bill_max = Math.max(bill[0], bill[1]);
                int bill_min = Math.min(bill[0], bill[1]);

                if (wallet_max < bill_max || wallet_min < bill_min) {
                    if (bill[0] > bill[1]) {
                        bill[0] /= 2;
                        answer++;
                    } else if (bill[1] > bill[0]) {
                        bill[1] /= 2;
                        answer++;
                    }
                } else {
                    return answer;
                }
            }
        }
    }
}

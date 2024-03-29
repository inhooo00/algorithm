package programmers.p;

//조건에 맞게 수열 변환하기 1
//arr	result
//[1, 2, 3, 100, 99, 98]	[2, 2, 6, 50, 99, 49]
public class P181882 {
    class Solution {
        public int[] solution(int[] arr) {
            int[] answer = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) answer[i] = arr[i] / 2;
                else if (arr[i] < 50 && arr[i] % 2 == 1) answer[i] = arr[i] * 2;
                else answer[i] = arr[i];
            }
            return answer;
        }
    }
}

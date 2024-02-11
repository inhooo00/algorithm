package programmers.p;

import java.util.Arrays;

// 수열 구간 쿼리 3
//arr	queries	result
//[0, 1, 2, 3, 4]	[[0, 3],[1, 2],[1, 4]]	[3, 4, 1, 0, 2]
public class P181924 {
    public static void main(String[] args) {

    }
   class Solution {
        public int[] solution(int[] arr, int[][] queries) {
            for(int[] query : queries) {
                int temp = arr[query[0]];
                arr[query[0]] = arr[query[1]];
                arr[query[1]] = temp;
            }
            return arr;
        }
    }
    }

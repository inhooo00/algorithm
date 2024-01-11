package programmers.hash.level1;

import java.util.Arrays;
//nums	result
//[3,1,2,3]	2
//[3,3,3,2,2,4]	3
//[3,3,3,2,2,2]	2
//폰켓몬. 중복 없이 배열 만들고 n/2 값과 비교하여 옳은 값 출력.
public class P1845 {
    public static void main(String[] args) {

    }
    public static int solution(int[] nums) {
        int[] arr = Arrays.stream(nums).distinct().toArray();
        return Math.min(arr.length, nums.length / 2);
    }
}

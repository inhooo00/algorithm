package programmers.p;
//정수 찾기
//num_list	n	result
//[1, 2, 3, 4, 5]	3	1
//[15, 98, 23, 2, 15]	20	0
public class P181840 {
    class Solution {
        public int solution(int[] num_list, int n) {
            for (int i=0;i<num_list.length;i++){
                if(num_list[i]==n) return 1;
            }
            return 0;
        }
    }
}

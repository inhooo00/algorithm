package programmers.p;

import java.util.ArrayList;
import java.util.List;

//n 번째 원소까지
//num_list	n	result
//[2, 1, 6]	1	[2]
//[5, 2, 1, 7, 5]	3	[5, 2, 1]
public class P181889 {
    class Solution {
        public List solution(int[] num_list, int n) {
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<n;i++){
                list.add(num_list[i]);
            }

            return list;
        }
    }
}

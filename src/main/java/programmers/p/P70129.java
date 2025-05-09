package programmers.p;

import programmers.p.P67256.Solution;

public class P70129 {

    Solution solution = new Solution();

    public static void main(String[] args) {
        P70129 p70129 = new P70129();
        int[] result = p70129.solution.solution("110010101001");
        for (int i : result) {
            System.out.print(i + " ");
        }
    }


    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            String lastNum = s;
            int zc = 0;
            int count = 0;

            while (true){
                count++;
                String num = "";
                for (int i = 0; i < lastNum.length(); i++) {
                    if (lastNum.charAt(i) == '1') {
                        num += "1";
                    }else {
                        zc++;
                    }
                }
                lastNum = Integer.toBinaryString(num.length());
                System.out.println(lastNum);
                if (num.length()!=1){
                    continue;
                }
                break;
            }
            answer[1]=zc;
            answer[0]=count;
            return answer;
        }
    }
}

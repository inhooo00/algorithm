package programmers.p;
//문자열의 뒤의 n글자
//my_string	n	result
//"ProgrammerS123"	11	"grammerS123"
//"He110W0r1d"	5	"W0r1d"
public class P181907 {
    class Solution {
        public String solution(String my_string, int n) {
            String answer = my_string.substring(0,n);
            return answer;
        }
    }
}

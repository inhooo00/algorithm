package programmers.p;

public class P81301 {

    // "one4seveneight"	1478
    //"23four5six7"	234567
    //"2three45sixseven"	234567
    //"123"	123

    // 0	zero
    //1	one
    //2	two
    //3	three
    //4	four
    //5	five
    //6	six
    //7	seven
    //8	eight
    //9	nine
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "one4seveneight";

        System.out.println(solution.solution(s));
    }


    static class Solution {
        public int solution(String s) {
            String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] alphabets = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < 10; i++) {
                s = s.replaceAll(alphabets[i], digits[i]);
            }

            return Integer.parseInt(s);
        }
    }}


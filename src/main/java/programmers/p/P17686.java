package programmers.p;

import java.util.*;

public class P17686 {

// head는 첫 숫자가 나오기 전까지 - 대소문자 통일
// 그 뒤 숫자는 최대 5글자까지 - Integer로 맨 앞 0 제거
// 그 뒤는 있을수도 없을 수도 - 없으면 빈문자열

    class Solution {
        public String[] solution(String[] files) {
            String[] arr = files;
            Arrays.sort(arr , (o1 , o2) -> {
                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();
                if(head1.compareTo(head2) == 0) {
                    int number1 = getNumber(o1.substring(head1.length()));
                    int number2 = getNumber(o2.substring(head2.length()));
                    return number1-number2;
                }else{
                    return head1.compareTo(head2);
                }
            });

            return arr;
        }

        public static int getNumber(String s){
            char[] arr = s.toCharArray();
            String result = "";
            for(int i=0; i<arr.length;i++){
                if(Character.isDigit(arr[i]) && result.length() <5) {
                    result+=arr[i];
                }else {
                    break;
                }
            }
            return Integer.parseInt(result);
        }
    }
}

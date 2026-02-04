package programmers.p;
import java.util.*;
public class P42888 {

    class Solution {
        // map으로 처리해야할 거 같은데? 아이디 기준으로 enter이랑 change 기준으로 계속 업데이트하면서 넣고
        // 마지막에 배열에 넣고 끝내기.
        public List<String> solution(String[] record) {
            String[] answer = new String[record.length];
            List<String> list = new ArrayList<>();
            Map<String,String> map = new HashMap<>();
            for(String rec : record) {
                String[] arr = rec.split(" ");
                if(arr[0].equals("Enter")||arr[0].equals("Change")){
                    map.put(arr[1],arr[2]);
                }
            }
            for(int i=0; i<record.length;i++){
                String[] arr = record[i].split(" ");
                if(arr[0].equals("Enter")){
                    answer[i] = map.get(arr[1])+"님이 들어왔습니다.";
                    list.add(map.get(arr[1])+"님이 들어왔습니다.");
                }else if(arr[0].equals("Leave")){
                    answer[i] = map.get(arr[1])+"님이 나갔습니다.";
                    list.add(map.get(arr[1])+"님이 나갔습니다.");
                }else{
                    continue;}
            }
            return list;
        }
    }
}

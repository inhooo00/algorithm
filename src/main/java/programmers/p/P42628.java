import java.util.*;

class P42628 {
    public List<Integer> solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].substring(0,1).equals("I")){
                map.put(Integer.parseInt(operations[i].substring(2)),map.getOrDefault(Integer.parseInt(operations[i].substring(2)),0)+1);
            }else if(operations[i].equals("D 1")){
                if(!map.isEmpty()){
                    int lastKey = map.lastKey();
                    if(map.get(lastKey) == 1) map.remove(lastKey);
                    else map.put(lastKey, map.get(lastKey)-1);
                }
            }else {
                if(!map.isEmpty()){
                    int firstKey = map.firstKey();
                    if(map.get(firstKey) == 1) map.remove(firstKey);
                    else map.put(firstKey, map.get(firstKey)-1);
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        if(map.isEmpty()){
            answer.add(0);
            answer.add(0);
        }else{
            answer.add(map.lastKey());
            answer.add(map.firstKey());
        }
        return answer;
    }
}
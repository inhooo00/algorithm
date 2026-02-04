package programmers.p;
import java.util.*;
public class P43163 {

    public int solution(String begin, String target, String[] words) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(begin,0));
        boolean[] visited = new boolean[words.length];
        String answer = "";
        for(String word : words){
            if(target.equals(word)){
                answer+=word;
            }
        }
        if(answer.equals("")){
            return 0;
        }

        while(!deque.isEmpty()){
            Node now = deque.remove();

            if(now.word.equals(target)){
                return now.count;
            }

            for(int i=0;i<words.length;i++){
                int wordCount = 0;
                String[] nowWords1 = now.word.split("");
                String[] nowWords2 = words[i].split("");
                for(int j=0;j<nowWords1.length;j++) {
                    if(!nowWords1[j].equals(nowWords2[j])) wordCount++;
                }
                if(wordCount==1 && !visited[i]){
                    visited[i] = true;
                    deque.add(new Node(words[i],now.count+1));
                }
            }

        }
        return 0;
    }

    public static class Node {
        String word;
        int count;
        public Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}

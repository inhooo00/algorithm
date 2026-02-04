package programmers.p;
import java.util.*;

public class P43164 {

    public class Solution {
        public List<String> solution(String[][] tickets) {
            Map<String, PriorityQueue<String>> graph = new HashMap<>();

            for (String[] ticket : tickets) {
                graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
            }

            LinkedList<String> route = new LinkedList<>();
            Deque<String> stack = new ArrayDeque<>();
            stack.push("ICN");

            while (!stack.isEmpty()) {
                String current = stack.peek();

                if (graph.containsKey(current) && !graph.get(current).isEmpty()) {
                    stack.push(graph.get(current).poll());
                } else {
                    route.addFirst(stack.pop());
                }
            }

            return route;
        }
    }
}

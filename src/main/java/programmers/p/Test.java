package programmers.p;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.push(1);
        deque.push(2);
        deque.push(3);

        System.out.println(deque);

        deque.pop();

        System.out.println(deque);
        deque.pop();
        deque.pop();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        System.out.println(deque);
        deque.remove();
        System.out.println(deque);
    }
}

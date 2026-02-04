package swea.ssafy.heap;

public class HeapTest {
    public static void main(String[] args) {
        Heap h = new Heap();
        System.out.println(h.toString());

        h.offer(4);
        h.offer(2);
        h.offer(7);
        h.offer(1);
        System.out.println(h.toString());
        h.poll();
        System.out.println(h.poll());
    }
}

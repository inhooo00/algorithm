package swea.ssafy.linkedList;

import java.util.NoSuchElementException;
import swea.ssafy.linkedList.Node;

public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuffer sb = new StringBuffer("[");
        Node<T> curr = head;
        sb.append(curr.data);
        curr = curr.next;
        while (curr != null) {
            sb.append(", " + curr.data);
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private Node<T> node(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index:" + idx + ", Size:" + size);
        }
        Node<T> curr = null;
        if (idx < size / 2) { // head와 tail이 있으니 앞에서 갈지, 뒤에서 갈지
            curr = head;
            for (int i = 0; i < idx; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = size - 1; i > idx; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    public T get(int idx) {
        return node(idx).data;
    }

    // 새 노드를 제일 뒤에 붙이기
    public void add(T data) {
        if (size == 0) {
            addFirst(data);
            return;
        }

        Node<T> node = new Node<>(data);
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = node.next;
        if (head != null) {
            head.prev = null;
        }
        node.next = null;
        size--;
        return node.data;
    }

    public  T removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = tail;
        tail = node.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // 리스트가 비게 되는 경우
        }
        node.prev = null;
        size--;
        return node.data;
    }

    public T remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index:" + idx + ", Size:" + size);
        }
        if (idx == 0) {
            return removeFirst();
        }
        if(idx == size - 1) {
            return removeLast();
        }

        Node<T> preNode = node(idx - 1);
        Node<T> rm = preNode.next;
        Node<T> nextNode = preNode.next.next;

        nextNode.prev = preNode;
        preNode.next = nextNode;

        size--;
        return rm.data;
    }
}
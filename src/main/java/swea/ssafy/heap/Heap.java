package swea.ssafy.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {
    int[] elements;
    int pos;

    public Heap() {
        // 0번 인덱스는 사용하지 않으므로 11 크기로 생성
        elements = new int[10 + 1];
    }

    public boolean isFull() {
        return pos == elements.length - 1;
    }

    private void inc() {
        // 배열 크기를 2배로 확장
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    public void offer(int data) {
        if (isFull()) {
            inc();
        }
        elements[++pos] = data;

        // Up-Heap (부모와 비교해서 올라가기)
        int idx = pos;
        while (idx > 1 && elements[idx / 2] > elements[idx]) {
            swap(elements, idx / 2, idx);
            idx /= 2;
        }
    }

    public int poll() {
        if (pos == 0) {
            throw new NoSuchElementException();
        }
        int result = elements[1];

        // 마지막 노드를 루트로 가져오고 사이즈 줄임
        elements[1] = elements[pos];
        elements[pos--] = 0; // (선택) 디버깅용 초기화

        heapify();
        return result;
    }

    // [수정됨] Down-Heap 로직 개선
    private void heapify() {
        int idx = 1;

        // 왼쪽 자식이 있는 동안 반복
        while (idx * 2 <= pos) {
            int left = idx * 2;
            int right = idx * 2 + 1;
            int minIdx = left; // 일단 왼쪽이 더 작다고 가정

            // 오른쪽 자식이 있고, 오른쪽이 왼쪽보다 더 작다면? -> 타겟 변경
            if (right <= pos && elements[right] < elements[left]) {
                minIdx = right;
            }

            // 부모(나)가 자식들 중 작은 놈보다 더 작거나 같으면? -> 정렬 끝 (중단)
            if (elements[idx] <= elements[minIdx]) {
                break;
            }

            // 자식이 더 작다면 스왑하고 계속 내려감
            swap(elements, idx, minIdx);
            idx = minIdx;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public String toString() {
        if (pos == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(elements[1]);
        // [수정됨] i < pos -> i <= pos (마지막 원소 포함)
        for (int i = 2; i <= pos; i++) {
            sb.append(", ");
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
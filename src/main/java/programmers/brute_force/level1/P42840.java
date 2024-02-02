package programmers.brute_force.level1;

import java.util.ArrayList;
import java.util.List;

// 모의 고사
//answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]
// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... -> 1, 2, 3, 4, 5
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... -> 2, 1, 2, 3, 2, 4, 2, 5
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... -> 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
public class P42840 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % a.length]) score[0]++;
            if (answers[i] == b[i % b.length]) score[1]++;
            if (answers[i] == c[i % c.length]) score[2]++;
        }
        int max = Math.max(score[0],Math.max(score[1],score[2]));
        List<Integer> list = new ArrayList<>();
        if (max == score[0]) list.add(1);
        if (max == score[1]) list.add(2);
        if (max == score[2]) list.add(3);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;

    }
}

package programmers.greedy.level1;

import java.util.Arrays;

// 체육복
//n	lost	reserve	return
//5	[2, 4]	[1, 3, 5]  	5
//5	[2, 4]	[3]	4
//3	[3]	[1]	2
public class P42862 {
    public static void main(String[] args) {

    }
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        // 기본적으로 모든 학생이 체육복을 가지고 있음을 표시
        Arrays.fill(students, 1);

        for (int l : lost) {
            students[l - 1]--;  // 체육복을 도난당한 학생은 체육복이 없음을 표시
        }

        for (int r : reserve) {
            students[r - 1]++;  // 여벌 체육복을 가진 학생은 체육복을 하나 더 가지고 있음을 표시
        }

        for (int i = 0; i < n; i++) {
            if (students[i] == 0) {  // 체육복이 없는 학생인 경우
                if (i > 0 && students[i - 1] > 1) {  // 앞 번호 학생에게 체육복을 빌림
                    students[i - 1]--;
                    students[i]++;
                } else if (i < n - 1 && students[i + 1] > 1) {  // 뒷 번호 학생에게 체육복을 빌림
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }

        int answer = 0;
        for (int s : students) {
            if (s > 0) {  // 체육복을 가진 학생의 수를 셈
                answer++;
            }
        }

        return answer;
    }

}

package silver_1;

import java.util.Arrays;
import java.util.Scanner;

public class B1309_동물원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;

        int[][] array = new int[N + 1][3];
        Arrays.fill(array[1], 1);

        for (int i = 2; i <= N; i++) { //각 라인마다 비교.
            array[i][0] = (array[i - 1][0] + array[i - 1][1] + array[i - 1][2]) % 9901; //하나도 배치하지 않은 경우
            array[i][1] = (array[i - 1][0] + array[i - 1][2]) % 9901; // 왼쪽에 들어간 경우
            array[i][2] = (array[i - 1][0] + array[i - 1][1]) % 9901; // 오른쪽에 들어간  경우

        }

        for (int i = 0; i < 3; i++) {
            sum += array[N][i];
        }

        System.out.println(sum % 9901);
    }
}

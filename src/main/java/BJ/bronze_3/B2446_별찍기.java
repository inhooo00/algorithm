package BJ.bronze_3;

public class B2446_별찍기 {
    public static void main(String[] args) {
        int n = 5; // 중앙 라인 수

        // 윗부분
        for (int i = n; i > 0; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 아랫부분
        for (int i = 2; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k < (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


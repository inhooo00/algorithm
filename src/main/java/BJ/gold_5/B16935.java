package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B16935 {
    static int[][] init;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int fst = Integer.parseInt(arr[0]);
        int snd = Integer.parseInt(arr[1]);
        int count = Integer.parseInt(arr[2]);
        init = new int[fst][snd];
        for (int i = 0; i < fst; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < row.length; j++) {
                init[i][j] = Integer.parseInt(row[j]);
            }

        }

        String[] countArr = br.readLine().split(" ");
        for (int i = 0; i < countArr.length; i++) {
            if(Integer.parseInt(countArr[i])==1){
                one();
            }else if(Integer.parseInt(countArr[i])==2){
                two();
            }else if(Integer.parseInt(countArr[i])==3) {
                three();
            }else if(Integer.parseInt(countArr[i])==4) {
                four();
            }else if(Integer.parseInt(countArr[i])==5) {
                five();
            }else if(Integer.parseInt(countArr[i])==6) {
                six();
            }
        }
        for (int i = 0; i < init.length; i++) {
            for (int j = 0; j < init[0].length; j++) {
                System.out.print(init[i][j]+" ");
            }
            System.out.println();

        }
    }

    private static void one() {
        int n = init.length;
        for (int i = 0; i < n / 2; i++) {
            int[] temp = init[i];
            init[i] = init[n - 1 - i];
            init[n - 1 - i] = temp;
        }
    }

    private static void two() {
        int n = init.length;
        int m = init[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = init[i][j];
                init[i][j] = init[i][m - 1 - j];
                init[i][m - 1 - j] = temp;
            }
        }
    }

    private static void three() {
        int n = init.length;
        int m = init[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][n-1-i] = init[i][j];
            }

        }
        init = rotated;
    }

    private static void four() {
        int n = init.length;
        int m = init[0].length;
        int[][] rotated = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[m-1-j][i] = init[i][j];
            }
        }
        init = rotated;
    }
    private static void five() {
        int n = init.length;
        int m = init[0].length;
        int[][] rotated = new int[n][m];

        int halfN = n / 2;
        int halfM = m / 2;

        // 1 → 2
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                rotated[i][j + halfM] = init[i][j];
            }
        }

        // 2 → 3
        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < m; j++) {
                rotated[i + halfN][j] = init[i][j];
            }
        }

        // 3 → 4
        for (int i = halfN; i < n; i++) {
            for (int j = halfM; j < m; j++) {
                rotated[i][j - halfM] = init[i][j];
            }
        }

        // 4 → 1
        for (int i = halfN; i < n; i++) {
            for (int j = 0; j < halfM; j++) {
                rotated[i - halfN][j] = init[i][j];
            }
        }

        init = rotated;
    }


    private static void six() {
        int n = init.length;
        int m = init[0].length;
        int[][] rotated = new int[n][m];

        int halfN = n / 2;
        int halfM = m / 2;

        // 1 → 4
        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < halfM; j++) {
                rotated[i + halfN][j] = init[i][j];
            }
        }

        // 4 → 3
        for (int i = halfN; i < n; i++) {
            for (int j = 0; j < halfM; j++) {
                rotated[i][j + halfM] = init[i][j];
            }
        }

        // 3 → 2
        for (int i = halfN; i < n; i++) {
            for (int j = halfM; j < m; j++) {
                rotated[i - halfN][j] = init[i][j];
            }
        }

        // 2 → 1
        for (int i = 0; i < halfN; i++) {
            for (int j = halfM; j < m; j++) {
                rotated[i][j - halfM] = init[i][j];
            }
        }

        init = rotated;
    }

}

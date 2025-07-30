package jobda;

import java.util.*;

class Cal {
    public int[] solution(int[] A, int[] B, String C) {
        int[] answer = new int[2];
        int 분모 = 0;
        int 분자 = 0;
        String[] arr = C.split("");
        List<String> list = new ArrayList<>();
        String 나머지 = "";
        for (String string : arr) {
            if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
                list.add(string);
            } else {
                나머지 += string;
            }
        }
        list.add(나머지);
        for (int i = 0; i < 4; i++) {
            arr[i] = list.get(i);
        }
        System.out.println(arr[0] + arr[1]);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*")) {
                분모 = B[i] * B[i + 1];
                분자 = A[i] * A[i + 1];
            } else if (arr[i].equals("/")) {
                분모 = B[i] * A[i + 1];
                분자 = A[i] * B[i + 1];
            } else if (arr[i].equals("+")) {
                분모 = B[i] * B[i + 1];
                분자 = A[i] * B[i + 1] + A[i + 1] * B[i];
            } else if (arr[i].equals("-")) {
                분모 = B[i] * B[i + 1];
                분자 = A[i] * B[i + 1] - A[i + 1] * B[i];
            } else if (arr[i].equals("=")) {
                double a = A[i] / (double) B[i];
                double b = A[i + 1] / (double) B[i + 1];
                //System.out.println(a + " " + b);
                if (a == b) {
                    분자 = 1;
                    분모 = 1;
                } else if (a > b) {
                    분자 = 1;
                    분모 = 0;
                } else {
                    분자 = 0;
                    분모 = 1;
                }
            } else if (arr[i].equals("<")) {
                double a = A[i] / (double) B[i];
                double b = A[i + 1] / (double) B[i + 1];
                //System.out.println(a + " " + b);
                if (a == b) {
                    분자 = 1;
                    분모 = 1;
                } else if (a < b) {
                    분자 = 1;
                    분모 = 1;
                } else {
                    분자 = 0;
                    분모 = 1;
                }
            } else if (arr[i].equals(">")) {
                double a = A[i] / (double) B[i];
                double b = A[i + 1] / (double) B[i + 1];
                //System.out.println(a + " " + b);
                if (a == b) {
                    분자 = 1;
                    분모 = 1;
                } else if (a > b) {
                    분자 = 1;
                    분모 = 1;
                } else {
                    분자 = 0;
                    분모 = 1;
                }
            }

            A[i + 1] = 분자;
            B[i + 1] = 분모;
            System.out.println(분자 + " " + 분모);
        }
        if (분모 < 0 && 분자 < 0) {
            분모 = 분모 * -1;
            분자 = 분자 * -1;
        }

        //System.out.println(분모+" "+분자);

        int maxNum = Math.max(분모, 분자);
        while (true) {
            boolean check = false;
            for (int i = 2; i <= maxNum; i++) {
                if (분모 % i == 0 && 분자 % i == 0) {
                    분모 /= i;
                    분자 /= i;
                    check = true;
                    break;
                }
            }
            if (!check) {
                break;
            }
        }

        //System.out.println(분모+" "+분자);
        answer[0] = 분자;
        answer[1] = 분모;
        return answer;
    }
}


// 4단계는
// 4개 입력 받고
// 중간에 <>= 연산자가 오고, 양 옆에 +-/%가 오는 구조.

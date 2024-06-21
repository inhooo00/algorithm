package groom;

import java.io.*;

class 꽃선물하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] answer = new String[input];

        for (int i = 0; i < input; i++) {
            String[] numbers = br.readLine().split(" ");
            if (Integer.parseInt(numbers[0]) < Integer.parseInt(numbers[1])) {
                answer[i] = "Sunflower";
            } else if (Integer.parseInt(numbers[0]) > Integer.parseInt(numbers[1])) {
                answer[i] = "Rose";
            } else {
                answer[i] = "Tulip";
            }
        }

        for (String s : answer) {
            System.out.println(s);
        }
    }
}

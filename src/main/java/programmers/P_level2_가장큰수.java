package programmers;
import java.util.Arrays;
import java.util.Comparator;

public class P_level2_가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (strings[0].equals("0")) return "0";

        for (String s : strings) answer.append(s);

        return answer.toString();
    }
}

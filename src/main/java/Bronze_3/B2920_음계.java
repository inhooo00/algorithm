package Bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        List<Integer> awaw = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) list.add(Integer.parseInt(arr[i]));
        for (int i = 0; i < arr.length; i++) awaw.add(Integer.parseInt(arr[i]));

        while (true) {
            Collections.sort(awaw);
            Boolean b = true;
            for (int i = 0; i < awaw.size(); i++) {
                if (list.get(i) != awaw.get(i)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println("ascending");
                break;
            }

            Collections.sort(awaw, Collections.reverseOrder());
            b = true;
            for (int i = 0; i < awaw.size(); i++) {
                if (list.get(i) != awaw.get(i)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                System.out.println("descending");
                break;
            }

            System.out.println("mixed");
            break;
        }


    }
}

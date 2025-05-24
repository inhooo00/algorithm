package programmers.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P84512 {

    class Solution {
        public int solution(String word) {
            List<String> list = new ArrayList<>();
            String[] arr = {"A", "E", "I", "O", "U"};

            for (int i = 0; i < 5; i++) {
                list.add(arr[i]);
                for (int j = 0; j < 5; j++) {
                    list.add(arr[i] + arr[j]);
                    for (int k = 0; k < 5; k++) {
                        list.add(arr[i] + arr[j] + arr[k]);
                        for (int l = 0; l < 5; l++) {
                            list.add(arr[i] + arr[j] + arr[k] + arr[l]);
                            for (int m = 0; m < 5; m++) {
                                list.add(arr[i] + arr[j] + arr[k] + arr[l] + arr[m]);
                            }
                        }
                    }
                }
            }

            Collections.sort(list);

            return list.indexOf(word) + 1;
        }
    }

}

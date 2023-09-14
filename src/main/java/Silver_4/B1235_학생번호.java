package Silver_4;

import javax.imageio.metadata.IIOMetadataNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1235_학생번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine();


        int count = 1;
        for (int i = arr[0].length() - 1; i >= 0; i--) {
            String[] answer = new String[N];
            for (int j = 0; j < arr.length; j++) {
                answer[j] = arr[j].substring(i);
            }
            //System.out.println(answer[1]);
            boolean b = true;
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (answer[j].equals(answer[k])) b = false;
                }
            }

            if (!b) {
                count++;
            } else break;

        }
        System.out.println(count);
    }
}

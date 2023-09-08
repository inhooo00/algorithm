package Silver_4;/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//예제 입력 1
//3 4
//ohhenrie
//charlie
//baesangwook
//obama
//baesangwook
//ohhenrie
//clinton
//예제 출력 1
//2
//baesangwook
//ohhenrie
public class B1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        List<String> list= new ArrayList<>();
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); // 듣도
        int M = Integer.parseInt(arr[1]); // 보도
        String[] arr_N = new String[N];
        String[] arr_M = new String[M];

        for (int i = 0; i < N; i++) arr_N[i] = br.readLine();
        for (int i = 0; i < M; i++) arr_M[i] = br.readLine();

        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(arr_N[i].contains(arr_M[j])) {
                    count++;
                    list.add(arr_N[i]);
                }

            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}*/ //array로 했다가 시간초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class B1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();
            if (set.contains(tmp)) {
                result.add(tmp);
            }
        }

        Collections.sort(result);

        // print result
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}

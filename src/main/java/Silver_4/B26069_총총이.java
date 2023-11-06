package Silver_4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class B26069_총총이 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        HashMap<String, String> H = new HashMap<>();
//        int index = 0;
//        for (int i=0;i<N;i++){
//            String[] input = br.readLine().split(" ");
//            H.put(input[0],input[1]);
//            if (H.get(input[0]).equals("ChongChong")) index = i;
//        }
//        System.out.println(N-index+1);
//
//    }
//}
import java.io.*;
import java.util.*;

public class B26069_총총이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");  //총총이는 무조건 나오므로 추가
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String person1 = st.nextToken();
            String person2 = st.nextToken();
            //춤을 추고 있는 사람을 만나면 춤을 추게 되므로 세트에 추가
            if (set.contains(person1) || set.contains(person2)) {
                set.add(person1);
                set.add(person2);
            }
        }
        System.out.println(set.size());
    }



}

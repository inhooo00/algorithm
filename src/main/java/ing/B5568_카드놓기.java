package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B5568_카드놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(); // 값 받기
        HashMap<Integer,Integer> H = new HashMap<>(); // 값 메핑
        for (int i=0;i<n;i++) list.add(Integer.parseInt(br.readLine()));
        for (int i=0;i<list.size();i++){
            for (int j=i+1;j<k;j++){
                H.put(list.get(i),1);
            }

        }



    }
}

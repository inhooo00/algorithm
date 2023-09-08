package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int first = 666;
        int count = 1;

        while (true) {
            if (count == N) break;
            first++;
            if (String.valueOf(first).contains("666")) count++;
        }
        System.out.println(first);
    }
}


/* 666

 1666
  2666
  3666
  4666
  5666

  6661
  6662
  6663
  6664
  6665
  6666
  6667
  6668
  6669

  7666
  8666
  9666*/
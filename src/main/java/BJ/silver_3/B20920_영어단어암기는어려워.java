package BJ.silver_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B20920_영어단어암기는어려워 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        new B20920_영어단어암기는어려워().solution();
    }

    private void solution() throws Exception {
        List<Word> list = new ArrayList<>();
        Map<String, Word> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while (n-->0) {
            String cur = br.readLine();
            if (cur.length() < m) continue;

            if (map.containsKey(cur)) {
                map.get(cur).count();
                continue;
            }

            Word word = new Word(cur);
            list.add(word);
            map.put(cur, word);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Word word : list) {
            sb.append(word.name).append('\n');
        }
        System.out.print(sb);
    }
}

class Word implements Comparable<Word> {
    String name;
    int cnt;

    public Word(String name) {
        this.name = name;
        cnt = 1;
    }

    public void count() {
        this.cnt++;
    }

    @Override
    public int compareTo(final Word o) {
        if (this.cnt != o.cnt) {
            return o.cnt - this.cnt;
        }

        if (this.name.length() != o.name.length()) {
            return o.name.length() - this.name.length();
        }

        return this.name.compareTo(o.name);
    }
}
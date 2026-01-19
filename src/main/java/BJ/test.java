package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {

        public static void main(String[] args) {
            int N = 1;

            for (int i = 5; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print(N++ + " ");
                }
                System.out.println();
            }
        }
    }
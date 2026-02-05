package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1991_트리순회 {
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[26];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node((char) ('A' + i));
        }
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            if (left != '.') {
                tree[root-'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[root-'A'].right = tree[right - 'A'];
            }
        }

        f(tree[0]);
        System.out.println();
        m(tree[0]);
        System.out.println();
        b(tree[0]);

    }
    private static void f(Node node){
        if (node == null) return;
        System.out.print(node.root);
        f(node.left);
        f(node.right);
    }

    private static void m(Node node){
        if (node == null) return;
        m(node.left);
        System.out.print(node.root);
        m(node.right);
    }

    private static void b(Node node){
        if (node == null) return;
        b(node.left);
        b(node.right);
        System.out.print(node.root);
    }
    static class Node{
        char root;
        Node left, right;
        Node(char root){
            this.root= root;
        }
    }
}

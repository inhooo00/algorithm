package ing;

public class test {
    public static int f(String s, int last) {
        if (last < 0) {
            return 0;
        }
        if (s.charAt(last) == '0') {
            return 2 * f(s, last - 1);
        }
        return 1 + 2 * f(s, last - 1);
    }

    public static void main(String[] args) {
        int n =f("110100111", 4);
        System.out.println(1%2);
    }
}

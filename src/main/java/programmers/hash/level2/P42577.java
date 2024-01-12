package programmers.hash.level2;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.HashSet;

//전화번호 목록
//phone_book	return
//["119", "97674223", "1195524421"]	false
//["123","456","789"]	true
//["12","123","1235","567","88"]	false
// 시작 값으로 비교.
public class P42577 {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};
        solution(arr);
    }
    public static boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);

        for (int i = 0; i < phoneBook.length - 1; i++) {
            if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                return false;
            }
        }

        return true;
    }
}

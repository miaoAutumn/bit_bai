package homeworks;

import java.util.*;

public class exam_1 {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            int n =0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    set.add(chars[i]);

                }else {
                   n++;
                }
            }


        }

    }
}

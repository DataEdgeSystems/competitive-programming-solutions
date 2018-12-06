/**
 *
 * https://www.hackerrank.com/challenges/balanced-brackets/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                boolean flag = false;
                if (!stack.empty()) {
                    char rc = stack.pop();
                    if ((c == ')' && rc == '(') ||
                        (c == ']' && rc == '[') ||
                        (c == '}' && rc == '{')) {
                            flag = true;
                        }
                }
                if (!flag) {
                    result = false;
                    break;
                }
            }
        }

        return result && stack.empty();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s) ? "YES" : "NO";

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
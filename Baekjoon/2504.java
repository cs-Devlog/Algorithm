import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<String> stack = new Stack<>();
        int sum = 0;
        String past;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                    stack.push(Character.toString(ch));
                    break;
                case ')':
                    check(stack.size());
                    past = stack.pop();
                    if (past.equals("(")) {
                        stack.push(String.valueOf(2));
                    } else if (past.equals("[")) {  //예외 처리
                        System.out.println("0");
                        System.exit(0);
                    } else {  //stack에 숫자가 잇다면
                        int add = Integer.parseInt(past);
                        //숫자라면
                        while (check(stack.size()) && !stack.peek().equals("(")) {
                            String check = stack.pop();
                            if (!check.equals("[") && !check.equals("(")) {
                                add += Integer.parseInt(check);
                            }
                        }
                        stack.pop();
                        stack.push(String.valueOf(add * 2));
                    }
                    break;
                case ']':
                    check(stack.size());
                    past = stack.pop();
                    if (past.equals("[")) {
                        stack.push(String.valueOf(3));
                    } else if (past.equals("(")) {
                        System.out.println("0");
                        System.exit(0);
                    } else {  //stack에 숫자가 잇다면
                        int add = Integer.parseInt(past);
                        while (check(stack.size()) && !stack.peek().equals("[")) {
                            String check = stack.pop();
                            if (!check.equals("[") && !check.equals("(")) {
                                add += Integer.parseInt(check);
                            }
                        }
                        stack.pop();
                        stack.push(String.valueOf(add * 3));
                    }
                    break;
            }
        }
        while (!stack.isEmpty()) {
            try {
                sum += Integer.parseInt(stack.pop());
            } catch (Exception e) {
                sum = 0;
                break;
            }
        }
        System.out.println(sum);
    }

    public static boolean check(int size) {
        if (size != 0) return true;
        else {
            System.out.println("0");
            System.exit(0);
            return false;
        }
    }
}
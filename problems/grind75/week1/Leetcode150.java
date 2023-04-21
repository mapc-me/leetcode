package grind75.week1;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.offerFirst(stack.pollFirst() + stack.pollFirst());

            } else if (token.equals("-")) {
                Integer last = stack.pollFirst();
                Integer beforeLast = stack.pollFirst();
                stack.offerFirst(beforeLast - last);

            } else if (token.equals("*")) {
                stack.offerFirst(stack.pollFirst() * stack.pollFirst());

            } else if (token.equals("/")) {
                Integer last = stack.pollFirst();
                Integer beforeLast = stack.pollFirst();
                stack.offerFirst(beforeLast / last);

            } else {
                stack.offerFirst(Integer.valueOf(token));
            }


        }

        return stack.pollFirst();
    }
}

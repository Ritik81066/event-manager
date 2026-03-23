package datastructures;

import java.util.Stack;

public class ActionStack {

    private Stack<String> stack = new Stack<>();

    public void pushAction(String action) {
        stack.push(action);
    }

    public String popAction() {

        if (stack.isEmpty()) return null;

        return stack.pop();
    }

    public String peekAction() {

        if (stack.isEmpty()) return null;

        return stack.peek();
    }
}
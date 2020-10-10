package com.xu.ReverseExpress;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    private String reverse(String express) {
        char[] expressArray = express.toCharArray();
        Stack<Character> operationStack = new Stack<>();
        ArrayList<Character> res = new ArrayList<>();
        for (char c : expressArray) {
            if (Operation.parseChar(c) == null) {
                res.add(c);
            } else {
                insertOperation(c, operationStack, res);
            }

        }
        return res.toString();
    }

    private void insertOperation(char c, Stack<Character> operationStack, ArrayList<Character> res) {
        if (new Character('=').equals(c)) {
            while (!operationStack.empty()) {
                res.add(operationStack.pop());
            }
            return;
        }
        //当前遇到的操作符比栈内的优先级低，则将之前的操作符 出栈，再入栈
        if (!operationStack.empty() && Operation.parseChar(c).getPriority() <= Operation.parseChar(operationStack.peek()).getPriority()) {
            while (!operationStack.empty()) {
                res.add(operationStack.pop());
            }
        }
        operationStack.push(c);
        return;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String express = "1+2*3-4=";
        String reverseExpress = solution.reverse(express);
        System.out.println(reverseExpress);

    }
}

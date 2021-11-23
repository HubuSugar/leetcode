package edu.hubu.hubuSugar.week03;

import java.util.Stack;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-23
 * @Description: 有效的括号
 **/
public class IsValid {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        int len = s.length();
        //用于存放左括号的栈结构
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < len;i++){
            char cur = s.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            }else if(cur == ')'){
                //当遇到右括号时出栈一个元素
                if(stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if(pop != '('){
                    return false;
                }
            }else if(cur == '}'){
                //当遇到右括号时出栈一个元素
                if(stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if(pop != '{'){
                    return false;
                }
            }else{
                //当遇到右括号时出栈一个元素
                if(stack.isEmpty()){
                    return false;
                }
                char pop = stack.pop();
                if(pop != '['){
                    return false;
                }
            }
        }
        //最终当字符串遍历结束，判断栈中的元素（即左括号是否全部出栈完毕）
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()[]{}"));
    }

}

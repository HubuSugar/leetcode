package edu.hubu.hubuSugar.week03;

import java.util.*;

/**
 * @Author: huxiaoge
 * @Date: 2021-11-20
 * @Description: 电话号码的字母组合
 **/
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> nums = new ArrayList<>();
        if(digits.length() == 0) return nums;
        String firstLetters = map.get(digits.charAt(0));
        Queue<String> queue = new LinkedList<>();
        for(int i = 0;i < firstLetters.length();i++){
            queue.add(String.valueOf(firstLetters.charAt(i)));
        }
        //从第二位数字开始，遍历到数字的结尾
        for (int i = 1; i < digits.length() ; i++) {
            //取到当前数字对应的字符串
            String s = map.get(digits.charAt(i));
            int size = queue.size();
            while(size != 0){
                String poll = queue.poll();
                for(int j = 0;j < s.length();j++){
                    queue.add(poll + s.charAt(j));
                }
                size--;
            }
        }
        return new ArrayList<>(queue);
    }

    /**
     * 回溯法，不便于理解
     * @param digits
     * @return
     */
    public List<String> letterCombinations1(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("234"));
    }
}

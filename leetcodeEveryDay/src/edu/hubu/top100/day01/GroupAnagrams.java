package edu.hubu.top100.day01;

import java.util.*;

/**
 * @author: sugar
 * @date: 2022/3/7
 * @description: 字母异位词分组
 */
public class GroupAnagrams {


    /**
     * 此题不能按照全排列的思路做，因为字母组合中存在重复字母
     *
     * @param chars
     * @return
     */
    public List<String> permute(char[] chars) {
        List<String> result = new LinkedList<>();
        int len = chars.length;
        //表示字符数组中的每一个元素是否使用过
        boolean[] used = new boolean[len];
        dfs(chars, len, new ArrayList<>(), result, 0, used);
        return result;
    }

    public void dfs(char[] chars, int len, List<Character> path, List<String> result, int depth, boolean[] used) {
        if (path.size() == len) {
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(chars[i]);
                used[i] = true;
                dfs(chars, len, path, result, depth + 1, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        if (len == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        //用来判断当前下标的元素是否匹配过
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!flag[i]) {
                flag[i] = true;
                List<String> group = new ArrayList<>();
                String str = strs[i];
                group.add(str);
                List<String> permutes = permute(str.toCharArray());
                for (int j = i + 1; j < len; j++) {
                    if (!flag[j] && permutes.contains(strs[j])) {
                        flag[j] = true;
                        group.add(strs[j]);
                    }
                }
                result.add(group);
            }
        }
        return result;
    }

    /**
     * 使用散列表的方法
     * 对于每个字符串对于其中的字母按照从小到大的顺序排序后，他们的排序应该一样
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            if (map.containsKey(newStr)) {
                map.get(newStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newStr, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = new GroupAnagrams().groupAnagrams1(strs);
        System.out.println(anagrams);
    }
}

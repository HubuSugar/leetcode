package edu.hubu.hubuSugar.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sugar
 * @date: 2021/12/19
 * @descript: 找到小镇上的法官-997-easy
 */
public class FindJudge {

    public int findJudge(int n,int[][] trust){
        if(trust == null) return -1;
        if(trust.length == 0 && n == 1) return 1;
        int index = -1;
        //记录一个人是否存在信任的人
        boolean[] hasTrusted = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] temp : trust) {
            //信任者
            int trusting = temp[0];
            //被信任者
            int trusted = temp[1];
            hasTrusted[trusting - 1] = true;
            //trust array
            if (map.containsKey(trusted)) {
                map.get(trusted).add(trusting);
            } else {
                List<Integer> first = new ArrayList<>();
                first.add(trusting);
                map.put(trusted, first);
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry: map.entrySet()){
            if(containOthersWithoutSelf(n,entry.getKey(),entry.getValue()) && !hasTrusted[entry.getKey() - 1]){
                index = entry.getKey();
                break;
            }
        }
        return index;
    }

    /**
     * 方法二：有向图的出度和入度问题
     */
    public int findJudge1(int n,int[][] trust){
        if(trust == null){
            return  -1;
        }
        int[] outDegrees = new int[n + 1];
        int[] inDegrees = new int[n + 1];
        for (int[] ints : trust) {
            int x = ints[0];
            int y = ints[1];
            ++inDegrees[y];
            ++outDegrees[x];
        }
        for(int i = 1;i < n + 1;i++){
            if(inDegrees[i] == n - 1 && outDegrees[i] == 0){
                return i;
            }
        }
        return -1;
    }


    /**
     * 判断一个集合是否只包含其他人不包含自己
     * @param self
     * @param others
     * @return
     */
    private boolean containOthersWithoutSelf(int n,int self,List<Integer> others){
        if(others.contains(self)) return false;
        for(int i = 1;i <= n;i++){
          if(i == self){
              continue;
          }
          if(!others.contains(i)){
              return false;
          }
        }
        return true;
    }

    public static void main(String[] args) {
        FindJudge judge = new FindJudge();
        int[][] trust = new int[][]{{1,2}};
        System.out.println(judge.findJudge1(2, trust));

        int[][] trust1 = {{1,3},{2,3}};
        System.out.println(judge.findJudge1(3, trust1));

        int[][] trust2 = {{1,3},{2,3},{3,1}};
        System.out.println(judge.findJudge1(3, trust2));
    }

}

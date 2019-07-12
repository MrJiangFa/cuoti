package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PrintPermutation {
    //以递归法实现排列组合
    public static void main(String[] args) {
//        print(new char[]{'a', 'b', 'c', 'd'}, 0);
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = new char[]{'a', 'b', 'c', 'd'};
        print2(chars, 0, "");
    }

    public static void print(char[] chars, int m) {
        if (m >= 0) {
            if (m == chars.length - 1) {
                System.out.println(Arrays.toString(chars));
            }
            for (int i = m; i < chars.length; i++) {
                swap(chars, i, m);
                print(chars, m + 1);
                swap(chars, i, m);
            }
        }
    }

    /**
     * 基本概念：
     * @param chars
     * @param i
     * @param res
     */
    public static void print2(char[] chars, int i, String res) {
        if (i == chars.length) {
            System.out.println(res);
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (res.indexOf(chars[j]) < 0) {
                print2(chars, i + 1, res + chars[j]);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        process(nums,0,list,new ArrayList<>());
        return list;
    }
    public void process(int[] nums,int i,List<List<Integer>> list,List<Integer> tmpList){
        if(i==nums.length){
            list.add(tmpList);
            return;
        }
        for(int j = 0;j<nums.length;j++){
            if(!tmpList.contains(nums[j])){
                List<Integer> tmp = new ArrayList<>(tmpList);
                tmp.add(nums[j]);
                process(nums,i+1,list,tmp);
            }
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

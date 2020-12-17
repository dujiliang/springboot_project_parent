package com.yunbao.algorithm.reverse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: djl
 * @Date: 2020/6/17 11:53
 * @Version 1.0
 */
public class PrintReverse {

    public static char[] reversePrint (String param) {
        if (param == null || param.length() == 0) {
            return null;
        }
        char[] chars = param.toCharArray();
        int len = chars.length;
        for (int i = 0,j = len - 1; i < len/2 ; i++,j--) {
            char temp;
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return chars;
    }


    public static void reversePrint (char[] chars) {
        reversePrintHelper(0,chars);
        System.out.println(new String(chars));
    }

    public static void reversePrintHelper (int index ,char[] chars) {
        if (index >= chars.length/2) {
            return ;
        }
        char temp ;
        temp = chars[index];
        chars[index] = chars[chars.length - 1 - index];
        chars[chars.length - 1 - index] = temp;
        reversePrintHelper(index + 1,chars);
    }


    public static void twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {//这里假如是排序的数组
            int complement = target - nums[i];
            //这里可能来回找了两遍，怎么优化呢？？
            if (map.containsKey(complement) && map.get(complement) != i) {
                System.out.println("i:"+i+",j:"+map.get(complement));
            }
        }
    }




    public static void main(String[] args) {
        //System.out.println(PrintReverse.reversePrint("abcdef"));
        //PrintReverse.reversePrint("abcdef".toCharArray());
        int [] array = new int[]{1,2,2,3,2,4};
        PrintReverse.twoSum2(array,4);
    }
}

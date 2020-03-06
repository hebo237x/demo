package com.hebo.java.code;

import com.alibaba.fastjson.JSON;

/**
 * @author bo.he@ttpai.cn
 */
public class Q1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(JSON.toJSONString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }

    public void insertSort(int[] a) {
        for (int right = 1; right < a.length; right++) {
            if (a[right] < a[right - 1]) {
                int tmp = a[right]; // 保存临时变量
                int left = right - 1;
                a[right] = a[right - 1]; // 先后移一个位置
                for (; left >= 0 && tmp < a[left]; left--) {
                    a[left + 1] = a[left];
                }
                a[left + 1] = tmp;// 插入到正确位置
            }
        }
    }
}

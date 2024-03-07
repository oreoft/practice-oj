package series;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 数组的题目
 *
 * @author zyf
 * @date 2021-11-16 19:11
 */
public class ArraySeries {


    @Test
    public void intersectionTwoArrayTest() {
        int[] input = {1, 2, 2, 2, 4};
        System.out.println(Arrays.toString(Arrays.stream(input).limit(removeDuplicates(input)).toArray()));
    }

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * https://leetcode-cn.com/problems/permutations/
     *
     * @param nums 数组
     * @return 返回全排列
     */
    // TODO-Z-2021/11/16: 这个最好用回溯去做, 下次研究下
    public List<List<Integer>> permute(int[] nums) {
        // 拆箱把nums变成list, 然后new一个set去重容器
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Set<List<Integer>> set = new HashSet<>();

        // 拿到阶乘的全排列总数
        int sum = 1;
        for (int i = 1; i <= list.size(); i++) {
            sum = sum * i;
        }

        // 只要set里面的数量不等于最终全排列的总数,就死循环shuffle
        while (set.size() < sum) {
            LinkedList<Integer> temp = new LinkedList<>(list);
            Collections.shuffle(temp);
            set.add(temp);
        }

        // 最后开开心心输出
        return new ArrayList<>(set);
    }


    /**
     * 合并两个有序数组为一个新的有序数组
     * [1, 2, 3] [5, 6, 7] -> [1, 2, 3, 5, 6, 7]
     *
     * @param a a数组
     * @param b b数组
     * @return 返回一个新数组
     */
    public int[] mergeTwoSortedArraysTest(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int ap = 0, bp = 0, cp = 0;
        while (ap < a.length && bp < b.length) {
            if (a[ap] >= b[bp]) {
                c[cp++] = b[bp++];
            } else {
                c[cp++] = a[ap++];
            }
        }
        while (ap < a.length) {
            c[cp++] = a[ap++];
        }
        while (bp < b.length) {
            c[cp++] = b[bp++];
        }
        return c;
    }

    /**
     * 两个有序数组进行求交集, 交集以后也需要有序
     * e.g. arr1[1, 2, 3, 4, 5] arr2[2, 4, 6] => [2, 4]
     */
    public List<Integer> intersectionTwoArray(int[] a, int[] b) {
        int ap = 0, bp = 0;
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (ap < a.length && bp < b.length) {
            if (a[ap] == b[bp] && !set.contains(b[bp])) {
                result.add(a[ap]);
                set.add(a[ap]);
                ap++;
                bp++;
            }
            if (a[ap] > b[bp]) {
                bp++;
            } else {
                ap++;
            }
        }
        return result;
    }


    public static void sdfa(Integer count) {
        count = count + 1;

    }

    public static void main(String[] args) {
        Integer integer = 0;
        sdfa(integer);
        sdfa(integer);
        sdfa(integer);
        sdfa(integer);
        System.out.println(integer);
    }

    /**
     * 删除有序数组的重复项
     */
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                cur++;
                nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public static boolean judgePalindrome_1(int num) {
        if (num < 0) {
            return false;
        }
        String numStr = String.valueOf(num);
        StringBuilder builder = new StringBuilder();
        for (int i = numStr.length() - 1; i >= 0; i--) {
            builder.append(numStr.charAt(i));
        }
        return numStr.equals(builder.toString());
    }

    public static boolean judgePalindrome_2(int num) {
        if (num < 0) {
            return false;
        }
        return new StringBuilder(num + "").reverse().toString().equals(num + "");
    }

    public static boolean judgePalindrome_3(int num) {
        if (num < 0) {
            return false;
        }
        String numStr = num + "";
        int head = 0;
        int tail = numStr.length() - 1;
        while (head < tail) {
            if (numStr.charAt(head) != numStr.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }

    public static boolean judgePalindrome_4(int num) {
        if (num < 0) {
            return false;
        }
        int div = 1;
        while (num / div > 10) {
            div *= 10;
        }

        while (num > 0) {
            int left = 123;
        }


        return true;

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0 || nums1.length == 0) {
            return;
        }
        if (m == 0) {
            nums1 = nums2;
            return;
        }
        int[] moreArr = nums1.length >= nums2.length ? nums1 : nums2;
        int[] lessArr = nums1.length < nums2.length ? nums1 : nums2;
        int[] temp = new int[nums1.length];
        int index = 0;
        int moreIndex = 0;
        int lessIndex = 0;
        while (index < moreArr.length) {
            if (lessArr[lessIndex] <= moreArr[moreIndex]) {
                temp[index] = lessArr[lessIndex];
                lessIndex++;
            } else {
                temp[index] = moreArr[moreIndex];
                moreIndex++;
            }
            index++;
        }
        for (int i : temp) {
            System.out.println(i);
        }
    }

    @Test
    public void judgePalindromeTest() {
        int[] ints = {1, 2, 3, 0, 0};
        merge(ints, 3, new int[]{2, 5, 6}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}

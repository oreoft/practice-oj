package test;

import static unit.InputTools.initListNode;

import org.junit.jupiter.api.Test;
import series.LinkedSeries;
import unit.ListNode;

/**
 *  方便测试的入口方法
 * @author oreft
 */
public class LinkedTest {

    /**
     * 初始化样例
     */
    public static ListNode l1 = initListNode("[4, 8, 9, 11]");
    public static ListNode l2 = initListNode("[-9, 5, 6, 7]");


    @Test
    public void linked() {
        System.out.println(LinkedSeries.mergeTwoListsRecursion(l1, l2));
    }


}

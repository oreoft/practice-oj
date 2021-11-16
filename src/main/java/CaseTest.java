import static unit.InputTools.initListNode;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import series.LinkedSeries;
import series.SortSeries;
import unit.ListNode;

/**
 *  方便测试的入口方法
 * @author oreft
 */
public class CaseTest {

    /**
     * 初始化样例
     */
    public static ListNode l1 = initListNode("[4, 8, 9, 11]");
    public static ListNode l2 = initListNode("[-9, 5, 6, 7]");
    public static int[] nums = {2, 5, -8, 6, 5, 9, 1};


    @Test
    public void linked() {
        System.out.println(LinkedSeries.mergeTwoListsRecursion(l1, l2));
    }

    @Test
    public void sorted() {
        System.out.println(Arrays.toString(SortSeries.quickSort(nums)));
    }



}

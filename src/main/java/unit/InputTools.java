package unit;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import java.util.List;

/**
 * 把测试案例字符串变成测试案例类
 *
 * @author zyf
 * @date 2021-11-15 17:11
 */
public class InputTools {

  public static ListNode initListNode(String input) {
    List<Integer> list = JSON.parseArray(input, Integer.class);
    if (CollectionUtil.isEmpty(list)) {
      return new ListNode();
    }
    // 头结点
    ListNode head = ListNode.builder().value(list.get(0)).build();
    // 头指针
    ListNode p = head;

    /*
      0号元素已经生成过了, 这里直接从1号元素开始
      这里用while的原因就是如果list只有一个元素, 这个就不会执行
     */
    int i = 1;
    while (i < list.size()) {
      // 指针当前指向的元素next给到新生成的结点
      p.next = ListNode.builder().value(list.get(i)).build();
      // 指针下移
      p = p.next;
      // 元素下移
      i++;
    }
    return head;
  }

}

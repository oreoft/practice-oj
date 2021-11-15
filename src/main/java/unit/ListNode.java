package unit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单链表的node结点
 * 为了方便, fields都是public访权限
 *
 * @author oreoft
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    public int value;
    public ListNode next;
}

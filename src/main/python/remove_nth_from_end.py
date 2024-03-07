class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next:ListNode = next


def remove_nth_from_end(head, n) -> ListNode:
    dummy_p = ListNode(next=head)
    fast = dummy_p
    slow = dummy_p
    for _ in range(n+1):
        fast = fast.next
    while fast:
        slow = slow.next
        fast = fast.next
    slow.next = slow.next.next
    return dummy_p.next

if __name__ == '__main__':
    p4 = ListNode(next=None, val=1)
    p3 = ListNode(next=p4, val=2)
    p2 = ListNode(next=p3, val=34)
    p1 = ListNode(next=p2, val=6)
    p0 = ListNode(next=p1, val=8)
    result = remove_nth_from_end(p0, 2)
    while result is not None:
        print(result.val)
        result = result.next


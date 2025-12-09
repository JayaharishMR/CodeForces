import java.util.List;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode last = new ListNode(head.val);
        ListNode node = head;
        while (node.next != null) {
            ListNode nextNode = node.next;
            ListNode newNode = new ListNode(nextNode.val);
            newNode.next = last;
            last = newNode;
            node = nextNode;
        }
        return last;
    }

    public ListNode optimizedReverseList(ListNode head) {
        ListNode p0 = null;
        ListNode p1 = head;

        while (p1 != null) {
            ListNode p2 = p1.next;
            p1.next = p0;
            p0 = p1;
            p1 = p2;
        }
        return  p0;
    }
}

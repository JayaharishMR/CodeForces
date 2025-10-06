public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        RemoveNthNode removeNthNode = new RemoveNthNode();
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);
        listNode.next.next.next.next.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode removeNthFromEnd = removeNthNode.removeNthFromEnd(listNode, 3);
        while (removeNthFromEnd != null) {
            System.out.println(removeNthFromEnd.val);
            removeNthFromEnd = removeNthFromEnd.next;
        }
    }
}

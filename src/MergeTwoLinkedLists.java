public class MergeTwoLinkedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        while (list1 != null || list2 != null) {
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                listNode.next = list1;
                list1 = list1.next;
            } else {
                listNode.next = list2;
                list2 = list2.next;
            }
            listNode = listNode.next;
        }
        return  head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        mergeTwoLists(list1, list2);
    }
}

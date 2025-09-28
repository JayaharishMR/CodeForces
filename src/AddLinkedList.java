public class AddLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return helper(l1, l2, 0);
    }
    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }
        int temp = carry;
        if (l1 != null) {
            temp += l1.val;
        }
        if (l2 != null) {
            temp += l2.val;
        }
        ListNode node = new ListNode(temp % 10);
        node.next = helper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, temp / 10);
        return node;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddLinkedList addLinkedList = new AddLinkedList();
        addLinkedList.addTwoNumbers(l1, l2);
    }
}
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        var pq = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        var node = new ListNode(0);
        var head = node;
        for (var list_head: lists) {
            if (list_head == null) {
                continue;
            }
            pq.add(list_head);
        }

        while (!pq.isEmpty()) {
            node.next = pq.poll();
            node = node.next;

            if (node.next != null) {
                pq.add(node.next);
            }

        }
        return head.next;
    }
    public ListNode mergeKListsRecursively(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        var mid = lists.length / 2;
        var left = mergeKListsRecursively(Arrays.copyOfRange(lists, 0, mid));
        var right = mergeKListsRecursively(Arrays.copyOfRange(lists, mid, lists.length));
        return MergeTwoLinkedLists.mergeTwoLists(left, right);
    }
    public static void main(String[] args) {
        MergeKLinkedLists mergeKLinkedLists = new MergeKLinkedLists();
        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        ListNode emptyList = new ListNode();
        ListNode listNode = mergeKLinkedLists.mergeKListsRecursively(new ListNode[] {listNode1, emptyList});
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

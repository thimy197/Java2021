
import java.util.List;

public class MergeTwoListNode {
    public static void main(String[] args) {
        MergeTwoListNode mergeTwoListNode = new MergeTwoListNode();
        ListNode list1 = new ListNode(List.of(5));
        ListNode list2 = new ListNode(List.of(1,2,4));

        // Act
        ListNode result = mergeTwoListNode.mergeTwoLists(list1, list2);
        System.out.println("Test...............");
        ListNode current = result;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode current = new ListNode();
        ListNode result = current;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                current.val = list2.val;
                list2 = list2.next;
            }
            current.next = new ListNode();
            current = current.next;
        }
        if (list1 != null) {
            current.val = list1.val;
            current.next = list1.next;
        }
        if (list2 != null) {
            current.val = list2.val;
            current.next = list2.next;
        }
        return result;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.val = list.get(0);
        ListNode current = this;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
    }
}

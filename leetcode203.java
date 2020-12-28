package leetcode203;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode head = new Solution().removeElements3(l1, 6);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode front = new ListNode(0, head);
        ListNode previous = front;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
                current.next = null;
                current = previous.next;
                continue;
            }
            current = current.next;
            previous = previous.next;
        }
        return front.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements3(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

package leetcodeTop100;

import java.math.BigDecimal;

/**
 * @author: keke
 * @date: 2021/6/25 21:29
 */
public class 两数相加2 {
    public class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ListNode t1 = l1;
        ListNode t2 = l2;
        while (t1 != null) {
            sb1.append(t1.val);
            t1 = t1.next;
        }
        while (t2 != null) {
            sb2.append(t2.val);
            t2 = t2.next;
        }
        BigDecimal bigDecimalRes = new BigDecimal(sb1.reverse().toString()).add(new BigDecimal(sb2.reverse().toString()));
        String res = bigDecimalRes.toString();
        ListNode root = null;
        ListNode tmp = null;
        for (int i = res.length(); i > 0; i--) {
            if (root == null) {
                root = new ListNode(Integer.parseInt(res.substring(i - 1, i)));
                tmp = root;
            } else {
                ListNode newNode = new ListNode(Integer.parseInt(res.substring(i - 1, i)));
                tmp.next = newNode;
                tmp = newNode;
            }
        }
        return root;
    }
}

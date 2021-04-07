package com.song.wheel;

/**
 * @author songjun
 * @date 2021-04-07
 * @desc leetcode两数相加 https://leetcode-cn.com/problems/add-two-numbers/
 */
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

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String str1 = "";
        while (l1.next != null) {
            str1 = (l1.val + str1);
            l1 = l1.next;
        }
        str1 = (l1.val + str1);

        String str2 = "";
        while (l2.next != null) {
            str2 = (l2.val + str2);
            l2 = l2.next;
        }
        str2 = (l2.val + str2);
        String value = add(str1,str2);
        char[] chars = String.valueOf(value).toCharArray();

        ListNode result = new ListNode();
        ListNode cur = result;

        int val;
        for (int i = chars.length - 1; i >= 0; i--) {

            val = Integer.valueOf(String.valueOf(chars[i]));

            cur.val = val;
            if (i != 0) {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }

        return result;

    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1,new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("listNode = " + listNode);
    }

    public static String add(String digit1, String digit2) {
        String result = "";
        char[] s1 = digit1.toCharArray();
        char[] s2 = digit2.toCharArray();
        char[] jg = new char[Math.max(s1.length, s2.length) + 1];// 结果数组比最常参数再长一位
        int carry = 0;// 表示进位
        for (int i = 0; i < jg.length; i++) {
            char a1 = '0';
            char a2 = '0';
            if (s1.length - 1 - i >= 0) {
                a1 = s1[s1.length - 1 - i];
            }
            if (s2.length - 1 - i >= 0) {
                a2 = s2[s2.length - 1 - i];
            }
            if (a1 < '0' || a1 > '9' || a2 < '0' || a2 > '9') {
                throw new RuntimeException("Parameters can only contain Numbers.");
            }
            char a = (char) (a1 + a2 - '0' + carry);
            if (a > '9') {
                carry = 1;
                a = (char) (a - 10);
            } else {
                carry = 0;
            }
            jg[jg.length - 1 - i] = a;
        }
        for (int i = 0; i < jg.length; i++) {
            if (i == 0 && jg[i] == '0') {
            } else {
                result += jg[i];
            }
        }
        return result;

    }
}

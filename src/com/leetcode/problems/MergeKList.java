package com.leetcode.problems;

import java.util.PriorityQueue;

/**
 * Created by weifengc on 8/9/16.
 */
public class MergeKList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class Combo {
        private int len;
        private ListNode head;

        public Combo(int len, ListNode head) {
            this.len = len;
            this.head = head;
        }

        public int getLen() {
            return this.len;
        }

        public ListNode getHead() {
            return this.head;
        }
    }


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            return method2(lists);
        }

        //idea 1
        //just like merge two sorted list
        //find the smallest and add to the next
        //put the array to a list for easy to remove


        //idea 2,
        //make this to be merge two list at one time
        //always merge the two shortest list
        //use a list of map, map key is the lenght of the value list, the value is the head of the node


        //in method2, loop through the intput array, find out the length and create a map
        //map key is the length, value is the head
        //put this map to a PriorityQueue, this is a min queue

        //poll the top two of the PriorityQueue, do a merge
        //put the merge result to the PriorityQueue
        //stop when the queue has only one element and return the head


        private ListNode method2(ListNode[] arr) {
            if (arr == null || arr.length == 0) {
                return null;
            }

            PriorityQueue<Combo> pq = new PriorityQueue(arr.length, (m1, m2) -> ((Combo) m1).getLen() - ((Combo) m2).getLen() );
            for (ListNode head : arr) {
                int len = len(head);
                pq.add(new Combo(len, head));
            }

            while (pq.size() > 1) {
                //get top two and merge
                Combo c1 = pq.poll();
                Combo c2 = pq.poll();
                ListNode node = merge(c1.getHead(), c2.getHead());
                pq.add(new Combo(c1.getLen() + c2.getLen(), node));
            }
            return pq.poll().getHead();
        }


        //return the len of the list
        private int len(ListNode head) {
            ListNode node = head;
            int len = 0;

            while (node != null) {
                node = node.next;
                len++;
            }
            return len;
        }

        //merge two list
        private ListNode merge(ListNode h1, ListNode h2) {
            ListNode dummy = new ListNode(1);
            ListNode node = dummy;
            while (true) {
                if (h1 == null) {
                    node.next = h2;
                    break;
                }
                if (h2 == null) {
                    node.next = h1;
                    break;
                }

                if (h1.val < h2.val) {
                    node.next = h1;
                    h1 = h1.next;
                } else {
                    node.next = h2;
                    h2 = h2.next;
                }
                node = node.next;
            }

            return dummy.next;
        }


    }

}

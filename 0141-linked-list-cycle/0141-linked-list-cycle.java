/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
if (head == null || head.next == null) return false;

        ListNode rabit = head;
        ListNode turtle = head;

        while (rabit != null && rabit.next != null) {
            rabit = rabit.next.next;  // rabit은 두 칸씩 이동
            turtle = turtle.next;     // turtle은 한 칸씩 이동
            
            if (rabit == turtle) {    // 두 포인터가 만나면 사이클이 있음
                return true;
            }
        }

        return false;  // rabit이 끝에 도달하면 사이클이 없음

        
    }
}
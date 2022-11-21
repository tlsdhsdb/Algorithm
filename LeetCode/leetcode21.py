# Definition for singly-linked list.

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """

        head = ListNode(-1)
        cursor = head

        while l1 != None and l2 != None:
            # l1 or l2 의 next로 계속 이동하기 때문에 마지막 노드에 다다른 것 = 현재 노드가 None일 경우이기 때문에 while조건을 이렇게 걸어주었다.
            if l1.val < l2.val:
                cursor.next = l1
                l1 = l1.next
            else:
                cursor.next = l2
                l2 = l2.next
            # 비교하여 작은 값을 가진 링크드 리스트일 경우 먼저 cursor가 가리키도록 했다. 
            # 이미 비교가 끝나 cursor가 가리켰다면 다시는 그 값을 가리킬 필요 없게 다음값을 가리키도록 한다. (링크드리스트의 순회를 생각하면 된다)

            cursor = cursor.next

        if l1 == None:
            cursor.next = l2
        else:
            cursor.next = l1

        return head.next
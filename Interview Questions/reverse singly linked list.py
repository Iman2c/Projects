# create a program that reverses the the contents of a singly linked list
# Definition for singly-linked list.
# class ListNode(object):
#   def __init__(self, val=0, next=None):
#        self.val = val
#        self.next = next


class Solution(object):
    def reverselist(self, head):
        prev = None
        current = head

        while current:
            # we need to save the pointer to next node
            nextnode = current.next
            # shift the pointer to the other way
            current.next = prev
            # update the pointers (shift them to the right)
            prev = current
            current = nextnode
        return prev


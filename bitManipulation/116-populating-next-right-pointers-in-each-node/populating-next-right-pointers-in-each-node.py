"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
       
        if not root:
            return None
        
        queue = deque([root])
     
        
        while queue:
            n = len(queue)
            level = []
            for _ in range(n):
                current = queue.popleft()
                level.append(current)
                if current.left:
                    queue.append(current.left)
                if current.right:
                    queue.append(current.right)
            if len(level) <= 1:
                continue
            for i in range(len(level) - 1):
                current = level[i]
                current.next = level[i + 1]

            
        
        return root
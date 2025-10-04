class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        queue = deque()
        edges = [0] * numCourses
        nextNodes = [[] for _ in range(numCourses)]
        for dest,src in prerequisites:
            edges[dest] += 1
            nextNodes[src].append(dest)
        for node in range(len(edges)):
            if edges[node] == 0:
                queue.append(node)
        while queue:
            node = queue.popleft()
            for _next in nextNodes[node]:
                edges[_next] -= 1
                if edges[_next] == 0:
                    queue.append(_next)
            
        for edge in edges:
            if edge != 0:
                return False

        return True
        

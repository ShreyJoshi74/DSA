class Solution:
    direction = [[0,1],[0,-1],[1,0],[-1,0]]
    def dfs(self,i,j,grid):
        grid[i][j] = "0"
        for r,c in self.direction:
            ni = i + r
            nj = j + c
            if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]) and grid[ni][nj] == "1":
                self.dfs(ni,nj,grid) 

    def numIslands(self, grid: List[List[str]]) -> int:
        cnt  = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                print(f'{i} , {j}')
                
                if(grid[i][j] == "1"):
                    cnt += 1
                    self.dfs(i,j,grid)

        return cnt
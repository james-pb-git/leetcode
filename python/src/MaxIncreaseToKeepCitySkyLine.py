class MaxIncreaseToKeepCitySkyLine:
    def maxIncreaseKeepingSkyline(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) == 0:
            return 0
        height = len(grid)
        width = len(grid[0])
        max_row = [0] * height
        max_col = [0] * width
        for idx1 in range(height):
            for idx2 in range(width):
                max_row[idx1] = max(max_row[idx1], grid[idx1][idx2])
                max_col[idx2] = max(max_col[idx2], grid[idx1][idx2])
        res = 0
        for idx1 in range(height):
            for idx2 in range(width):
                res += min(max_row[idx1], max_col[idx2]) - grid[idx1][idx2]
        return res
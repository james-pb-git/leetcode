class IslandPerimeter(object):
    def islandPerimeter(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) == 0:
            return 0
        height = len(grid)
        width = len(grid[0])
        perimeter = 0
        for row_idx in range(height):
            for col_idx in range(width):
                if grid[row_idx][col_idx] == 1:
                    if row_idx == 0 or grid[row_idx - 1][col_idx] == 0:
                        perimeter += 1
                    if row_idx == height - 1 or grid[row_idx + 1][col_idx] == 0:
                        perimeter += 1
                    if col_idx == 0 or grid[row_idx][col_idx - 1] == 0:
                        perimeter += 1
                    if col_idx == width - 1 or grid[row_idx][col_idx + 1] == 0:
                        perimeter += 1
        return perimeter
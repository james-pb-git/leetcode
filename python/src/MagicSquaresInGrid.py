class MagicSquaresInGrid(object):

    def _is_magic(self, grid):
        val_set = set(grid[0]) | set(grid[1]) | set(grid[2])
        if val_set != set(range(1,10)):
            return False
        tmp_sum = sum(grid[0])
        if sum(grid[1]) != tmp_sum or sum(grid[2]) != tmp_sum:
            return False
        diag1 = 0
        diag2 = 0
        for idx in range(3):
            if grid[idx][0] + grid[idx][1] + grid[idx][2] != tmp_sum:
                return False
            diag1 += grid[idx][idx]
            diag2 += grid[idx][2-idx]
        if diag1 != tmp_sum or diag2 != tmp_sum:
            return False
        return True

    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        height = len(grid)
        if height < 3:
            return 0
        cnt = 0
        for idx1 in range(height - 2):
            for idx2 in range(height - 2):
                tmp_grid = [grid[idx1][idx2: idx2 + 3],
                            grid[idx1 + 1][idx2: idx2 + 3],
                            grid[idx1 + 2][idx2: idx2 + 3]]
                if self._is_magic(tmp_grid):
                    cnt += 1
        return cnt
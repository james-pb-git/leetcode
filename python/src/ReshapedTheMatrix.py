class ReshapedTheMatrix(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        height = len(nums)
        width = len(nums[0])
        if r * c != height * width:
            return nums
        res = []
        new_row_idx = -1
        new_col_idx = c
        for ori_row_idx in range(height):
            for ori_col_idx in range(width):
                if new_col_idx == c:
                    res.append([])
                    new_col_idx = 0
                    new_row_idx += 1
                res[new_row_idx].append(nums[ori_row_idx][ori_col_idx])
                new_col_idx += 1
        return res
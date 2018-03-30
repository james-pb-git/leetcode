class ToeplitzMatrix(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        height = len(matrix)
        width = len(matrix[0])
        diagonal_value = [-1] * (height + width - 1)
        for row_idx in range(height):
            for col_idx in range(width):
                if diagonal_value[col_idx - row_idx + height - 1] == -1:
                    diagonal_value[col_idx - row_idx + height - 1] = \
                    matrix[row_idx][col_idx]
                elif diagonal_value[col_idx - row_idx + height - 1] != matrix[row_idx][col_idx]:
                    return False
        return True

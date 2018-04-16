class LargestSumOfAverages(object):

    def __init__(self):
        self.visited = dict()

    def __mean__(self, arr):
        return (0.0 + sum(arr)) / max(len(arr), 1)


    def __largest_sum_of_avg_rec__(self, A, start, end, K):
        if end - start + 1 == K:
            return sum(A[start:end + 1])
        if K == 1:
            return self.__mean__(A[start:end + 1])
        if (start, end, K) in self.visited:
            return self.visited[(start, end, K)]
        max_sum = -1
        for idx in range(start, end - K + 1 + 1):
            res1 = self.__mean__(A[start:idx + 1])
            if res1 + sum(A[idx + 1:end + 1]) <= max_sum:
                continue
            res2 = self.__largest_sum_of_avg_rec__(A, idx + 1, end, K - 1)
            cur_sum = res1 + res2
            if cur_sum > max_sum:
                max_sum = cur_sum
        self.visited[(start, end, K)] = max_sum
        return max_sum


    def largestSumOfAverages(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: float
        """
        return self.__largest_sum_of_avg_rec__(A, 0, len(A) - 1, K)
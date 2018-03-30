
'''
Note: this recursive solution still exceeds time limits in some cases. I'm just putting it here and I'll return after
figuring out the correct DP solution (or similar efficient solutions)
'''
class SplitArrayWithSameAverage(object):
    def __init__(self):
        self.visited_subarray = set()
        self.test_cases = [
            [3, 3, 3],
            [1, 3],
            [1, 2, 3, 4],
            [9990, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30,
             30, 30, 30, 30],
            [71, 54, 44, 61, 55, 34, 42, 17, 56, 16, 26, 86, 97, 52, 24, 48, 29, 19, 15],
            [33, 86, 88, 78, 21, 76, 19, 20, 88, 76, 10, 25, 37, 97, 58, 89, 65, 59, 98, 57, 50, 30, 58, 5, 61, 72, 23,
             6],
        ]

    def __mean__(self, array):
        return float(sum(array)) / max(len(array), 1)

    def __splitArrayRecursive__(self, A, B, C, target):
        if len(A) == 0:
            return len(C) > 0 and len(B) > 0 and sum(B) * len(C) == sum(C) * len(B)

        if self.__mean__(B) > target or self.__mean__(C) > target:
            return False

        if min(A) > target and (len(B) == 0 or len(C) == 0):
            return False

        B.append(A[0])
        if tuple(B) not in self.visited_subarray and \
                tuple(C) not in self.visited_subarray:
            if self.__splitArrayRecursive__(A[1:], B, C, target):
                return True
            self.visited_subarray.add(tuple(B))
        B.pop()

        C.append(A[0])
        if tuple(B) not in self.visited_subarray and \
                tuple(C) not in self.visited_subarray:
            if self.__splitArrayRecursive__(A[1:], B, C, target):
                return True
            self.visited_subarray.add(tuple(B))
        C.pop()
        return False

    def splitArraySameAverage(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        if len(A) <= 1:
            return False
        A.sort()
        B = []
        C = []
        B.append(A[0])
        return self.__splitArrayRecursive__(A[1:], B, C, self.__mean__(A))

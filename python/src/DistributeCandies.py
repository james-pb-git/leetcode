class DistributeCandies(object):
    def distributeCandiesSolution1(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        MIN_VALUE = -100000
        MAX_VALUE = 100000
        existing_candies = [0] * (MAX_VALUE - MIN_VALUE + 1)
        res = 0
        for idx in range(len(candies)):
            if existing_candies[candies[idx] - MIN_VALUE] == 0:
                res += 1
                existing_candies[candies[idx] - MIN_VALUE] = 1
            if res == len(candies) / 2:
                return res
        return res

    def distributeCandiesSolution2(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        return min(len(candies)/2, len(set(candies)))
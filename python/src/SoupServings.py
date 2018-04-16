class SoupServings(object):
    def __init__(self):
        self.prob = dict()

    def __soup_serving_recursive__(self, m, n):
        prob_a = 0.0
        prob_ab = 0.0
        if m == 0 and n == 0:
            return [0.0, 1.0]
        elif m == 0:
            return [1.0, 0.0]
        elif n == 0:
            return [0.0, 0.0]
        if tuple([m,n]) in self.prob:
            prob_a = self.prob[tuple([m,n])][0]
            prob_ab = self.prob[tuple([m, n])][1]
            return [prob_a, prob_ab]

        [tmp_a, tmp_ab] = self.__soup_serving_recursive__(m - min(100, m), n)
        prob_a += 0.25 * tmp_a
        prob_ab += 0.25 * tmp_ab

        [tmp_a, tmp_ab] = self.__soup_serving_recursive__(m - min(75, m), n - min(25, n))
        prob_a += 0.25 * tmp_a
        prob_ab += 0.25 * tmp_ab

        [tmp_a, tmp_ab] = self.__soup_serving_recursive__(m - min(50, m), n - min(50, n))
        prob_a += 0.25 * tmp_a
        prob_ab += 0.25 * tmp_ab

        [tmp_a, tmp_ab] = self.__soup_serving_recursive__(m - min(25, m), n - min(75, n))
        prob_a += 0.25 * tmp_a
        prob_ab += 0.25 * tmp_ab

        self.prob[tuple([m, n])] = tuple([prob_a, prob_ab])
        return [prob_a, prob_ab]

    def soupServings(self, N):
        """
        :type N: int
        :rtype: float
        """
        if N > 5000:
            return 1.0
        [prob_a, prob_ab] = self.__soup_serving_recursive__(N, N)
        return prob_a + 0.5 * prob_ab
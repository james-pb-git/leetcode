import sys
import string

class Solution(object):

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

    def __word_to_groups__(self, word):
        if len(word) == 0:
            return []
        res = []
        start = 0
        end = 0
        while start <= end <len(word):
            while end < len(word) and word[start] == word[end]:
                end += 1
            res.append(word[start:end])
            start = end
        return res

    # group1 is the group after extending
    def __match_groups__(self, group1, group2):
        if len(group1) != len(group2):
            return False
        for idx in range(len(group1)):
            if group1[idx][0] != group2[idx][0]:
                return False
            if len(group1[idx]) != len(group2[idx]) and len(group1[idx]) < 3:
                return False
        return True

    def expressiveWords(self, S, words):
        """
        :type S: str
        :type words: List[str]
        :rtype: int
        """
        res = 0
        groups_s = self.__word_to_groups__(S)
        for word in words:
            if self.__match_groups__(groups_s, self.__word_to_groups__(word)):
                res += 1
        return res

    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        if None == cpdomains or len(cpdomains) == 0:
            return []
        count_subdomain = dict()
        for ele in cpdomains:
            count = int(ele.split(" ")[0])
            array_addresses = ele.split(" ")[1].split(".")
            for idx in range(len(array_addresses)):
                cur_subdomain = ".".join(array_addresses[idx:])
                total_count = count_subdomain.get(cur_subdomain, 0)
                total_count += count
                count_subdomain[cur_subdomain] = total_count
        res = []
        for key in count_subdomain:
            res.append(str(count_subdomain[key]) + " " + key)
        return res


if __name__ == '__main__':
    solution = Solution()
    print solution.soupServings(800)
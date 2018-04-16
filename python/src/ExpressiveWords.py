class ExpressiveWords(object):
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
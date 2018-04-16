class MostCommonWord(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        banned_set = set(banned)
        word_cnt = dict()
        for word in paragraph.split(" "):
            word = word.strip("!?',;.").lower()
            if word not in banned_set:
                cnt =  word_cnt.get(word, 0)
                cnt += 1
                word_cnt[word] = cnt
        max_cnt = -1
        best_word = ''
        for word in word_cnt:
            if word_cnt[word] > max_cnt:
                max_cnt = word_cnt[word]
                best_word = word
        return best_word
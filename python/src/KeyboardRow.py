class KeyboardRow(object):

    def __init__(self):
        # self.init_solution1()
        self.init_solution2()

    def init_solution1(self):
        self.row_map = dict()
        for character in 'qwertyuiop':
            self.row_map[character] = 0
        for character in 'asdfghjkl':
            self.row_map[character] = 1
        for character in 'zxcvbnm':
            self.row_map[character] = 2

    def init_solution2(self):
        self.row0 = set('qwertyuiop')
        self.row1 = set('asdfghjkl')
        self.row2 = set('zxcvbnm')

    def fromSameRow(self, word):
        if len(word) == 0:
            return True
        word = word.lower()
        row_idx = self.row_map[word[0]]
        for character in word[1:]:
            if self.row_map[character] != row_idx:
                return False
        return True

    def findWordsSolution1(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        for word in words:
            if self.fromSameRow(word):
                res.append(word)
        return res

    def findWordsSolution2(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        for word in words:
            word_lower = word.lower()
            if set(word_lower).issubset(self.row0) or \
                set(word_lower).issubset(self.row1) or \
                set(word_lower).issubset(self.row2):
                res.append(word)
        return res
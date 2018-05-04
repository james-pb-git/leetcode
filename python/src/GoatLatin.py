class GoatLatin(object):
    def toGoatLatin(self, S):
        """
        :type S: str
        :rtype: str
        """
        res = ''
        word_index = 1
        vowel = set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'])
        for word in S.split(' '):
            if word[0] in vowel:
                res += word + 'ma'
            else:
                res += word[1:] + word[0] + 'ma'
            res += 'a' * word_index + ' '
            word_index += 1
        return res[:-1]  # remove space in the end
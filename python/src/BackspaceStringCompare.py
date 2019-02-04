class BackspaceStringCompare(object):
    def _process_backspace(self, str):
        res = ''
        for char in str:
            if char == '#' and len(res) > 0:
                res = res[:-1]
            elif char != '#':
                res += char
        return res

    def backspaceCompare(self, S, T):
        return self._process_backspace(S) == self._process_backspace(T)

    # This is wrong for case ('bxj##tw', 'bxo#j##tw'). A stack is necessary!
    def _get_previous_idx(self, str, idx):

        if idx - 1 >= 0 and str[idx - 1] != '#':
            return idx - 1

        cnt_of_backspace = 0
        while idx - 1 >= 0 and str[idx - 1] == '#':
            cnt_of_backspace += 1
            idx -= 1
        while idx - 1 >= 0 and cnt_of_backspace > 0:
            idx -= 1
            cnt_of_backspace -= 1
        if idx - 1 < 0:
            return -1
        if str[idx - 1] != '#':
            return idx - 1
        return self._get_previous_idx(str, idx)

    def backspaceCompareWrongAnswer(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: bool
        """
        idx1 = len(S)
        idx2 = len(T)
        while True:
            idx1 = self._get_previous_idx(S, idx1)
            idx2 = self._get_previous_idx(T, idx2)
            if idx1 == -1 and idx2 == -1:
                return True
            if idx1 == -1 or idx2 == -1:
                return False
            if S[idx1] != T[idx2]:
                return False
        return True
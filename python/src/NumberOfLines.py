

class NumberOfLines(object):
    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        max_line_width = 100
        map_character = dict()
        for (idx, ch) in enumerate(string.ascii_lowercase):
            map_character[ch] = widths[idx]
        line_num = 0
        cur_line_len = 0
        for ch in S:
            if cur_line_len + map_character[ch] <= max_line_width:
                cur_line_len += map_character[ch]
            else:
                line_num += 1
                cur_line_len = map_character[ch]
        return [line_num + 1, cur_line_len]
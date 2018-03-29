import string

class UniqueMorseCodeWords(object):

    def __init__(self):
        self.map_character = dict()
        morse_list = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                      "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]
        for (idx, ch) in enumerate(string.ascii_lowercase):
            self.map_character[ch] = morse_list[idx]

    def uniqueMorseRepresentations(self, words):
        res_set = set()
        for word in words:
            morse_code = ''
            for ch in word:
                morse_code += self.map_character[ch]
            res_set.add(morse_code)
        return len(res_set)
class LinkedListComponents(object):
    def numComponents(self, head, G):
        """
        :type head: ListNode
        :type G: List[int]
        :rtype: int
        """
        bit_map = [0] * 10000
        subset = set(G)
        len_list = 0
        cur_node = head
        while cur_node is not None:
            if cur_node.val in subset:
                bit_map[len_list] = 1
            len_list += 1
            cur_node = cur_node.next

        cnt_components = 0
        for idx in range(1, len_list):
            if bit_map[idx] == 0 and bit_map[idx-1] == 1:
                cnt_components += 1
        if bit_map[len_list - 1] == 1:
            cnt_components += 1
        return cnt_components
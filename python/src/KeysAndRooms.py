class KeysAndRooms(object):

    def _visit_from(self, room_num, rooms, visited):
        visited[room_num] = 1
        for num in rooms[room_num]:
            if visited[num] == 0:
                self._visit_from(num, rooms, visited)

    def canVisitAllRooms(self, rooms):
        """
        :type rooms: List[List[int]]
        :rtype: bool
        """
        visited = [0] * len(rooms)
        self._visit_from(0, rooms, visited)
        return min(visited) == 1
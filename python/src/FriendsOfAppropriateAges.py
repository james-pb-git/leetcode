class FriendsOfAppropriateAges(object):
    def numFriendRequests(self, ages):
        """
        :type ages: List[int]
        :rtype: int
        """
        MAX_AGE = 120
        cnt_ages = [0] * MAX_AGE
        for ele in ages:
            cnt_ages[ele - 1] += 1

        acu_ages = [0] * MAX_AGE  # acu_ages[i] = sum(cnt_ages[0], .., cnt_ages[i])
        acu_ages[0] = cnt_ages[0]
        for idx in range(1, MAX_AGE):
            acu_ages[idx] = cnt_ages[idx] + acu_ages[idx - 1]

        res = 0
        for idx in range(MAX_AGE):
            if cnt_ages[idx] != 0:
                res += cnt_ages[idx] * acu_ages[idx]
                res -= cnt_ages[idx] * min(acu_ages[(idx+1)//2+7-1], acu_ages[idx])
                if idx + 1 > (idx + 1) // 2 + 7:
                    res -= cnt_ages[idx]
        return res
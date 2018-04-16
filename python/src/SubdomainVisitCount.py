class SubdomainVisitCount(object):
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        if None == cpdomains or len(cpdomains) == 0:
            return []
        count_subdomain = dict()
        for ele in cpdomains:
            count = int(ele.split(" ")[0])
            array_addresses = ele.split(" ")[1].split(".")
            for idx in range(len(array_addresses)):
                cur_subdomain = ".".join(array_addresses[idx:])
                total_count = count_subdomain.get(cur_subdomain, 0)
                total_count += count
                count_subdomain[cur_subdomain] = total_count
        res = []
        for key in count_subdomain:
            res.append(str(count_subdomain[key]) + " " + key)
        return res
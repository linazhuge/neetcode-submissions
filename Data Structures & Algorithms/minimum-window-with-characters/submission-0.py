class Solution:
    def minWindow(self, s: str, t: str) -> str:
        def equivalentMaps(map1, map2):
            for key in map1:
                if key not in map2:
                    return False
                if map1[key] > map2[key]:
                    return False
            return True
        
        map1 = {}
        map2 = {}

        for c in t:
            if c not in map1:
                map1[c] = 1
            else:
                map1[c] += 1


        shortestLen = float('inf')
        shortestIndex = -1
        l = 0

        for r in range(len(s)):
            c = s[r]
            if c not in map2:
                map2[c] = 1
            else:
                map2[c] += 1
            
            while equivalentMaps(map1, map2) and l <= r:
                if (r - l) < shortestLen:
                    shortestIndex = l
                    shortestLen = r - l
                map2[s[l]] -= 1
                l += 1
        
        if shortestLen == float('inf'):
            return ""
        else:
            return s[shortestIndex : shortestIndex + shortestLen + 1]

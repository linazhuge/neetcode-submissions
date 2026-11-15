class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        def equalArrs(arr1, arr2):
            if len(arr1) != len(arr2):
                return False
            for i in range(len(arr1)):
                if arr1[i] != arr2[i]:
                    return False
            return True

        if len(s1) > len(s2):
            return False

        arr1 = [0] * 26
        arr2 = [0] * 26

        for c in s1:
            arr1[ord(c) - ord('a')] += 1

        for i in range(len(s1)):
            arr2[ord(s2[i]) - ord('a')] += 1

        if equalArrs(arr1, arr2):
            return True

        for i in range(len(s1), len(s2)):
            arr2[ord(s2[i]) - ord('a')] += 1
            arr2[ord(s2[i - len(s1)]) - ord('a')] -= 1
            if equalArrs(arr1, arr2):
                return True

        return False

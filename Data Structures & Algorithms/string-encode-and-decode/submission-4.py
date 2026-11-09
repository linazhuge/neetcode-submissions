class Solution:

    def encode(self, strs: List[str]) -> str:
        ret = ""
        for s in strs:
            ret += str(len(s))
            ret += "#"
            ret += s
        return ret
    def decode(self, s: str) -> List[str]:
        lst = []
        p = 0
        while p < len(s):
            numstr = ""
            while s[p] != '#':
                numstr += s[p]
                p += 1
            print(numstr)
            num = int(numstr)
            lst.append(s[p + 1 : p + num + 1])
            p = p + num + 1

        return lst

class TimeMap:

    def __init__(self):
        self.tm = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key in self.tm:
            self.tm[key].append((value, timestamp))
        else:
            self.tm[key] = [(value, timestamp)]


    def get(self, key: str, timestamp: int) -> str:
        if key not in self.tm:
            return ""

        if self.tm[key][0][1] > timestamp:
            return ""
        l = 0
        r = len(self.tm[key]) - 1

        while l < r:
            m = (l + r + 1) // 2
            if timestamp < self.tm[key][m][1]:
                r = m - 1
            else:
                l = m

        return self.tm[key][l][0]


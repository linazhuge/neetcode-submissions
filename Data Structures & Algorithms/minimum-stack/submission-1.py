class MinStack:

    def __init__(self):
        self.stk = deque()

    def push(self, val: int) -> None:
        if self.stk:
            self.stk.append((val, min(self.stk[-1][1], val)))
        else:
            self.stk.append((val, val))

    def pop(self) -> None:
        self.stk.pop()

    def top(self) -> int:
        val, m = self.stk[-1]
        return val

    def getMin(self) -> int:
        val, m = self.stk[-1]
        return m

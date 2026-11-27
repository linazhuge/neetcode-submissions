class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stk = []
        dq = deque()
        for i in range(len(temperatures) - 1, -1, -1):
            dq.appendleft(0)
            while stk and temperatures[stk[-1]] <= temperatures[i]:
                stk.pop()
            if stk:
                dq[0] = stk[-1] - i
            stk.append(i)

        return list(dq)

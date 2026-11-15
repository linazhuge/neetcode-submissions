class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lefts = [0] * n
        rights = [0] * n
        maxL = 0
        maxR = 0
        for i in range(n):
            lefts[i] = maxL
            maxL = max(height[i], maxL)

        for i in range(n-1, -1, -1):
            rights[i] = maxR
            maxR = max(height[i], maxR)

        vol = 0
        for i in range(n):
            minH = min(lefts[i], rights[i])
            if height[i] <= minH:
                vol += (minH - height[i])

        return vol


                    
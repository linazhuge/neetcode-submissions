class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        pq = []
        arr = []

        for i in range(0, k):
            heapq.heappush(pq, (-nums[i], i))

        arr.append(-pq[0][0])

        for i in range(k, len(nums)):
            heapq.heappush(pq, (-nums[i], i))
            while pq[0][1] < (i - k + 1):
                heapq.heappop(pq)
            arr.append(-pq[0][0])

        return arr
        
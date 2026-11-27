class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.pq = []
        self.k = k
        for num in nums:
            if len(self.pq) >= k:
                if num > self.pq[0]:
                    heapq.heappop(self.pq)
                    heapq.heappush(self.pq, num)
            else:
                heapq.heappush(self.pq, num)

    def add(self, val: int) -> int:
        if len(self.pq) >= self.k:
            if val > self.pq[0]:
                heapq.heappop(self.pq)
                heapq.heappush(self.pq, val)
        else:
            heapq.heappush(self.pq, val)
        return self.pq[0]

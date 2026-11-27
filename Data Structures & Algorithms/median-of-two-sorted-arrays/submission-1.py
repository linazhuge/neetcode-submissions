class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        len1 = len(nums1)
        len2 = len(nums2)
        mid = (len1 + len2) // 2 # number of elements

        l = 0
        r = len1
        while l <= r:
            m = (l + r) // 2 # m elements in nums1
            if m > mid:
                r = m - 1
                continue
            n = mid - m # n elements in nums2
            if n > mid:
                l = m + 1
                continue

            # compare:
                # nums1[m] and nums2[n - 1]
                # nums1[m - 1] and nums2[n]

            if m < len1 and n - 1 >= 0 and nums1[m] < nums2[n - 1]:
                l = m + 1
                continue
            if m - 1 >= 0 and n < len2 and nums1[m - 1] > nums2[n]:
                r = m - 1
                continue

            left_max = max(nums1[m - 1] if m > 0 else float('-inf'),
                           nums2[n - 1] if n > 0 else float('-inf'))
            right_min = min(nums1[m] if m < len1 else float('inf'),
                            nums2[n] if n < len2 else float('inf'))

            if (len1 + len2) % 2 == 0:
                return (left_max + right_min) / 2
            return right_min


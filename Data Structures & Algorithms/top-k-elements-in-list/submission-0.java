class Element {
    int val;
    int freq;

    Element (int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Element> pq = new PriorityQueue<>(
            Comparator.comparingInt((Element e) -> e.freq).reversed()
        );
        int [] top = new int[k];

        for (int x : nums) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        map.forEach((key, value) -> pq.add(new Element(key, value)));

        for (int i=0; i < k; i++) {
            top[i] = pq.poll().val;
        }

        return top;
    }
}

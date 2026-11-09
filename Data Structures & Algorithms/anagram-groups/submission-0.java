class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            if (map.containsKey(sortString(str))) {
                map.get(sortString(str)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortString(str), list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public String sortString(String str) {
        char [] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);      
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();

        List<List<String>> output = new ArrayList<>();

        for(String s : strs){
            char[] count = new char[26];
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }
            String key = new String(count);
            groupMap.computeIfAbsent(key, v -> new ArrayList<>()).add(s);
        }

        for(Map.Entry<String, List<String>> entry : groupMap.entrySet()){
            output.add(entry.getValue());
        }

        return output;
    }
}

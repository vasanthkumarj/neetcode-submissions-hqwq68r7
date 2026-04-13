class Solution {
    public String foreignDictionary(String[] words) {
      if(words == null || words.length == 0){
        return "";
      }

      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> inDegree = new HashMap<>();

      for(String text : words){
        for(char c : text.toCharArray()){
            adj.put(c, new HashSet<>());
            inDegree.put(c, 0);
        }
      }

      for(int i = 0; i < words.length-1; i++){
        String word1 = words[i];
        String word2 = words[i+1];
        boolean foundOrder = false;
        int minLen = Math.min(word1.length(), word2.length());
        for(int j = 0; j < minLen; j++){
            char c1 = word1.charAt(j);
            char c2 = word2.charAt(j);
            
            if(c1 != c2){
                if(!adj.get(c1).contains(c2)){
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2)+1);
                }
                foundOrder = true;
                break;
            }
        }
            if(!foundOrder && word1.length() > word2.length()){
                return "";
            }
      }

    Queue<Character> queue = new LinkedList<>();
    for(Map.Entry<Character, Integer> node : inDegree.entrySet()){
        if(node.getValue() == 0){
            queue.offer(node.getKey());
        }
    }


    StringBuilder result = new StringBuilder();

    while(!queue.isEmpty()){
        char current = queue.poll();

        result.append(current);


        for(Character neighbour : adj.get(current)){
            inDegree.put(neighbour, inDegree.get(neighbour)-1);
            if(inDegree.get(neighbour) == 0){
                queue.offer(neighbour);
            }
        }
    }

    return result.length() == inDegree.size() ? result.toString() : ""; 

    }
}

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String text : strs){
            sb.append(text.length());
            sb.append("#");
            sb.append(text);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int len = str.length();
        int left = 0;
        while(left < len){
            int right = left;
            while(str.charAt(right) != '#'){
                right++;
            }

            int n = Integer.parseInt(str.substring(left, right));

            left = right + 1;
            right = left+n;
            result.add(str.substring(left, right));

            left = right;
        }

        return result;
    }
}

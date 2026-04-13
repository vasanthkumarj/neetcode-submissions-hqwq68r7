class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int index = 0;
        while(index < str.length()){
            StringBuilder numString = new StringBuilder();
            while(str.charAt(index) != '#'){
                numString.append(str.charAt(index));
                index++;
            }
            int length = Integer.parseInt(numString.toString());
            output.add(str.substring(index+1, index+length+1));
            index = index+length+1;
        }
        return output;
    }
}

class Solution {
    public String reverseWords(String s) {
        List<String> list  = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
           char c = s.charAt(i);
           if(c != ' '){
            sb.append(c);
           }
           if((i == s.length()-1 || s.charAt(i) == ' ') && sb.length()>0){
            list.add(sb.toString());
            sb.setLength(0);
           }
        }

        Collections.reverse(list);
        System.out.println(list);
        String ans ="";
        for(int i=0;i<list.size();i++){
            if(i> 0){
                ans += " ";
            }
            ans += list.get(i);    
        }

        return ans;

    }
}
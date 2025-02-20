class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       int n =  s.length();
        int m = p.length();
        
        int freq1[] = new int[26];
        int freq2[] = new int[26];
        List<Integer> list = new ArrayList<>();
        if(n < m){
            return list;
        }
        for(int i=0;i<m;i++){
            freq1[p.charAt(i)-'a']++;
        }
        int countMatched=0;
        int distance = 0;
         for(int i=0;i<26;i++){
            if(freq1[i]>0){
                distance++;
            }
        }
        for(int i=0;i<m-1;i++){
            freq2[s.charAt(i)-'a']++;
            if(freq1[s.charAt(i)-'a'] == freq2[s.charAt(i)-'a']){
                countMatched++;
            }
        }
//        System.out.println(Arrays.toString(freq1));

        for(int i=m-1;i<n;i++){
//            System.out.println(Arrays.toString(freq2));

            int startIndex = i-(m-1);
            freq2[s.charAt(i)-'a']++;
            if(freq2[s.charAt(i)-'a'] == freq1[s.charAt(i)-'a']){
                countMatched++;
            }
            if(countMatched == distance){
                list.add(startIndex);
            }

            freq2[s.charAt(startIndex)-'a']--;
            if(freq1[s.charAt(startIndex)-'a'] -1== freq2[s.charAt(startIndex)-'a']){
                countMatched--;
            }

        }

        return list;
    }
}
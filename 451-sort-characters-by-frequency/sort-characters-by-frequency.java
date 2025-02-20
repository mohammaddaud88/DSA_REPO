class Solution {
    public String frequencySort(String s) {
        int arr[] = new int[256];
        Character str[]  = new Character[s.length()];
        for(int i=0;i<s.length();i++){
            arr[(int) s.charAt(i)]++;
            str[i]=s.charAt(i);
        }
        Arrays.sort(str,new Comparator<Character>(){
            public int compare(Character ch1, Character ch2){
                int a = (int) ch1;
                int b = (int) ch2;
                if(arr[a] != arr[b]){
                    return arr[b]-arr[a];
                } else {
                    return a-b;
                }
            }
        });
        String st ="";
        for(int i=0;i<str.length;i++){
            st += str[i];
        }
        return st;
    }
}
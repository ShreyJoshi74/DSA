class Solution {
    public boolean isPred(String a,String b){
        int x = a.length();
        int y = b.length();
        if(y - x != 1 ) return false;
        int i = 0,j = 0,change = 1;
        while(i < x && j < y){
            if(a.charAt(i) != b.charAt(j)){
                change--;
                j++;
                if(change < 0) return false;
            }else{
                i++;
                j++;
            }
        }
        return true;
        
    }
    public int longestStrChain(String[] words) {
        if (words.length ==1) return 1;
        Arrays.sort(words,new Comparator<String>(){
            public int compare(String s1,String s2){
                int a = s1.length();
                int b = s2.length();
                if(a != b) return Integer.compare(a ,b);
                else return s1.compareTo(s2);
            }
        });
        int[] size = new int[words.length];
    
        for(int i = 0; i < words.length; i++){
            size[i] = 1;
            
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = 0 ; j < i; j++){
                if(words[i].length() - words[j].length() != 1) continue;
                else{
                    if(isPred(words[j],words[i]) && size[i] < size[j] + 1){
                        size[i] = size[j] + 1;
                      
                    }
                }
            }
            if(size[i] > max){
                max = size[i];
            }
            
        }

        return max;
    }
}
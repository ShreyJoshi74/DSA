class Solution {
    public boolean isConsonant(char ele){
        if((ele >= 'a' && ele <= 'z' && ele != 'a' && ele != 'e' && ele != 'i' && ele != 'o' && ele != 'u')
            || (ele >= 'A' && ele <= 'Z' && ele != 'A' && ele != 'E' && ele != 'I' && ele != 'O' && ele != 'U')) return true;
        return false;
    }
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean hasConsonant = false;
        boolean hasVowel = false;
        for(char ele : word.toCharArray()){
            if(ele < '0' || (ele > '9' && ele < 'A') || (ele > 'Z' && ele < 'a') || ele > 'z' ) return false;

            if(!hasVowel && (ele == 'a' || ele == 'e' || ele == 'i' || ele == 'o' || ele == 'u') 
                || (ele == 'A' || ele == 'E' || ele == 'I' || ele == 'O' || ele == 'U')) 
                    hasVowel = true; 

            if(!hasConsonant && isConsonant(ele)) hasConsonant = true;
        }
        System.out.println(hasConsonant + " " + hasVowel);
        if(hasConsonant && hasVowel) return true;
        return false;
    }
}
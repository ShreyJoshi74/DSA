// You are using Java
import java.util.*;
public class Main{
    public static String f(String big,String s){
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        //creating map of all minimum required
        while(i < s.length()){
            char t = s.charAt(i);
            if(!map.containsKey(t)) map.put(t,1);
            else map.put(t,map.get(t) + 1);
            i++;
        }
        i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        // Taking right pointer all the way to right where it covers all required character of small string
        while(i < big.length()){
            char temp = big.charAt(i);
            if(map.containsKey(temp)) map.put(temp,map.get(temp) - 1);
            boolean ind = true;
            for(Map.Entry e : map.entrySet()){
                if((int)e.getValue() > 0) ind = false;
            }
            if(ind) break;
            i++;
        }
        int maxLen = i - j + 1;
        String output = big.substring(j,i+1);
      // Finally finding my minimum string using j ptr and maintaining window
        while(i < big.length()){
            char temp = big.charAt(i);
            if(map.containsKey(temp)) map.put(temp,map.get(temp) - 1);
            while(!map.containsKey(big.charAt(j)) || map.get(big.charAt(j)) < 0){
                if(map.containsKey(big.charAt(j))) map.put(big.charAt(j),map.get(big.charAt(j)) + 1);
                j++;
            }
            if(i - j + 1 < maxLen){
                maxLen = i - j + 1;
                output = big.substring(j,i+1);
            }
            i++;
            
        }
      // final output
        return output;
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String big = sc.nextLine();
        String small = sc.nextLine();
        System.out.println(f(big,small));
    }
}

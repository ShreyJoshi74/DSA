/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
    public static int f(int i,int j,int[][] dp,String str1,String str2){
        if(i >= str1.length() || j >= str2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = 0;
        max = Math.max(max,f(i + 1,j,dp,str1,str2));
        max = Math.max(max,f(i,j+1,dp,str1,str2));
        int cnt = 0;
        while(i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)){
            cnt++;
            i++;
            j++;
        }
        return dp[i][j] = Math.max(max,cnt);
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i = 0; i < str1.length(); i++) Arrays.fill(dp[i],-1);
		System.out.println(f(0,0,dp,str1,str2));
		
		System.out.println("using tabulation && most optimized");
		int[][] dp2 = new int[str1.length() + 1][str2.length() + 1];
		for(int i = 0; i <= str1.length();i++) dp[i][0] = 0;
		for(int i = 0; i <= str2.length(); i++) dp[0][i] = 0;
		
		//tabulation starts
		int maxii = 0;
		for(int i = 1; i <= str1.length(); i++){
		    for(int j = 1; j <= str2.length(); j++){
		        if(str1.charAt(i-1) == str2.charAt(j-1)){
		            dp[i][j] = 1 + dp[i-1][j-1];
		            maxii = Math.max(maxii,dp[i][j]);
		        }
		    }
		}
		System.out.println("biggest length : "+maxii);
		
	}
}

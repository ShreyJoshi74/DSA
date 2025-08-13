/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
// floor 
// largest number <= target
// Ceil 
// Smalles Number >= target
public class Main
{   
    public static int floor(int[] nums,int target){ // floor function
        int l = 0, h = nums.length -1,mid;
        int ans = -1;
        while(l <= h){
            mid = l + (h - l)/2;
            if(nums[mid] <= target){
                ans = nums[mid];
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return ans;
    }
    public static int ceil(int[] nums,int target){ // ceil function
        int l = 0, h = nums.length -1,mid;
        int ans = -1;
        while(l <= h){
            mid = l + (h - l)/2;
            if(nums[mid] >= target){
                ans = nums[mid];
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] nums = {1,2,3,5,7,9,34,56,78};
		System.out.println(floor(nums,0));
	}
}

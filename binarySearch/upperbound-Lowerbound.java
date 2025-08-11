public class Main
{   
    
    // lowerbound
    // result >= target
    public static int lowerBound(int[] arr,int target){
        int low = 0;
        int high = arr.length -1,ans = arr.length;
        int mid;
        while(low <= high){
            mid = low + (high - low )/ 2;
            if(arr[mid] >= target){
                ans = mid;
                high = mid - 1;
                
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    // upperbound
    // arr[idx] > target
    public static int upperBound(int[] arr,int target){
        int low = 0;
        int high = arr.length -1;
        int mid;
        int ans = arr.length;
        while(low <= high){
            mid = low + (high - low )/ 2;
            if(arr[mid] > target){
                ans = mid;
                high = mid - 1;
                
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr = {1,2,3,4,5,7,8,9};
		System.out.println(arr[lowerBound(arr,3)]);
		System.out.println(upperBound(arr,8));
	}
}

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 1;i < arr.length; i++){
            int diff = arr[i] - arr[i - 1];
            if(diff > min)
                continue;
            if(diff == min)
                output.add(Arrays.asList(arr[i-1],arr[i]));
            else{
                min = diff;
                output.clear();
                output.add((Arrays.asList(arr[i-1],arr[i])));
            }
        }
        return output;
    }
}
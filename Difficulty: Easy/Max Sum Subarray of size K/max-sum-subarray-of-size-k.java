class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
       
        int n = arr.length;
        
        int sum = 0;
        
        for(int i = 0; i < k; i++){
            sum += arr[i];
        } 
        
        int ans = sum;
        
        int sp = 0;
        int ep = k;
        
        while(ep<=n-1){
            sum = sum - arr[sp];
            sum = sum + arr[ep];
            ans = Math.max(sum,ans);
            sp++;
            ep++;
        }
        
        return ans;
        
    }
}
// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        // Complete the function
        int n = arr.length;
        
        int overallCount = 0;
        for(int num : arr){
            if(num <= k)overallCount++;
        }
        
        int currArrCount = 0;
        for(int i = 0; i < overallCount; i++){
            if(arr[i] <= k )currArrCount++;
        }
        
        int required = overallCount - currArrCount;
        int ans = required; //1
        
        int sp = 1;
        int ep = overallCount; //3
        
        while(ep < n){
            if(arr[sp-1] <= k){
                //means it was an imp element
                currArrCount--;
            }
            
            if(arr[ep] <= k){
                //useful
                currArrCount++;
            }
            
            required = overallCount - currArrCount;
            
            ans = Math.min(ans,required);
            
            
            sp++;
            ep++;
            
        }
        
        return ans;
    }
}

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   
System.out.println("~");
}
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        for(int i = 0; i < n; i++){
            if(arr[i]==0)arr[i] = -1;
        }
        
        HashMap <Integer,Integer> hm = new HashMap<>();
        int pfsum[] = prefixSum(arr);
        hm.put(0,1);
        int ans = 0;
        int k = 0;
        for(int ep = 0; ep < n; ep++){
            int diff = pfsum[ep]-k;
            ans = ans + hm.getOrDefault(diff,0);
            hm.put(pfsum[ep],hm.getOrDefault(pfsum[ep],0)+1);
        }
        return ans;
        
        
    }
    
    static int[] prefixSum(int arr[]){
        int n = arr.length;
        int pfsum[] = new int[n];
        pfsum[0] = arr[0];
        for(int i = 1; i < n; i++){
            pfsum[i] = pfsum[i-1] + arr[i];
        }
        return pfsum;
        
    }
}



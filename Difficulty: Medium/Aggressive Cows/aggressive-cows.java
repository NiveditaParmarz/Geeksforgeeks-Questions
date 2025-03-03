//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int lo = minDiff(stalls);
        int hi = stalls[n-1] - stalls[0];
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int cows = calculate(stalls,mid);
            if(cows < k){
                hi = mid -1;
            }
            else{
                ans = mid;
                lo = mid+1;
            }
        }
        return ans;
    }
    
    public static int minDiff(int arr[]){
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++){
            if(arr[i+1]-arr[i] < minDiff){
                minDiff = arr[i+1]-arr[i];
            }
        }
       
        return minDiff;
    }
    
    public static int calculate(int arr[], int mid){
        int n = arr.length;
        int count = 1;
        int lastCowPosn = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i]-lastCowPosn >= mid){
                count++;
                lastCowPosn = arr[i];
            }
        }
        return count;
    }
}
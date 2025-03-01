//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int lo = maxOfArr(arr); //itna minimum time toh lagega hi.
    
        int hi = sumOfArr(arr);
        int ans = sumOfArr(arr);
        
        while(lo <= hi){
            int currTime = lo + (hi-lo)/2;
            int reqWorkers = requiredWorkers(arr,currTime); 
            if(reqWorkers <= k){
                ans = currTime;
                hi = currTime - 1;
            }
            else{
                lo = currTime + 1;
            }
        }
        return ans;
    }
    
    public int requiredWorkers(int arr[],int time){
        int workers = 1;
        int sum = 0;
        for(int currTime:arr){
            if(sum + currTime > time){
                workers++;
                sum = 0;
            }
            sum = sum + currTime;
        }
        return workers;
    }
    
    public int sumOfArr(int arr[]){
        int sum = 0;
        for(int n:arr){
            sum += n;
        }
        return sum;
    }
    public int maxOfArr(int arr[]){
        int max = -1;
        for(int n : arr){
            if(n > max)max = n;
        }
        return max;
        
    }
}

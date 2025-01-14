//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Input array as a space-separated string
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            // Parse the input array
            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findSubarray(arr));
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public int findSubarray(int[] arr) {
        // code here.
        int n = arr.length;
        int ans = 0;
        HashMap <Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int pfsum[] = pfsum(arr);
        for(int ep = 0; ep < n; ep++){
            int diff = pfsum[ep];
            ans = ans + hm.getOrDefault(diff,0);
            hm.put(pfsum[ep],hm.getOrDefault(pfsum[ep],0)+1);
        }
        return ans;
    }  
    
    public int[] pfsum(int arr[]){
        int n = arr.length;
        int pfsum[] = new int[n];
        pfsum[0] = arr[0];
        for(int i = 1; i < n; i++){
            pfsum[i] = pfsum[i-1] + arr[i];
        }
        return pfsum;
    }
}

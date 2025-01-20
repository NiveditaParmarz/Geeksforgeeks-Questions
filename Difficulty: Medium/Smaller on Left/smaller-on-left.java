//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        Stack <Integer> st = new Stack<>(); 
        List<Integer> list = new ArrayList<>();
        int ans[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while(st.size()>0 && a[i]<a[st.peek()]){
                int idx = st.pop();
                ans[idx] = a[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            int idx = st.pop();
                ans[idx] = -1;
        }
        for(int num: ans){
            list.add(num);
        }
        return list;
    }
}
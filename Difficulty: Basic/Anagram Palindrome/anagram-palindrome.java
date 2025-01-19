//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		
System.out.println("~");
}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int count = 0;
        // HashSet<Character> hs = new HashSet<>();
        // for(int i = 0; i < S.length(); i++){
        //     char ch = S.charAt(i);
        //     hs.add(ch);
        // }
        //we want one freq odd, rest even. 2 odds also won't work.
        // for(int num:hs){
        //     int freq = hm.get(num);
        //     if(freq%2!=0){
        //         count++;
        //         if(count>1)return 0;
        //     }
        // }
        
        for(char key : hm.keySet()){
            int freq = hm.get(key);
            if(freq%2!=0){
                count++;
                if(count>1)return 0;
            }
        }
        return 1;
    }
}
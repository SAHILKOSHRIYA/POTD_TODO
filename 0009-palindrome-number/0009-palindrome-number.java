class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        
        int rev=0;
        int n=x;
        
       
        while(x!=0)
        {
            int last_digit=x%10;
            rev=rev*10+last_digit;
            x=x/10;
        }
        
        if(n==rev)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
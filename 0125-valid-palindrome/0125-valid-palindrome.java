class Solution {
    public boolean isPalindrome(String s) {
        
        // filtere out non-alphanumeric character and convert to lowercase
         StringBuilder filterdStr = new StringBuilder();
        
        for( char c : s.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            {
                filterdStr.append(Character.toLowerCase(c));
            }
        }
        // call the recursive helper function 
        return isPalindromeRecursive(filterdStr.toString(),0,filterdStr.length()-1);
        
        
        
    }
     
     private boolean isPalindromeRecursive(String s,int left,int right)
     {
         // Base case: if pointer cross , it is palindrome
         
         if(left>=right)
         {
             return true;
             
         }
         
         //check character at Start (left pointer) End (right  pointer are same or not
          if(s.charAt(left)!=s.charAt(right))
          {
              return false;
          }
         // move towards the center
          return isPalindromeRecursive(s,left+1,right-1);
         
         
     }
}
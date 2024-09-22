// class Solution {
//     public int reverse(int x) {
//         int rev =0;
//         int sign = x<0 ?-1 : 1;
//         x=Math.abs(x);
//         if( x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
//                 return 0;
//                 }
//     while(x!=0)
//     {
//         int last= x%10;
//         if(rev > (Integer.MAX_VALUE-last)/10)
//         {
//             return 0;
//         }
//         rev = rev*10+last;
//         x=x/10;

//     }
//     // if( x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
//     //             return 0;
//     //             }

//     return sign * rev;
        
//     }
// }
//  long num =0;  // to avoid overflow of 32 bits

//             while( x != 0 ){
//                 num = num*10 + x % 10;
//                 x/=10;
//             }           
//             if( num > Integer.MAX_VALUE || num < Integer.MIN_VALUE){
//                 return 0;
//                 }

//       return (int) num;


class Solution 
{
     public int  reverse(int x)
     {
         int rev=0;
         int sign= x<0? -1 : 1;
         x=Math.abs(x);
         if(x<Integer.MIN_VALUE|| x> Integer.MAX_VALUE)
         {
             return 0;
         }
          while(x!=0)
          {
              int last_d=x%10;
              if(rev>(Integer.MAX_VALUE-last_d)/10)
              {
                 return 0; 
              }
               rev = rev *10 +last_d;
               x=x/10;
          }
          return sign * rev ;
     }
}
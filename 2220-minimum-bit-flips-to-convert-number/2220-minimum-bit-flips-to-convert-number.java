// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int start1=Integer.tobinaryString(start);
//         int goal1=Integer .toBinaryString(goal1);
//         int count=0;
//         while(goal>0)
        
//     }
// }
// class Solution {
//     public int minBitFlips(int start, int goal) {
//         // XOR of start and goal gives us the positions where the bits differ
//         int xor = start ^ goal;
        
//         // Count the number of 1's in the XOR result using Integer.bitCount()
//         return Integer.bitCount(xor);
//     }
// }

// class Solution {
//     public int minBitFlips(int start, int goal) {
//         // XOR of start and goal gives us the positions where the bits differ
//         int xor = start ^ goal;
        
//         // Count the number of 1's in the XOR result
//         int count = 0;
//         while (xor > 0) {
//             count += xor & 1;  // Check if the least significant bit is 1
//             xor >>= 1;         // Right shift xor by 1 to check the next bit
//         }
        
//         return count;  // Return the number of differing bits
//     }
// }
class Solution 
{
   public int minBitFlips(int start, int goal)
    {
         /*1.Xor operator return the position  of Differ bits in the string(int) 
             example :- start =10 goal =7 
             equivalent :- 1010        0111 
             both of them differ by three bit 3
             so Xor   operator give output of differ bits position 
        */
        
        
        int xor= start ^ goal;
        
        // counting the no of differ bits - count the  no of  1's in xor result 
         int count=0;
         while(xor>0)
         {
             count+=xor&1; //count the 1's and add on count
             xor >>= 1;  // shift 1 bit right in xor result
         }
        
        return count ;  // returns no of differ bits
    
    }
}
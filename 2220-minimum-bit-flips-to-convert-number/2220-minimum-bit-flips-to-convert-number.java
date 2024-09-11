// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int start1=Integer.tobinaryString(start);
//         int goal1=Integer .toBinaryString(goal1);
//         int count=0;
//         while(goal>0)
        
//     }
// }
class Solution {
    public int minBitFlips(int start, int goal) {
        // XOR of start and goal gives us the positions where the bits differ
        int xor = start ^ goal;
        
        // Count the number of 1's in the XOR result using Integer.bitCount()
        return Integer.bitCount(xor);
    }
}

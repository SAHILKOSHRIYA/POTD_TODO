class Solution {
    public int fib(int n) {
        
        if(n==0)
        {
            return 0;
            
        }
        if(n==1)
        {
            return 1;
        }
        // return fib(n-1)+fib(n-2);          // 1.recursice function 
//         int fib[]=new int [n+1];
//         fib[0]=0;
//         fib[1]=1;
//         for(int i = 2;i<=n;i++)
//         {
//             fib[i]=fib[i-1]+fib[i-2];  // 2.space complexity increases
//         }
                     // optimizing the space complexity
         int slast=0;
             int last=1;
        int temp=0;
        
        for(int i=2;i<=n;i++)       {
           
            temp=last+slast;
            slast=last;
            last=temp;
            
        }
         return temp;
     //return fib[n];
    }
}
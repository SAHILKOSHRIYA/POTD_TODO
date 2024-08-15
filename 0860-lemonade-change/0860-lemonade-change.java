class Solution {
    public boolean lemonadeChange(int[] bills) {
    //     int sum=0;
    //     for(int i : bills)
    //     {
    //         sum=sum+i;

    //     }
    //     int add = 5*bills.length;
    //     int diff = sum-add;
    //     if(diff >= add)
    //     {
    //         return false;
    //     }
    //     else
    //     {
    //         return true;
    //     }

    int five=0; 
    int ten=0;
    for(int i : bills)
    {
          if(i==5)
          {
            five++;
          }
          else if(i==10)
          {
            if(five==0)
            {
                return false;
            }
            five--;
            ten++;
          }
          else 
          {
            if(five>0 && ten>0)
            {
                five--;
                ten--;
            }
            else if( five >=3)
            {
                five -=3;
            }
            else 
            {
                return false;
            }
          }

    }
    return true;

        
     }
}
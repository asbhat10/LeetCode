public class Solution {
    public int reverse(int x) {
        int res = 0;
        int temp = 0;
        while(x!=0){
            res = (res*10)+(x%10);
            if(res/10 != temp){
                return 0;
            }
            temp = res;
            x /=10;
            
        }
        return res;
    }
}
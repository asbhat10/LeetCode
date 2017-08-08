public class Solution {
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String huns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thous[] = {"","M","MM","MMM"};
        
        String res = ones[num%10];
        num = num/10;
        res = tens[num%10]+res;
        num = num/10;
        res = huns[num%10]+res;
        num = num/10;
        res = thous[num%10]+res;
        
        return res;
    }
}
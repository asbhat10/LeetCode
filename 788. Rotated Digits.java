class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i =1;i<=N;i++){
            if(isGood(i))
                count++;
        }

        return count;
    }

    private boolean isGood(int n){
        String num = String.valueOf(n);
        if(num.indexOf("3") != -1 || num.indexOf("4") != -1 || num.indexOf("7") != -1 )
            return false;
        //String temp
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<num.length();i++){
            if(num.charAt(i) == '2')
                buf.append('5');
            else if(num.charAt(i) == '5')
                buf.append('2');
            else if(num.charAt(i) == '6')
                buf.append('9');
            else if(num.charAt(i) == '9')
                buf.append('6');
            else{
                buf.append(num.charAt(i));
            }

        }
        return !num.equals(buf.toString());
    }
}

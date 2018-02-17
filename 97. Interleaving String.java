class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
//         //System.out.println(s1+"   "+s2+"   "+s3);
//         int i =0;
//         int j = 0;
//         int k = 0;
//         for(k=0;k<s3.length();){
//             if(i==s1.length() || j== s2.length()){
//                 //System.out.println(i+"   "+j+"   "+k);
//                 break;
                
//             }
                
//             if(s1.charAt(i) != s2.charAt(j)){
//                 if(s3.charAt(k) == s1.charAt(i)){
//                     i++;
//                     k++;
//                     //System.out.println("i if "+i+"   "+j+"   "+k+"   "+s1.substring(i)+"   "+s2.substring(j)+"   "+s3.substring(k+1));
//                 }else if(s3.charAt(k) == s2.charAt(j)){
//                     j++;
//                     k++;
//                     //System.out.println("j if "+i+"   "+j+"   "+k+"   "+s1.substring(i)+"   "+s2.substring(j)+"   "+s3.substring(k+1));
//                 }else{
//                     //System.out.println(i+"   "+j+"   "+k);
//                     return false;
//                 }
                    
//             }else if(s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
//                 if(isInterleave(s1.substring(i),s2.substring(j+1),s3.substring(k+1))){
//                     j++;
//                     k++;
//                     return true;
//                 }else if(isInterleave(s1.substring(i+1),s2.substring(j),s3.substring(k+1))){
//                     k++;
//                     i++;
//                     return true;
//                 }
//                 return false;
                    
//             }else{
//                 return false;
//             }
//         }
        
//         while(i< s1.length() && k<s3.length()){
//             if(s1.charAt(i++) != s3.charAt(k++))
//                 return false;
//         }
        
//         while(j< s2.length() && k<s3.length()){
//             if(s2.charAt(j++) != s3.charAt(k++))
//                 return false;
//         }
//         return true;
        
        boolean[][] dp = new boolean[s2.length()+1][s1.length()+1];
        dp[0][0] = true;
        
        for(int i=1;i<=s1.length();i++){
            dp[0][i] = dp[0][i-1]&&(s1.charAt(i-1) == s3.charAt(i-1));
        }
        for(int i =1;i<=s2.length();i++){
            dp[i][0] = dp[i-1][0]&&(s2.charAt(i-1) == s3.charAt(i-1));
        }
        
        for(int i=1;i<=s2.length();i++){
            for(int j=1;j<=s1.length();j++){
                dp[i][j] = (dp[i-1][j] && (s2.charAt(i-1) == s3.charAt(i+j-1))) ||
                    (dp[i][j-1] && (s1.charAt(j-1) == s3.charAt(i+j-1))) ;
            }
        }
        
        return dp[s2.length()][s1.length()];
    }
}
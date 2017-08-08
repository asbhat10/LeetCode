public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int min = 0;
        int length = 0;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length() < strs[min].length()){
                min = i;
            }else if(strs[i].length() == strs[min].length()){
                length++;
            }
        }
        int index = 0;
        boolean status = true;
        while(index<= strs[min].length() && status){
            int j=0;
            while(j< strs.length){
                if(strs[j].substring(0,index).equals(strs[min].substring(0,index))){
                    j++;
                }else{
                    status = false;
                    break;
                }
            }
            if(status){
                
                index++;
            }
        }
        return strs[min].substring(0,index-1);
    }
}
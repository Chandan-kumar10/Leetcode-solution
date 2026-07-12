class Solution {

    public boolean ispalindrome(String s, int left, int right){

        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(left != right){

                return ispalindrome(s,i+1,j) || ispalindrome(s,i,j-1);

            } else{
                i++;
                j--;
            }
        }
        return true;
        
    }
}
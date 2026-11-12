class Solution {
    public boolean isPalindrome(int x) {

       int digit = x;
       int original = 0;

       while(x > 0){
        int lastdigit = x %10;
        original = original*10 + lastdigit;
        x/=10;

       }

       if( original == digit){
        return true;
       } 
       else {
        return false;
       }

        
        
    }
}
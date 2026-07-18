class Solution {
    public int firstUniqChar(String s) {

        int  n = s.length();

        HashMap<Character, Integer> frequency = new HashMap<>();

        for(int i = 0; i<n; i++){
            Character ch = s.charAt(i);

            frequency.put(ch, frequency.getOrDefault(ch,0) + 1);

        }

        for(int i = 0; i<n; i++){

            Character ch = s.charAt(i);
            if(frequency.get(ch)== 1){
                return i;
            }
        }

        return -1;

            

       

    }
}
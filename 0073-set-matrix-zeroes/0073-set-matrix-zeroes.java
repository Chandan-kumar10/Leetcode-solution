class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int column = matrix[0].length;

        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<column; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<column; j++){
                if(row.contains(i) || col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

        
    }
}
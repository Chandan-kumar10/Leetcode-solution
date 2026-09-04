import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                int lowerLeft = triangle.get(row + 1).get(col);
                int lowerRight = triangle.get(row + 1).get(col + 1);
                int currentVal = triangle.get(row).get(col);
                triangle.get(row).set(col, currentVal + Math.min(lowerLeft, lowerRight));
            }
        }
        return triangle.get(0).get(0);
    }
}
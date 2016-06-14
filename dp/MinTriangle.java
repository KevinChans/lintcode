public class MinTriangle{
    public static void main(String[] args){
        int[][] triangle = new int[][]{
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };
        int result = minimumTotal(triangle);
        System.out.println("result=" + result);
    }

    public static int minimumTotal(int[][] triangle) {
        int n = triangle.length;
        if(n < 2){
            return triangle[0][0];
        }
        for(int i = n-2; i >= 0; i--){
            int len = triangle[i].length;
            for(int j = 0; j < len; j++){
                triangle[i][j] = Math.min(triangle[i + 1][j],triangle[i + 1][j + 1]) + triangle[i][j];        
            }
        }
        return triangle[0][0];
    }
}

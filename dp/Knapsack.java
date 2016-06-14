public class Knapsack{
    public static void main(String[] args){
        int M = 7;
        int[] V = new int[]{
            1,4,5,7
        };
        int[] W = new int[]{
            1,3,4,5
        };
        int max = knapsack(M,V,W);
        System.out.println("max = " + max);
    }

    public static int knapsack(int M,int[] V,int[] W){
        int S = V.length;
        int[][] F = new int[S][M+1];
        for(int i = 0; i < S; i++){
            for(int j = 0; j <= M; j++){
                if(i == 0){
                    if(j >= W[i]){
                        F[i][j] = V[i];
                    }else{
                        F[i][j] = 0;
                    }
                }else{
                    if(j >= W[i]){
                        F[i][j] = Math.max(F[i-1][j],V[i] + F[i-1][j-W[i]]);
                    }else{
                        F[i][j] = F[i-1][j];
                    }
                }
            }
        }
        return F[S-1][M];
    }
}

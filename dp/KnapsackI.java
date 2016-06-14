/**
 * 在n个物品中挑选若干物品装入背包，最多能装多满？
 * 假设背包的大小为m，每个物品的大小为A[i]
 */
public class KnapsackI{
    public static void main(String[] args){
       int m = 8;
       int A[] = new int[]{
           2,4,5,7
       };
       int max = backpack(m,A);
       System.out.println("max = "+max);
    }

    public static int backpack(int m,int A[]){
        int S = A.length;
        int[][] F = new int[S][m+1];
        for(int i = 0; i < S; i++){
            for(int j = 0; j <= m; j++){
                if(i == 0){
                    if(j >= A[i]){
                        F[i][j] = A[i];
                    }else{
                        F[i][j] = 0;
                    }
                }else{
                    if(j >= A[i]){
                        F[i][j] = Math.max(F[i-1][j],A[i] + F[i-1][j-A[i]]);
                    }else{
                        F[i][j] = F[i-1][j];
                    }
                }
            }
        }
        return F[S-1][m];
    }
}

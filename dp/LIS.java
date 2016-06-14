public class LIS{
    public static void main(String[] args){
        int[] A = new int[]{
            4,2,5,-1,6,9,3,10
        };
        int longest = LIS(A);
        System.out.println("longest="+longest);
    }

    public static int LIS(int[] A){
        int N = A.length;
        if(N == 1)
            return 1;
        int[] F = new int[N];
        for(int i = 1; i < N; i++){
            F[i] = 1;
            for(int j = 0; j <= i - 1; j++){
                if(A[i] > A[j]){
                    F[i] = Math.max(F[i],F[j] + 1);
                }
            }
        }
        int max = F[0];
        for(int k = 1; k < N; k++){
            if(max < F[k]){
                max = F[k];
            }
        }
        return max;
    }
}

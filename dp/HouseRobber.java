public class HouseRobber{
    public static void main(String[] args){
        int[]  A = new int[]{
            2,4,3,5,1,7,9
        };
        long result = houseRobber(A);
        System.out.println("result="+result);
    }
    public static long houseRobber(int[] A){
        int len = A.length;
        long[] B = new long[len];
        if(len == 2){
            return Math.max(A[0],A[1]);
        }
        for(int x = 0;x <= 2 && x < len;x++){
            B[x] = A[x];
        }
        for(int i = 2; i < len; i++){
            B[i] = Math.max(B[i-1],A[i] + B[i-2]);
        }
        return len == 0 ? 0 : B[len-1];
    }
}

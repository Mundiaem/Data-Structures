package Binary;

public class test {
    public static void main(String[] args) {
        shift(25);
    }
    private static void shift(int n){
        StringBuilder sb= new StringBuilder();
        int  zeroBit =0;
//        while(n!=0){
//            int r = (n & 1);
//            if(r == 0) zeroBit++;
//            sb.append(r);
//            //System.out.println(r);
//            n >>=1;
//
//            // System.out.println(n);
//        }
        // conversion of the int to binary
        int mask= 1<< 31;
        for(int i=0; i<32; i++){
            int binary = (n & mask)!= 0? 1:0;
            sb.append(binary);
            n <<=1;
        }

         System.out.println();

        System.out.println(sb.toString());
        System.out.println((long)Math.pow(2, zeroBit));

    }
}

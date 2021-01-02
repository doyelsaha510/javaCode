public class BitsManipulation {
    public static void main(String[] args) {
        int x=32;
        /*int i;
        int num = 0xFFFFFFE;
        num=31;
        System.out.println(num);
        for(i=0; i<4; i++) {
            num = num >> 1;
            System.out.println(num);
        }*/
        for (int i = 31; i >= 0; i--) {
            if ((x & (1 << i)) != 0) {
                System.out.print( "1");
            } else {
                System.out.print( "0");
            }
        }
    }
}

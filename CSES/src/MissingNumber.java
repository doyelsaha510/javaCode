import java.io.IOException;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String args[]) throws IOException {

        //write your code here
        Scanner sc=new Scanner(System.in);
        int n,a[];
            n=sc.nextInt();
            a=new int[n];
            for(int i=0;i<n-1;i++)
            {
                a[i]=sc.nextInt();
            }
            int miss=a.length;
            for (int i = 0; i < a.length; i++) {
                miss ^= i ^ a[i];
            }
            System.out.println(miss);

    }
}

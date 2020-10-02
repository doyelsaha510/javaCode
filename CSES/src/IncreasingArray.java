import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        long count=0;
        long diff=0;
        for(int i=0,j=i+1;i<n &j<n;i++){
            diff=Math.abs(arr[i]-arr[j]);
            //System.out.println("in for i "+i+"j "+j);
            //System.out.println("diff "+diff);

            if(arr[i]>arr[j] && j<n) {
                //System.out.println("in if i "+i+"j "+j);
                count += diff ;
                arr[j]=arr[j]+diff;

                /*for(int k=0;k<n;k++)
                {
                    System.out.print(arr[k]+" ");
                }
                System.out.println();*/
            }
            j++;



        }

        System.out.println(count);

    }
}

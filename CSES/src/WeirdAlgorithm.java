import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long input=sc.nextLong();
        while (true){
            System.out.print(input+" ");
            if (input==1) break;
            if(input%2==0) input=input/2;
            else input=input*3+1;
        }
    }

}

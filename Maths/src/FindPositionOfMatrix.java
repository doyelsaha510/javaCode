import java.util.Scanner;

/*https://mycode.prepbytes.com/contest/PRIMETIMEAUGUST20/problems/GTMC1*/
public class FindPositionOfMatrix {
    static long maxPrimeFactors(long n)
    {
        // Initialize the maximum prime
        // factor variable with the
        // lowest one
        long maxPrime = -1;

        // Print the number of 2s
        // that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point,
        // thus skip the even numbers
        // and iterate only for odd
        // integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;
    }
    static long printLoc(long m,long n,long x,long y){
        long loc;
        loc=((y-1)*m)+x;//(y-1)*m calculates the how many previous column elements are printed
        //+ x means here x-1+1 where x-1 is present columns element and +1 because of that locations element
        return loc;
    }

    public static void main(String[] args) {
        long t,m,n,x,y,a,b=0,c;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while (t>0){
            m=sc.nextInt();
            n=sc.nextInt();
            x=sc.nextInt();
            y=sc.nextInt();
            a=printLoc(m,n,x,y);
            b=maxPrimeFactors(a);
            System.out.println(b);
            t--;
        }
    }

}

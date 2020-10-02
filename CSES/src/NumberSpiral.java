import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class NumberSpiral {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        while (t>0) {
            long y = sc.nextInt();
            long x = sc.nextInt();
            long a=Math.max(y,x);
            long b=Math.min(y,x);
            long s= ((a - 1) * (a - 1));
            if(a==b)
                s+=a;
            else if(a%2!=0){
                if(x==a)
                    s+=a*2-y;
                else
                    s+=x;
            }
            else {
                if(y==a)
                    s+=a*2-x;
                else
                    s+=y;
            }
            System.out.println(s);
            t--;
        }

    }
}

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        if (n == 1) {
            System.out.print("1");
        } else if (n < 4) {
            System.out.print("NO SOLUTION");
        } else if (n == 4) {
            System.out.print("2 4 1 3");
        } else {
            // print evens
            for (int i = 1; i <= n; i += 2) {
                System.out.print(i + " ");
            }
            // print odds
            for (int i = 2; i <= n; i += 2) {
                System.out.print(i + " ");
                if (i < n - 1) System.out.println(" ");
                else System.out.println();
                ;
            }

        }
    }
}
/*Time limit exceeded in java but not in c++
#include <iostream>

using namespace std;

int main() {
  int n;
  cin >> n;
  if (n == 1) cout << "1\n";
  else if (n < 4) cout << "NO SOLUTION\n";
  else if (n == 4) cout << "3 1 4 2\n";
  else {
    for (int i = 1; i <= n; i += 2) cout << i << " ";
    for (int i = 2; i <= n; i += 2) {
      cout << i;
      if (i < n - 1) cout << " ";
      else cout << endl;
    }
  }
}
*/

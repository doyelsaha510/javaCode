
import java.util.Scanner;

public class Repetitions {
    static int largestSequence = 0;
    static char longestChar = '\0';
    public static void main(String[] args) {
        int currentSequence = 1;
        char current = '\0';
        char next = '\0';
        Scanner sc=new Scanner(System.in);
        String seq=sc.next();

        for (int i = 0; i < seq.length() - 1; i++) {
            current = seq.charAt(i);
            next = seq.charAt(i + 1);

            // If character's are in sequence , increase the counter
            if (current == next) {
                currentSequence += 1;
            } else {
                if (currentSequence > largestSequence) { // When sequence is completed, check if it is longest
                    largestSequence = currentSequence;
                    longestChar = current;
                }
                currentSequence = 1; // re-initialize counter
            }
        }
        if (currentSequence > largestSequence) { // Check if last string
            // sequence is longest
            largestSequence = currentSequence;
            longestChar = current;
        }
        System.out.println(largestSequence);
        //System.out.println("Longest character sequence is of character "+ longestChar + " and is " + largestSequence + " long");
    }

    //HashMap<Character, Integer> map=new HashMap<>();
/*        int[] arr=new int[4];
        Scanner sc=new Scanner(System.in);
        String seq=sc.next();
        int max= Integer.MIN_VALUE;
        int i=0,j=i+1;

        int count=1;
        while(i<seq.length()){
            if(seq.charAt(i)==seq.charAt(j)) {
                j++;
                count++;
            }else
                i++;



        }
        System.out.println(count);*/
    }

/*switch (seq.charAt(i)){
                case 'A':
                    arr[0]+=1;
                    if(arr[0]>max)
                        max=arr[0];
                    break;
                case 'T':
                    arr[1]+=1;
                    break;
                case 'C':
                    arr[2]+=1;
                    break;
                case 'G':
                    arr[3]+=1;
                    break;
            }*/
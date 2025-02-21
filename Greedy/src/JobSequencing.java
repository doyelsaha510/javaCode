
// Program to find the maximum profit
// job sequence from a given array
// of jobs with deadlines and profits
import java.util.*;
/*Sort all jobs in decreasing order of profit.
Initialize the result sequence as first job in sorted jobs.
Do following for remaining n-1 jobs
If the current job can fit in the current result sequence without missing the deadline, add current job to the result. Else ignore the current job.*/
class Job {

    // Each job has a unique-id,
// profit and deadline
    char id;
    int deadline, profit;

    // Constructors
    public Job() {
    }

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    // Function to schedule the jobs take 2
// arguments arraylist and no of jobs to schedule
    void printJobScheduling(ArrayList<Job> arr, int t) {

        // Length of array
        int n = arr.size();

        // Sort all jobs according to
        // decreasing order of profit
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr.get(j).profit <
                        arr.get(j + 1).profit) {
                    Job temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }

        // To keep track of free time slots
        boolean result[] = new boolean[t];

        // To store result (Sequence of jobs)
        char job[] = new char[t];

        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {

            // Find a free slot for this job
            // (Note that we start from the
            // last possible slot)
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {

                // Free slot found
                if (result[j] == false) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        // Print the sequence
        for (char jb : job) {
            System.out.print(jb + " ");
        }
        System.out.println();
    }
}
public class JobSequencing {
    // Driver code
    public static void main(String args[]) {
        ArrayList<Job> arr = new ArrayList<Job>();

        arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));

        System.out.println("Following is maximum " +
                "profit sequence of jobs");

        Job job = new Job();

        // Calling function
        job.printJobScheduling(arr, 3);
    }

}



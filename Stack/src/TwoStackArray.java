import java.util.Scanner;

public class TwoStackArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Array input :");
        int n=sc.nextInt();
        StackArray stackArray=new StackArray(n);
        System.out.println("Stack1 size :");
        int stack1=sc.nextInt();
        System.out.println("Stack2 size :");
        int stack2=sc.nextInt();
        int element;
        for(int i=0;i<stack1;i++){
            element=sc.nextInt();
            stackArray.push1(element);
        }
        System.out.println("Stack 1 : ");
        stackArray.printStackArray1();
        for(int i=0;i<stack2;i++){
            element=sc.nextInt();
            stackArray.push2(element);
        }
        System.out.println("Stack 2 : ");
        stackArray.printStackArray2();

        stackArray.push1(23);
        int num=stackArray.top1+1;
        while(num!=0){
            stackArray.pop1();
            num--;
        }
        stackArray.pop1();
        int num2=stackArray.top2;
        while(num2<stackArray.size){
            stackArray.pop2();
            num2++;
        }
        stackArray.pop2();
    }
}
class StackArray{
    public int size;
    public int top1,top2;
    public int arr[];

    StackArray(int n){
        arr=new int[n];
        size=n;
        top1=-1;
        top2=size;
    }
    void push1(int data){
        if(top1<top2-1){
            arr[++top1]=data;
            System.out.println("pushed in stack1 "+data);
        }
        else{
            System.out.println("Stack1 Overflow");
        }
    }
    void push2(int data){
        if(top1<top2-1){
            arr[--top2]=data;
            System.out.println("pushed in stack2 "+data);
        }
        else{
            System.out.println("Stack2 Overflow");
        }
    }
    void pop1(){
        if(top1>-1){
            int poppedEleFrmStack1=arr[top1--];
            System.out.println("poppedEleFrmStack1 : "+poppedEleFrmStack1);
        }
        else{
            System.out.println("Stack1 Underflow");
        }
    }

    void pop2(){
        if(top2<size){
            int poppedEleFrmStack2=arr[top2++];
            System.out.println("poppedEleFrmStack2 : "+poppedEleFrmStack2);
        }
        else{
            System.out.println("Stack2 Underflow");
        }
    }
    void printStackArray1(){
        for (int i = top1; i >= 0; i--) {
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }
    void printStackArray2(){
        for (int i = top2; i < size; i++) {
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }


}
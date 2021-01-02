import java.util.*;
/*
* Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.*/
public class FindOdd {
    public static int findIt(int[] a) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int odd=a[0];
        for (int value : a) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
                if (map.get(value) % 2 != 0) odd = value;
            } else {
                map.put(value, 1);
            }
        }
        System.out.println(map);
        return odd;
    }

    public static void main(String[] args) {
        int a[]={2,3,3,3,1,2,1,8,8,8,8,8,3};
        System.out.println(findIt(a));
    }
}
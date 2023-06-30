import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static public int fibonacci(int n) {

        int[] feb_arr = new int[40];
        int num1=0 ,num2=1;
        for(int i=0;i<40;i++){
            if(i==0 || i==1){
                feb_arr[i]=i;
            }
            else {

                feb_arr[i]=num1 +num2;
                num1=num2;
                num2=feb_arr[i];
            }

        }



        return feb_arr[n-1];



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}
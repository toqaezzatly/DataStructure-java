import java.util.Scanner;

class Solution {
    public int[] sumEvenOdd(int[] array) {
        int sumEven=0;
        int sumOdd=0;
        int []sum;
        sum=new int[2];

        for(int i = 0; i < array.length; ++i) {
            if (array[i]%2==0)
                sumEven=sumEven+array[i];
            else
                sumOdd=sumOdd+array[i];
        }

        sum[0]=sumEven;sum[1]=sumOdd;

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");

        String[] s = sin.split(", ");
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
                arr[i] = Integer.parseInt(s[i]);
        }
        int[] res = new Solution().sumEvenOdd(arr);
        System.out.print("[");
        for(int i = 0; i < res.length; ++i) {
            System.out.print(res[i]);
            if(i != s.length - 1)
                System.out.print(", ");
        }
        System.out.print("]");

    }
}
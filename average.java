import java.util.Scanner;

class Solution {
    public double average(int[] array) {
        int sum=0;
        double aver;

        for(int i = 0; i < array.length; ++i) {
            sum=sum+array[i];

        }
        aver=sum/ array.length;
        return aver;

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
        System.out.println(new Solution().average(arr)) ;

    }
}
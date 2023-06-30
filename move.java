import java.util.Scanner;


     class Solution {
        public int[] moveValue(int[] array, int value) {
            int counter=0,c=0 ,i = 0;


            int [] temp = new int[array.length-counter];

            for( i = 0; i < array.length; i++) {
                if (array[i]!=value){
                    temp[c++]=array[i];
                }
            }
            for( i = c; i < temp.length; i++){
                temp[i]=value ;

            }
                return temp;
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
            int value= sc.nextInt();
            int[] res = new Solution().moveValue(arr,value);
            System.out.print("[");
            for(int i = 0; i < res.length; ++i) {
                System.out.print(res[i]);
                if(i != s.length - 1)
                    System.out.print(", ");
            }
            System.out.print("]");

        }
    }


import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] array=new int[2][2];
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();


            for (int i=0; i<2;i++)
            {
                char ch=str.charAt(2);
                if(ch ==']'){
                    System.out.println("[[]]");
                    break;
                }

                else
                {
                    for(int j =0;j<2;j++){
                    array[i][j]=sc.nextInt();
                    String str1= sc.nextLine();
                }

            }
            String str3= sc.nextLine();

        }
        for (int i=0; i<2;i++)
        {
            for(int j =0;j<2;j++){
                System.out.println(array[i][j]+",");
            }
            System.out.println("]");


        }
        System.out.println("]");
    }
}
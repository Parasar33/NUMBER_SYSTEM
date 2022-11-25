import java.util.Scanner;

public class main_code
{
    static String number_from;
    static String number_to;
    static int nof_decimal , nof_binary , nof_octal;
    static String nof_hexadecimal;
    public static void main(String[] args) {
        System.out.print("Enter the number to convert from -> ");
        Scanner sc1 = new Scanner(System.in);
         number_from = sc1.nextLine();
        System.out.print("Enter the number to convert to -> ");
         number_to = sc1.nextLine();
        Scanner sc2 = new Scanner(System.in);
         switch (number_from)
        {
            case "decimal" :
            {
                System.out.print("Enter the number in decimal -> ");
                nof_decimal = sc2.nextInt();
                conversion_decimal(number_from,number_to,nof_binary);
                break;
            }
            case "binary" :
            {
                System.out.print("Enter the number in binary -> ");
                nof_binary = sc2.nextInt();
                CheckNumberisBinary(nof_binary);
                break;
            }
            case "octal" :
            {
                System.out.print("Enter the number in octal -> ");
                nof_octal = sc2.nextInt();
                conversion_binary(number_from,number_to,nof_octal);
                break;
            }
            case "hexadecimal" :
            {
                System.out.print("Enter the number in hexadecimal -> ");
                nof_hexadecimal = sc2.nextLine();
                conversion_binary(number_from,number_to,nof_binary);
                break;
            }
            default :
                System.out.println("Enter correct type of Number ");
        }
    }
    static void CheckNumberisBinary(int num)
    {
            int r=0,c=0,b;
            b= num;
            while(num>0)
            {
                if((num %10==0)|| (num%10==1))
                    c++;
                r++;
                num=num/10;
            }
            if(c==r)
                conversion_binary(number_from,number_to,nof_binary);
            else
                System.exit(0);
    }
    //I am going to make a program that performs conversion between different number system
    static void conversion_binary(String n_binary ,String n_to ,int no_from)
    {
        switch (n_to)
        {
            case "decimal" :
            {
                System.out.println("hello, i am working");
            }
            case "octal" :
            {

            }
            case "hexadecimal" :
            {

            }
        }
    }
    static void conversion_decimal(String n_binary ,String n_to ,int no_from)
    {
        switch (n_to)
        {
            case "decimal" :
            {

            }
            case "octal" :
            {

            }
            case "hexadecimal" :
            {

            }
        }
    }
}

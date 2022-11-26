import java.util.Scanner;

public class main_code {
    static String number_from;
    static String number_to;
    static int nof_decimal, nof_binary, nof_octal;
    static String nof_hexadecimal;

    public static void main(String[] args) {
        System.out.print("Enter the number to convert from -> ");
        Scanner sc1 = new Scanner(System.in);
        number_from = sc1.nextLine();
        System.out.print("Enter the number to convert to -> ");
        number_to = sc1.nextLine();
        Scanner sc2 = new Scanner(System.in);
        switch (number_from) {
            case "decimal": {
                System.out.print("Enter the number in decimal -> ");
                nof_decimal = sc2.nextInt();
                conversion_decimal(number_to, nof_decimal);
                break;
            }
            case "binary": {
                System.out.print("Enter the number in binary -> ");
                nof_binary = sc2.nextInt();
                CheckNumberisBinary(nof_binary);
                break; //this process is done using CheckNumberisBinary method used below
            }
            case "octal": {
                System.out.print("Enter the number in octal -> ");
                nof_octal = sc2.nextInt();
                conversion_binary(number_to, nof_octal);
                break;
            }
            case "hexadecimal": {
                System.out.print("Enter the number in hexadecimal -> ");
                nof_hexadecimal = sc2.nextLine();
                conversion_binary(number_to, nof_binary);
                break;
            }
            default:
                System.out.println("Enter correct type of Number ");
        }
    }

    static void CheckNumberisBinary(int num) {
        int r = 0, c = 0, b;
        b = num;
        while (num > 0) {
            if ((num % 10 == 0) || (num % 10 == 1))
                c++;
            r++;
            num = num / 10;
        }
        if (c == r)
            conversion_binary(number_to, nof_binary);
        else
            System.exit(0);
    }

    //I am going to make a program that performs conversion between different number system
    //BINARY CODING STARTS HERE
    static void conversion_binary(String n_to, int no_from) {
        switch (n_to) {
            case "decimal": {
                BinarytoDecimal(no_from);
                break;
            }
            case "octal":
            {
                BinarytoOctal(no_from);
                break;
            }
            case "hexadecimal":
            {
                BinarytoHexadecimal(no_from);
            }
        }
    }
    //binary to decimal started
    public static void BinarytoDecimal(int binary) {
        int decimal = 0;
        int n = 0;
        System.out.print("Decimal conversion of ("+binary+")2");
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }
        System.out.print(" is ("+decimal+")10");
    }
    //binary to decimal done
    //binary to octal started
    public static void BinarytoOctal(int binary)
    {
        int octal = 0, decimal = 0, i = 0;
        System.out.print("Octal conversion of ("+binary+")2");
        while (binary != 0) {
            decimal += (binary % 10) * Math.pow(2, i);
            ++i;
            binary /= 10;
        }

        i = 1;

        while (decimal != 0) {
            octal += (decimal % 8) * i;
            decimal /= 8;
            i *= 10;
        }
        System.out.print(" is ("+octal+")8");
    }
    //binary to octal done
    //binary to hexadecimal started
    public static void BinarytoHexadecimal(int binary)
    {
        int decimal = 0, i = 0;
        System.out.print("Hexa-Decimal conversion of ("+binary+")2");
        while (binary > 0)
        {
            decimal += Math.pow(2, i++) * (binary % 10);
            binary /= 10;
        }
        char arr[] = { 'A', 'B', 'C', 'D', 'E', 'F' };
        int remainder;
        String hex = "";
        while (decimal != 0) {
            remainder = decimal % 16;
            if (remainder >= 10)
                hex = arr[remainder - 10] + hex;
            else
                hex = remainder + hex;
            decimal /= 16;
        }
        System.out.print(" is ("+hex+")16");
    }
    //binary to hexa_decimal done
    //BINARY DONE
    //DECIMAL STARTED
    static void conversion_decimal(String n_to, int no_from)
    {
        switch (n_to)
        {
            case "binary":
            {
                DecimaltoBinary(no_from);
                break;
            }
            case "octal":
            {
                DecimaltoOctal(no_from);
                break;
            }
            case "hexadecimal":
            {
                DecimaltoHexadecimal(no_from);
            }
        }
    }
    //decimal to binary started
    public static void DecimaltoBinary(int decimal){
        int bin[] = new int[40];
        int index = 0;
        System.out.print("Binary conversion of ("+decimal+")10"+" is (");
        while(decimal > 0)
        {
            bin[index++] = decimal%2;
            decimal = decimal/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(bin[i]);
        }
        System.out.print(")2");
    }
    //decimal to binary done
    //decimal to octal started
    public static void DecimaltoOctal(int decimal)
    {
        int remainder;
        String octal="";
        System.out.print("Octal conversion of ("+decimal+")10");
        char octalnos[]={'0','1','2','3','4','5','6','7'};
        while(decimal>0)
        {
            remainder=decimal%8;
            octal=octalnos[remainder]+octal;
            decimal=decimal/8;
        }
        System.out.println(" is ("+octal+")8");
    }
    //decimal to octal done
    //decimal to hexa_decimal started
    public static void DecimaltoHexadecimal(int decimal){
        int remainder;
        String hex="";
        System.out.print("Hexa-Decimal conversion of ("+decimal+")10");
        char hexnos[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            remainder=decimal%16;
            hex=hexnos[remainder]+hex;
            decimal=decimal/16;
        }
        System.out.println(" is ("+hex+")8");
    }
}
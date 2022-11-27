import java.util.Scanner;

public class main_code {
    static String number_from;
    static String number_to;
    static int nof_decimal, nof_binary, nof_octal , number_to_int , number_to_from;
    static String nof_hexadecimal;

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println(" WELCOME TO NUMBER SYSTEM CONVERTOR");
        System.out.println("We convert between\n1.Binary\n2.Decimal\n3.Octal\n4.Hexa-Decimal");
        System.out.println("************************************");
        System.out.print("Enter the number to convert from -> ");
        number_to_from = sc1.nextInt();
        switch (number_to_from)
        {
            case 1:number_from ="binary";break;
            case 2:number_from ="decimal";break;
            case 3:number_from ="octal";break;
            case 4:number_from ="hexadecimal";break;
            default: System.out.println("Enter correct number choice ");System.exit(0);
        }
        System.out.print("Enter the number to convert to -> ");
        number_to_int = sc1.nextInt();
        switch (number_to_int)
        {
            case 1:number_to ="binary";break;
            case 2:number_to ="decimal";break;
            case 3:number_to ="octal";break;
            case 4:number_to ="hexadecimal";break;
            default: System.out.println("Enter correct number choice ");System.exit(0);
        }
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
                conversion_octal(number_to, nof_octal);
                break;
            }
            case "hexadecimal": {
                System.out.print("Enter the number in hexadecimal -> ");
                nof_hexadecimal = sc2.nextLine();
                conversion_hexadecimal(number_to, nof_hexadecimal);
                break;
            }
        }
        System.out.println("\n************************************\n________thanks From Rishav :)");
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
        System.out.println(" is ("+hex+")16");
    }
    //decimal to hexa_decimal done
    //DECIMAL DONE
    //OCTAL STARTED
    static void conversion_octal(String n_to, int no_from)
    {
        switch (n_to)
        {
            case "binary":
            {
                OctaltoBinary(no_from);
                break;
            }
            case "decimal":
            {
                OctaltoDecimal(no_from);
                break;
            }
            case "hexadecimal":
            {
                OctaltoHexadecimal(no_from);
                break;
            }
        }
    }
    //octal to binary started
    public static void OctaltoBinary(int octal)
    {
        int i = 0;
        int decimal = 0;
        int binary = 0;
        System.out.print("Binary conversion of ("+octal+")8");
        while (octal != 0) {
            decimal += (octal % 10) * Math.pow(8, i);
            ++i;
            octal /= 10;
        }
        i = 1;
        while (decimal != 0) {
            binary += (decimal % 2) * i;
            decimal /= 2;
            i *= 10;
        }
        System.out.println(" is ("+binary+")2");
    }
    //octal to binary done
    //octal to decimal started
    public static void OctaltoDecimal(int octal)
    {
        int i = 0;
        int decimal = 0;
        System.out.print("Decimal conversion of (" + octal + ")8");
        while (octal != 0) {
            decimal += (octal % 10) * Math.pow(8, i);
            ++i;
            octal /= 10;
        }
        System.out.println(" is ("+decimal+")10");
    }
    //octal to decimal done
    //octal to hexa-decimal started
    public static void OctaltoHexadecimal(int octal){
        int k = 0;
        int decimal = 0;
        System.out.print("Hexa-Decimal conversion of ("+octal+")10");
        while (octal != 0) {
            decimal += (octal % 10) * Math.pow(8, k);
            ++k;
            octal /= 10;
        }
        int remainder;
        String hex="";
        char hexnos[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(decimal>0)
        {
            remainder=decimal%16;
            hex=hexnos[remainder]+hex;
            decimal=decimal/16;
        }
        System.out.println(" is ("+hex+")16");
    }
    //octal to hexa_decimal done
    //OCTAL DONE
    //HEXA-DECIMAL STARTED
    static void conversion_hexadecimal(String n_to, String no_from)
    {
        switch (n_to)
        {
            case "binary":
            {
                HexadecimaltoBinary(no_from);
                break;
            }
            case "decimal":
            {
                HexadecimaltoDecimal(no_from);
                break;
            }
            case "octal":
            {
                HexadecimaltoOctal(no_from);
                break;
            }
        }
    }
    //hexa-decimal to binary started
    public static void HexadecimaltoBinary(String hexadecimal)
    {
        int i=0, len;
        len = hexadecimal.length();
        System.out.print("Binary conversion of ("+hexadecimal+")16 is (");
        char[] hexDigit = hexadecimal.toCharArray();
        while(i<len)
        {
            switch(hexDigit[i])
            {
                case '0': System.out.print("0000");break;
                case '1': System.out.print("0001");break;
                case '2': System.out.print("0010");break;
                case '3': System.out.print("0011");break;
                case '4': System.out.print("0100");break;
                case '5': System.out.print("0101");break;
                case '6': System.out.print("0110");break;
                case '7': System.out.print("0111");break;
                case '8': System.out.print("1000");break;
                case '9': System.out.print("1001");break;
                case 'a': case 'A': System.out.print("1010");break;
                case 'b': case 'B': System.out.print("1011");break;
                case 'c': case 'C': System.out.print("1100");break;
                case 'd': case 'D': System.out.print("1101");break;
                case 'e': case 'E': System.out.print("1110");break;
                case 'f': case 'F': System.out.print("1111");break;
                default: System.out.println("Invalid Hexadecimal Digit!");
                    return;
            }
            i++;
        }
        System.out.print(")2");
    }
    //hexa-decimal to binary done
    //hexa-decimal to decimal started
    public static void HexadecimaltoDecimal(String hexadecimal){
        String digits = "0123456789ABCDEF";
        System.out.print("Decimal conversion of ("+hexadecimal+")16");
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++)
        {
            char c = hexadecimal.charAt(i);
            int d = digits.indexOf(c);
            decimal = 16*decimal + d;
        }
        System.out.println(" is ("+decimal+")10");
    }
    //hexa-decimal to decimal done
    //hexa-decimal to octal started
    public static void HexadecimaltoOctal(String hexadecimal)
    {
        String digits = "0123456789ABCDEF";
        System.out.print("Octal conversion of ("+hexadecimal+")16");
        hexadecimal = hexadecimal.toUpperCase();
        int decimal = 0;
        for (int i = 0; i < hexadecimal.length(); i++)
        {
            char c = hexadecimal.charAt(i);
            int d = digits.indexOf(c);
            decimal = 16*decimal + d;
        }
        int remainder;
        String octal="";
        char octalnos[]={'0','1','2','3','4','5','6','7'};
        while(decimal>0)
        {
            remainder=decimal%8;
            octal=octalnos[remainder]+octal;
            decimal=decimal/8;
        }
        System.out.println(" is ("+octal+")8");
    }
    //hexa-decimal to octal done
    //HEXA-DECIMAL DONE
}
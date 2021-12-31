/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;
import java.math.BigInteger; 
/**
 *
 * @author huany
 */
import java.util.Scanner;

public class BaseConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter in what base you want to convert to Decimal");
        String base = input.nextLine();
        System.out.println("Please enter in number to be converted");
        String num = input.nextLine();
        BigInteger result = BaseToDec(num, base);
        System.out.println(result);
        
        System.out.println("Please enter what base you want to convert decimal to");
        String base1= input.nextLine(); 
        System.out.println("Please enter in number to be converted");
     String   num1= input.nextLine();
     String result1= decToBase(num1,base1); 
        System.out.println(result1);
    }

    static BigInteger BaseToDec(String input, String base) {
        int a = input.toString().length(); 
        String digits[] = new String[a];
        int IntDigits[] = new int[a];
        for (int i = 0; i < a; i++) {
            digits[i] = input.substring(i, i + 1);
        }
        for (int i = 0; i < a; i++) {
            if (Character.isLetter(input.charAt(i)) == true) {
                char b;
                b = input.charAt(i);
                int c = b - 55;
                IntDigits[i] = c;

            } else {
                IntDigits[i] = Integer.parseInt(digits[i]);
            }
        }
        BigInteger result1 = BigInteger.valueOf(0);
        BigInteger BigBase= BigInteger.valueOf(0);
       BigBase= BigBase.add(new BigInteger(base));
        for (int i = 0; i <a; i++) {
            result1=result1.add( BigBase.pow(a - i - 1).multiply(BigInteger.valueOf(IntDigits[i])));
        }
        return result1;
    }
    static int findLength(BigInteger b,BigInteger base){
    int i =0; 
        while(true){
          if(base.pow(i).compareTo(b)>0){
         
              break;
          }
          else{
              i++; 
          }
       }
        return i; 
    }
    static String decToBase(String num1, String base1){
        BigInteger base= BigInteger.valueOf(0);
         base= base.add(new BigInteger(base1));
          BigInteger num= BigInteger.valueOf(0);
         num= num.add(new BigInteger(num1));
        String result="";  
        int length= findLength(num, base); 
        for(int i1=1; i1<=length; i1++){
            BigInteger a1 = num.divide(base.pow(length-i1)); 
            int a = a1.intValue(); 
            if(a>9){
                char e= (char)a; 
                e+=55; 
                result+=e; 
            }
            else{
            result+=Integer.toString(a); 
            }
            num= num.subtract(a1.multiply(base.pow(length-i1))); 
        }
        return result; 
    }
}

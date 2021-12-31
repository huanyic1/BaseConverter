/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;

/**
 *
 * @author huany
 */
import java.util.Scanner;

public class IntBaseConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter in what base you want to convert to Decimal");
        int base = input.nextInt();
         input.skip("\n"); 
        System.out.println("Please enter in number to be converted");
        String num = input.nextLine();
     
        String result = BaseToDec(num, base);
        System.out.println(result);
        
        System.out.println("Please enter what base you want to convert decimal to");
        int base1= input.nextInt(); 
        System.out.println("Please enter in number to be converted");
      int   num1= input.nextInt();
      String result1= decToBase(num1,base1); 
        System.out.println(result1);
    }

    static String BaseToDec(String input, int base) {
       
        int a = input.length();
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
        int result = 0;
        for (int i = 0; i < a; i++) {
            result += IntDigits[i] * Math.pow(base, a - i - 1);
        }

        String n = Integer.toString(result);

        return n;
    }
    static int findLength(int b,int base){
      int  i  =0; 
        while(true){
          if(Math.pow(base, i)>b){
         
              break;
          }
          else{
              i++; 
          }
       }
        return i; 
    }
    static String decToBase(int num, int base){
        String result="";  
        int length= findLength(num, base); 
        for(int i1=1; i1<=length; i1++){
            int a = (int) (num  / Math.pow(base, length-i1)); 
            if(a>9){
                char e= (char)a; 
                e+=55; 
                result+=e; 
            }
            else{
            result+=Integer.toString(a); 
            }
            num=(int) (num-a*Math.pow(base, length-i1)); 
        }
        return result; 
    }
}



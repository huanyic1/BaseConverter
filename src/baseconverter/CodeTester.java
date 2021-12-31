/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author huany
 */
public class CodeTester {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
          BigInteger a1= BigInteger.valueOf(16);
String a = a1.toString();
        System.out.println(a);
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
}

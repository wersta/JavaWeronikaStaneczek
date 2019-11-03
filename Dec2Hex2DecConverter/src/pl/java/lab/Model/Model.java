/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.lab.Model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * It's a class that is responsible for program logic. It converts hexadecimal numebrs to decimal numbers 
 * and decimal numbers to hexadecimal numbers. The data is stored and processed here. 
 * 
 * @author Weronika Staneczek
 * @version 1.0
 */


public class Model {
    
    /**
     * Variable storing decimal number
     */
    private int decimalNumber;
    
     /**
     * Variable storing hexadecimal number
     */
    private String hexadecimalNumber;
     
     /**
      * Constructor wtih no parameters
      */
    public Model()
    {
        decimalNumber=0;
        hexadecimalNumber="";
    }
    
    /**
     * Get method for variable decimalNumber
     * 
     * @return decimalNumber
     */
    public int getDecimalNumber() 
    { 
        return decimalNumber; 
    }
       /**
     * Get method for variable hexadecimalNumber
     * 
     * @return decimalNumber
     */
    public String getHexadecimalNumber() { 
        return hexadecimalNumber; 
    }
    
    /**
     * Set method for variable decimalNumber
     * 
     * @param decimalNumber number to put in decimalNumber variable
     */
    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
    
   /**
     * Set method for variable hexadecimalNumber
     * 
     * @param hexadecimalNumber number to put in hexadecimalNumber variable
     */
    public void setHexadecimalNumber(String hexadecimalNumber) {
        this.hexadecimalNumber = hexadecimalNumber;
    }
    
 
   /**
    * This method converts hexadecimal number to decimal number
    * @param hexadecimalNumber number to convert into decimal number
    * @return decimal number
    */
    
    public int convertHex2Dec(String hexadecimalNumber)
    {
    String digits = "0123456789ABCDEF";  
    hexadecimalNumber = hexadecimalNumber.toUpperCase();  
    decimalNumber = 0;  
        for (int i = 0; i < hexadecimalNumber.length(); i++)  
        {  
            char singleCharacter = hexadecimalNumber.charAt(i);  
            int digit = digits.indexOf(singleCharacter);  
            decimalNumber = 16*decimalNumber + digit;  
        }  
    return decimalNumber;  
    }
    
    /**
     * This method converts decimal number to hexadecimal number
     * @param decimalNumber number to convert into hexadecimal number
     * @return hexadecimal number
     */
    
    public String convertDec2Hex(int decimalNumber)
    {
    int rem;  
    hexadecimalNumber="";   
    char hexChars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
        while(decimalNumber>0)  
        {  
            rem=decimalNumber%16;   
            hexadecimalNumber=hexChars[rem]+hexadecimalNumber;   
            decimalNumber=decimalNumber/16;  
        }  
    return hexadecimalNumber;  
    }
    
    /**
     * This method is responsible for checking if the inuput data is a correct hexadecimal number
     * @param hexNumber the number to check
     * @throws BadInputData when the hexNumber is not correct
     */
    public void hexadecimalChecker (String hexNumber) throws BadInputData
    {
    Pattern expression =Pattern.compile("[0-9A-F]+");
    Matcher matcher = expression.matcher(hexNumber);
    
     if (!matcher.find()) throw new BadInputData(hexNumber);
    }
   
}

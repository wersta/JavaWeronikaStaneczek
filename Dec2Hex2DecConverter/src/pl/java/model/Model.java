/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.model;
import java.util.ArrayList;
import java.util.List;
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
    *Store history of calculation
    */
    List<String>calculationHistory;
   
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
        calculationHistory= new ArrayList<>();
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
     * @deprecated  Old implementation of method.
     * This method converts only posotive decimal number to hexadecimal number
     * @param decimalNumber number to convert into hexadecimal number
     * @return hexadecimal number
     */
    @Deprecated
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
     * This method converts decimal number to hexadecimal number
     * @param _decimalNumber number to convert into hexadecimal number
     * @return hexadecimal number
     */
    
    public String convertDec2Hex(String _decimalNumber)
    {
     decimalNumber = Integer.parseInt(_decimalNumber);
     hexadecimalNumber=Integer.toHexString(decimalNumber);
     
     return hexadecimalNumber;  
    }
    
    /**
     * This method starts all needed calculation to convert hexadecimal number to decimal.
     * It is responsible for checking if the inuput data is a correct hexadecimal number
     * and here the program invoks method from model, that converts the number.
     * @param hexNumber the number to check 
    * @throws BadInputData when the hexNumber is not correct
     */
    public void calculateHex2Dec (String hexNumber) throws BadInputData
    {
     if (hexNumber == null || hexNumber.isEmpty()) {
        throw new BadInputData("No number to process!");
     }
     else
     {
        Pattern expression =Pattern.compile("^[0-9a-fA-F]+$");
        Matcher matcher = expression.matcher(hexNumber);
        if (!matcher.find()) {
            throw new BadInputData("Bad input data!");
        }
        else{
            decimalNumber=convertHex2Dec(hexNumber);
        }
      } 
    }
    
     /**
     * This method starts all nedded calculations to convert a decimal number to hexadecimal. 
     * It is responsible for checking if the inuput data is a correct hexadecimal number 
     * and here the program invoks method from model, that converts the number to hexadecimal. 
     * @param decNumber the number to check
     * @throws BadInputData when the hexNumber is not correct
     */
    public void calculateDec2Hex (String decNumber) throws BadInputData
    {   
     if (decNumber == null || decNumber.isEmpty()) {
        throw new BadInputData("No number to process!");
     }
     else
     {
        Pattern expression =Pattern.compile("^(-?[1-9]+\\d*)$|^0$");
        Matcher matcher = expression.matcher(decNumber);
        if (!matcher.find()) {
            throw new BadInputData("Bad input data!");
        }
        else{
            hexadecimalNumber=convertDec2Hex(decNumber);
        }
      }
    }
    
    /**
     * This method adds to list conversion from hexadecimal number to decimal number
     * @param hex number that was converted
     */
    public void addHistoryHex2Dec(String hex) {
        calculationHistory.add("Hex2Dec from: "+hex+" to: " +decimalNumber);
    }

    /**
     * This method adds to list conversion from decimal number to hexadecimal number
     * @param dec number that was converted
     */
    public void addHistoryDec2Hex(String dec) {
        calculationHistory.add("Dec2Hex from: " +dec+" to: " +hexadecimalNumber);
    }

    /**
     * This method gets from the history list every conversion of numbers that was made
     * @return message that is the whole history of calculations
     */
   public String getCalculationHistoryList()
   {
       String message="Calculation History: ";
       for(String historyElement : calculationHistory)
       {
           message+=historyElement+"\n";
       }
       return message;
    }
   
}

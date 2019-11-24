/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.view;
import java.util.Scanner;
import pl.java.model.UserChoiceEnum;



/**
 * It's a class that displays informations and data
 *
 * @author Weronika Staneczek
 * @version 1.0
 */

public class View {
    /**
     * This method shows two options to user
     * 
     * @return user choice if he wants to change a decimal number or hexadecimal number
     */
    public UserChoiceEnum showOptions() 
    {
        Scanner scanner = new Scanner(System.in);
        showMessage("Dec2Hex2DecConverter");
        showMessage("1.Convert hexadecimal number to decimal number");
        showMessage("2.Convert decimal number to hexadecimal number");
        showMessage("3.History");
        showMessage("4.Exit");

        showMessage("Your choice: ");
        int choice = 0;
        
        while (choice == 0) 
        {
            try
            {
            choice = Integer.parseInt(scanner.next());
            if (choice<0 && choice>4) 
            {
                showMessage("Wrong option, try again!");
                choice = 0;
            }
            }catch(NumberFormatException e)
            { 
                showMessage("Bad imput, try again!");
            }   
           
        }
        
        
        return UserChoiceEnum.values()[choice-1];
    }
     

    /**
     * Method responsible for get input data from user
     * @return Data which was read from the console
     */
    private String getDataFromUser(){
        Scanner input = new Scanner(System.in);
        String inputData = input.nextLine();       
        return inputData;
    }
    
    /**
     * This method reads a hexadecimal number
     * 
     * @return hexadecimal number to convert into decimal number
     */ 
    
    public String readHexNumberFromUser() 
    {
        showMessage("Enter hexadecimal number");
        String hexNumber=getDataFromUser();
        
        return hexNumber;
        
    }
  
    /**
     * This method reads a decimal number 
     * 
     * @return decimal number to convert into hexadecimal number
     */
    public String readDecNumberFromUser() 
    {
       showMessage("Enter decimal number");
        String decNumber=getDataFromUser();
        
        return decNumber;
    }
    
    /**
     * This method shows information to the user
     * @param message it's a message which would be displayed
     */
    public void showMessage(String message) 
    {
        System.out.println(message);
    }
    
    /**
     * This method shows result from the program activities
     * 
     * @param hexadecimalNumber is a result of converting from decimal numeral system
     */
    public void showHexadecimalNumber(String hexadecimalNumber)
    {
        showMessage("Hexadecimal number: "+hexadecimalNumber);
    }
    
    /**
     * This method shows result from the program activities
     * @param decimalNumber is a result of converting from hexadecimal numeral system
     */
     public void showDecimalNumber(int decimalNumber) 
    {
        showMessage("Decimal number: " + decimalNumber);
    }
     
     /**
      * This method shows calculation history
      * @param calculationHistoryList is a String with 
      */

    public void showHistory(String calculationHistoryList) {
        
        showMessage(calculationHistoryList);
    }
  
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.controller;
import pl.java.model.Model;
import pl.java.model.BadInputData;
import pl.java.model.UserChoiceEnum;
import pl.java.view.View;



/**
* It's a class responsible for running the program and comunnicating in MVC pattern
*
* @author Weronika Staneczek
* @version 1.0
*/

public class Controller {
    
      
    /**
     * It's a reference to the class View object, that is actually used
     */
    private final View view;

    /**
     * It's a reference to the class Model object, that is actually used
     */
    private final  Model model;
    
    /**
     * Constructor of Controller
     *
     * @param view Class View in MVC pattern
     * @param model Class Model in MVC pattern
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    
    
   /**
    * This method is responsible for running the program, calling other functions
    * and communicating between objects Model and View.
    */
    
    public void run() 
    {
        boolean exit=false;
        String hex;
        String dec;
        UserChoiceEnum userChoice;
        while(!exit)
        {
        userChoice = view.showOptions();   
        switch(userChoice)
        {
            case HEX2DEC:
                 hex=view.readHexNumberFromUser();
            try
              {
                  model.calculateHex2Dec(hex);
              }
            catch (BadInputData exception)
              {
                  view.showMessage(exception.getMessage());
                  return;
              }
              
            //model.convertHex2Dec(hex);
            view.showDecimalNumber(model.getDecimalNumber());
            model.addHistoryHex2Dec(hex);
            break;
            
            case DEC2HEX:
              dec=view.readDecNumberFromUser();
              try
              {
                  model.calculateDec2Hex(dec);
              }
            catch (BadInputData exception)
              {
                  view.showMessage(exception.getMessage());
                  return;
              }
              //model.convertDec2Hex(dec);
              view.showHexadecimalNumber(model.getHexadecimalNumber());
              model.addHistoryDec2Hex(dec);
              break;
              
            case HISTORY:
              view.showHistory(model.getCalculationHistoryList());
                break;
                
            case EXIT:
               exit=true;
               break;
               
        }
        }
          
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.lab.Controller;
import pl.java.lab.Model.Model;
import pl.java.lab.Model.BadInputData;
import pl.java.lab.View.View;


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
    private View view;

    /**
     * It's a reference to the class Model object, that is actually used
     */
    private  Model model;
    
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
          
          int userChoice;
          userChoice = view.showOptions();
          String hex;
          int dec;
          if (userChoice==1)
          {  
              
            hex=view.readHexNumberFromUser();
            try
              {
                  model.hexadecimalChecker(hex);
              }
            catch (BadInputData exception)
              {
                  view.showMessage(exception.getMessage());
                  return;
              }
              
            model.convertHex2Dec(hex);
            view.showDecimalNumber(model.getDecimalNumber());
          }
          else
          { 
              dec=view.readDecNumberFromUser();
              model.convertDec2Hex(dec);
              view.showHexadecimalNumber(model.getHexadecimalNumber());
          }
          
    }
}

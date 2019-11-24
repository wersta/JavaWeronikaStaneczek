/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.model;


/**
 *This class is responsible for defining BadInputData exception
 * 
 * @author Weronika Staneczek
 * @version 1.0
 */
public class BadInputData extends Exception {
    
    /**
     * Constructor 
     * @param message information about exception
     */
    
    public BadInputData(String message)
    {
          super(message);
    }
    
    
}

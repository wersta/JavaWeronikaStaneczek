/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.dec2hex2decconverter;
import pl.java.controller.Controller;
import pl.java.view.View;
import pl.java.model.Model;

/**
 * It's a class with main method. View, Model and Controller class are created here.
 * 
 * @author Weronika Staneczek
 * @version 1.0
 */

public class Dec2Hex2DecConverter {

    /**
     * Main method to start the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View View = new View();
        Model model = new Model();
        Controller controller = new Controller(View, model);
        controller.run();
    }
    
}

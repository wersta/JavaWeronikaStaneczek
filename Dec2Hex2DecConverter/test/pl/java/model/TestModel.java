/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.java.model;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 *  Tests cases of Model class, validates methods
 *
 * @author Weronika Staneczek
 * @version 1.0
 */
public class TestModel {
    
    /**
     * Object of model class to test.
     */
   
    Model instance=new Model();
    
    /**
     * Test of convertHex2Dec method
     */
    @Test
    public void testConvertHex2Dec() {
        String hexadecimalNumber = "38";
        int expResult = 56;
        int result = instance.convertHex2Dec(hexadecimalNumber);
        assertEquals("For value: "+result+" test passed negative",expResult, result);
    }
     /**
     * Test of convertHex2Dec method, argument in big letters.
     */
    @Test
    public void testConvertHex2DecBigLetters() {
        String hexadecimalNumber = "AB";
        int expResult = 171;
        int result = instance.convertHex2Dec(hexadecimalNumber);
        assertEquals("For value: "+result+" test passed negative",expResult, result);
    }
    /**
     * Test of convertHex2Dec method, argument in small letters.
     */
    @Test
    public void testConvertHex2DecSmallLetters() {
        String hexadecimalNumber = "dd";
        int expResult = 221;
        int result = instance.convertHex2Dec(hexadecimalNumber);
        assertEquals("For value: "+result+" test passed negative",expResult, result);
    }
    
     /**
     * Test of convertDec2Hex method, argument negative number.
     */
    @Test
    public void testConvertDec2HexNegativeNumber() {
        String _decimalNumber = "-11";
        String expResult = "fffffff5";
        String result = instance.convertDec2Hex(_decimalNumber);
        assertEquals("For value: "+result+" test passed negative",expResult, result);
    }
    
     /**
     * Test of convertDec2Hex method, argument positive number.
     */
    @Test
    public void testConvertDec2HexPositiveNumber() {
        String _decimalNumber = "22";
        String expResult = "16";
        String result = instance.convertDec2Hex(_decimalNumber);
        assertEquals("For value: "+result+" test passed negative",expResult, result);
    }
    
     /**
     * Testing if method throw exception when argument is ccorect
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateHex2DecCorrect() throws Exception {
        
        String hexNumber = "1B";
        instance.calculateHex2Dec(hexNumber);
    }
    
     /**
     * Testing if method throw exception when argument is inccorect
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateHex2DecIncorrect() throws Exception {
        
        String hexNumber = "gb";
        try{
        instance.calculateHex2Dec(hexNumber);
        fail("Should an exception occurred: Bad input!");
        }
        catch(BadInputData exception)
        {
        }
    }
     /**
     * Testing if method throw exception when argument is an empty string
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateHex2DecEmptyValue() throws Exception {
        
        String hexNumber = "";
        try{
        instance.calculateHex2Dec(hexNumber);
        fail("Should an exception occurred: Bad input!");
        }
        catch(BadInputData exception)
        {
        }
    }
     /**
     * Testing if method throw exception when argument is a null reference
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateHex2DecNull() throws Exception {
        
        String hexNumber = null;
        try{
        instance.calculateHex2Dec(hexNumber);
        fail("Should an exception occurred: Bad input!");
        }
        catch(BadInputData exception)
        {
        }
    }
    
     /**
     * Testing if method throw exception when argument is an empty string
     * @throws java.lang.Exception
     */
    
    @Test
    public void testCalculateDec2HexEmptyValue() throws Exception {
        
        String decNumber = "";
        try{
        instance.calculateDec2Hex(decNumber);
        fail("Should an exception occurred: Bad input!");
        }
        catch(BadInputData exception)
        {
        }
    }
    
    /**
     * Testing if method throw exception when argument is a null reference
     * @throws java.lang.Exception
     */
    
    @Test
    public void tesCalculateDec2HextNull() throws Exception {
        
        String decNumber = null;
        try{
        instance.calculateDec2Hex(decNumber);
        fail("Should an exception occurred: Bad input!");
        }
        catch(BadInputData exception)
        {
        }
    }
    
     /**
     * Testing if method throw exception when argument is incorrect
     * @throws java.lang.Exception
     */
     @Test
    public void testCalculateDex2Hex() throws Exception {
        
        String decNumber = "10.12";
        try{
        instance.calculateDec2Hex(decNumber);
        fail("Should an exception occurred: Bad input!");
        }
        catch(BadInputData exception)
        {
        }
    }
    
     /**
     * Testing if method throw exception when argument is ccorect
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateDec2HexCorrect() throws Exception {
        
        String decNumber = "10";
        instance.calculateDec2Hex(decNumber);
    }
    
}

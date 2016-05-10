/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtw;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author glangsdorf18
 */
public class Create {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Text t=new Text(5, new File("Text"));
        RandTextGen rand=new RandTextGen(t);
        
        System.out.println(rand.write(1000));
    }
    
}

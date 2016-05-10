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
        Text t=new Text(8, new File("Text"));
        RandTextGen rand=new RandTextGen(t);
        
        String story = rand.write(1000);
        String s = "";
        
        for (int i = 0; i < story.length() / 100; i++) {
            
            s += story.substring(i * 100, (i + 1) * 100) + "\n";
            story = story.substring((i + 1) * 100);
        }
        
        s += story;
        System.out.println(s);
    }
    
}

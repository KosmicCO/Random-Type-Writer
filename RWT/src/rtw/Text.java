/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author cbarnum18
 */
public class Text {
    
    private String text;
    private File combos;
    private int level;
    
    public Text(int l, String f) throws FileNotFoundException{
        
        this(l, new File(f));
        
    }
    
    public Text(int l, File f) throws FileNotFoundException{
        
        Scanner read = new Scanner(f);
        read.useDelimiter("\\z");
        text = read.next();
        level = l;
    }
    
    private File combos(){
        
        return null;
    }
}

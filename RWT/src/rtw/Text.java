/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author cbarnum18
 */
public class Text {
    
    private String text;
    private File combos;
    private int level;
    private FileWriter writer;
    
    public Text(int l, String f) throws FileNotFoundException{
        
        this(l, new File(f));
        
    }
    
    public int getLevel(){
        
        return level;
    }
    
    public String getRandCombo(){
        
        int size = text.length() - level + 1;
        int rand = (int) (Math.random() * size);
        return text.substring(rand, rand + level + 1);
    }
    
    public Text(int l, File f) throws FileNotFoundException{
        
        Scanner read = new Scanner(f);
        read.useDelimiter("\\z");
        text = read.next();
        level = l;
    }
    
    public File getCombos(){
        
        return combos;
    }
    
    private void writeComboFile() throws IOException{
        
        List<String> coms = new ArrayList();
        int sz = text.length() - level + 1;
        writer = new FileWriter(combos);
    }
    
    private void writeCombo(String cm, List<Character> ac) throws IOException{
        
        int chs = ac.size();
        writer.write("~" + cm + " " + chs + " ");
        
        for (Character c : ac) {
            
            writer.write(c.toString() + " ");
        }
        
        writer.write("\n");
    }
}

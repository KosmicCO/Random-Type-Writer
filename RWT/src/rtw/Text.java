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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    public Text(int l, File f, String seed) throws FileNotFoundException{
        
        level = l;
        combos = f;
        text = seed;
    }
    
    public int getLevel(){
        
        return level;
    }
    
    public Text(int l, File f) throws FileNotFoundException{
        
        Scanner read = new Scanner(f);
        read.useDelimiter("\\z");
        text = read.next();
        level = l;
        combos = new File("Combos");
    }
    
    public String getRandCombo(){
        
        int size = text.length() - level + 1;
        int rand = (int) (Math.random() * size);
        return text.substring(rand, rand + level);
    }
    
    public File getCombos(){
        
        return combos;
    }
    
    public void writeComboFile() throws IOException{
        
        Map<String, String> coms = new HashMap();
        int sz = text.length() - level;
        
        
        for (int i = 0; i < sz; i++) {
            
            String s = text.substring(i, i + level);
            char c = text.charAt(i + level) == ' ' ? '_' : text.charAt(i + level);
            
            if(!coms.containsKey(s)){
                
                coms.put(s, "" + c);
            }else{
                
                coms.replace(s, coms.get(s) + c);
            }
        }
        
        FileWriter writer = new FileWriter(combos);
        
        writer.write("" + coms.size() + "\n");
        
        for (String s : coms.keySet()) {
            
            List<Character> lc = new ArrayList();
            
            for(char c : coms.get(s).toCharArray()){
                
                lc.add(c);
            }
            
            writeCombo(s, lc, writer);
        }
        
        writer.close();
    }
    
    private void writeCombo(String cm, List<Character> ac, FileWriter writer) throws IOException{
        
        int chs = ac.size();
        cm = cm.replace(' ', '_');
        
        writer.write("~" + cm + " " + chs + " ");
        
        for (Character c : ac) {
            
            writer.write(c.toString() + " ");
        }
        
        writer.write("\n");
    }
}

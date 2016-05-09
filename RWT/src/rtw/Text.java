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
        int sz = text.length() - level + 1;
        
        
        for (int i = 0; i < sz; i++) {
            
            String s = text.substring(i, i + level);
            
            if(!coms.containsKey(s)){
                
                coms.put(s, "" + text.charAt(i + level - 1));
            }else{
                
                coms.replace(s, coms.get(s) + text.charAt(i + level - 1));
            }
        }
        
        for(String s : coms.keySet()){
            
            System.out.println(s);
        }
        
        FileWriter writer = new FileWriter(combos);
        
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
        writer.write("~" + cm + " " + chs + " ");
        
        for (Character c : ac) {
            
            writer.write(c.toString() + " ");
        }
        
        writer.write("\n");
    }
}

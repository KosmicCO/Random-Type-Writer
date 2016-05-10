/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtw;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author cbarnum18
 */
public class RandTextGen {

    private Text text;
    

    public RandTextGen(Text t) throws FileNotFoundException {
        text = t;
    }
    
    public String write(int l) throws FileNotFoundException{
        
        char c = '_';
        String s = text.getRandCombo();
        String sto = s;
        int count = l;
        
        while(c != '~' && count > 0){
            
            c = getRandChar(s);
            
            if(count % 50 == 0){
                
                System.out.println(count);
            }
            
            if(c == '_'){
                
                c = ' ';
            }
            
            if(c == '^'){
                
                c = '\n';
            }
            
            sto += c;
            s = s.substring(1) + c;
            count--;
        }
        
        return sto;
    }

    public char getRandChar(String combo) throws FileNotFoundException {
        
        Scanner reader = new Scanner(text.getCombos());
        int h = Integer.parseInt(reader.next());
        combo = combo.replace(' ', '_');
        combo = combo.replace('\n', '^');
        
        try {

            search(combo, reader);
            int s = Integer.parseInt(reader.next());
            int r = (int) (Math.random() * s + 1);
            int count = 1;
            char c = ' ';
            
            while (count <= r) {
                c = reader.next().charAt(0);
                count++;
            }
            
            reader.close();
            return c;
        }catch(NoSuchElementException nsee){
            
            reader.close();
            return (char) '~';
        }
    }
    
    public void search(String s, Scanner r){
        
        s = "~" + s;
        
        while(!r.next().equals(s)){}
    }
}

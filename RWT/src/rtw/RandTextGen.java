/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtw;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author cbarnum18
 */
public class RandTextGen{
    
    private Text text;
    
    public RandTextGen(Text t) throws FileNotFoundException{
        text=t;
    }
    
    public char getRandChar(String combo) throws FileNotFoundException{
        Scanner reader=new Scanner(combo);
        int s = Integer.parseInt(reader.next(combo));
        int r=(int)(Math.random()*s+1);
        int count=1;
        while(count<=r){
            reader.next();
            count++;
        }
        reader.next();
        
    }
}

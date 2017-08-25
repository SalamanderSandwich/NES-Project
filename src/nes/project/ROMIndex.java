/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nes.project;

import java.util.ArrayList;

/**
 *
 * @author lain
 */
public class ROMIndex {
    int hexLocation;
    int hexEnd;
    String originalText;
    String newText;
    boolean changed=false;
    ArrayList<Integer> addressSkips=new ArrayList<>();
    
    public ROMIndex(int hexLocation, String originalText)
    {
        this.hexLocation=hexLocation;
        this.originalText=originalText;
        hexEnd=hexLocation+originalText.length()-1;
    }
    
    public void addSkipRange(int hexLocation, int length)
    {
        for(int i=0; i<length; i++)
        {
            addressSkips.add(hexLocation+i);
        }
    }
    
    public void setNewText(String s)
    {
        newText=s;
    }
    
    public int getHexLocation() {
        return hexLocation;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getNewText() {
        return newText;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean b)
    {
        changed=b;
    }
    
    public ArrayList<Integer> getAddressSkips() {
        return addressSkips;
    }
    
    public int getHexEnd(){
        return hexEnd;
    }
}

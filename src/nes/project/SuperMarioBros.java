/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nes.project;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 *
 * @author lain
 */
public class SuperMarioBros extends VBox{
    String table="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ \b\b\b-*\b!\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b.\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";
       
    ROMIndex[] superMarioBrosIndexes={
            new ROMIndex(0x0765, "MARIO"),
            new ROMIndex(0x07FD, "LUIGI"),
            new ROMIndex(0x0D67, "THANK YOU MARIO!"),
            new ROMIndex(0x0D7B, "THANK YOU LUIGI!"),
            new ROMIndex(0x0D8F, "BUT OUR PRINCESS IS IN"),
            new ROMIndex(0x0DA8, "ANOTHER CASTLE!"),
            new ROMIndex(0x0DBB, "YOUR QUEST IS OVER"),
            new ROMIndex(0x0DD2, "WE PRESENT YOU A NEW QUEST."),
            new ROMIndex(0x0DF1, "PUSH BUTTON B"),
            new ROMIndex(0X0E02, "TO SELECT A WORLD")};

    public ROMIndex[] getIndexs() {
        return superMarioBrosIndexes;
    }
    
    public SuperMarioBros()
    {
        //String table="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ \b\b\b-*\b!\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b.\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b";
        //ROMReplaceAll[] superMarioBrosReplaceAlls=new ROMReplaceAll[]{new ROMReplaceAll(new int[] {0x16, 0x0A, 0x1B, 0x12, 0x18}, "MARIO")};
        
        
        for(ROMIndex r : superMarioBrosIndexes)
        {
            TextField t=new TextField();
            t.setText(r.originalText);
            t.textProperty().addListener((observable, oldValue, newValue) -> {
                if(newValue.length()>r.getOriginalText().length())
                {
                    t.setText(oldValue);
                }
                else if(newValue.length()<r.getOriginalText().length())
                {
                    t.setStyle("-fx-text-fill: red");
                }
                else
                {
                    t.setStyle("-fx-text-fill: black");
                }
                for(char c : newValue.toCharArray())
                {
                    if(table.indexOf(c)==-1)
                    {
                        t.setText(oldValue);
                    }
                }
                
            });
            getChildren().add(t);
        }
    }
    
}

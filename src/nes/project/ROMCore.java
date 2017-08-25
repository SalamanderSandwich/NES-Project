/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nes.project;

/**
 *
 * @author lain
 */
public class ROMCore {

    public ROMObject getRightRom(String hash) {
        for(String s : new String[]{"19b82fe2f19425e7739b345a06b65e"})//Super Mario Bros
        {
            if(s.equals(hash))
            {
                System.err.println("dsjila");
                return new ROMObject(new ROMIndex[]
                {
                    new ROMIndex(0x0765, "MARIO"),
                    new ROMIndex(0x07FD, "LUIGI"),
                    new ROMIndex(0x0D67, "THANK YOU MARIO!"),
                    new ROMIndex(0x0D7B, "THANK YOU LUIGI!"),
                    new ROMIndex(0x0D8F, "BUT OUR PRINCESS IS IN"),
                    new ROMIndex(0x0DA8, "ANOTHER CASTLE!"),
                    new ROMIndex(0x0DBB, "YOUR QUEST IS OVER"),
                    new ROMIndex(0x0DD2, "WE PRESENT YOU A NEW QUEST."),
                    new ROMIndex(0x0DF1, "PUSH BUTTON B"),
                    new ROMIndex(0X0E02, "TO SELECT A WORLD")
                },
                        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ \b\b\b-*\b!\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b.\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
            }
        }
        System.err.println("!!!!!!!!");
        return new ROMObject(new ROMIndex[]{new ROMIndex(0x00, "BAD")}, "BAD");
    }
}
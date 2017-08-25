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
public class ROMObject {
    ROMIndex[] ROMIndexs;
    String table;

    
    public ROMObject(ROMIndex[] ROMIndexs, String table)
    {
        this.ROMIndexs=ROMIndexs;
        this.table=table;
    }

    public ROMIndex[] getROMIndexs() {
        return ROMIndexs;
    }
    
    public String getTable() {
        return table;
    }
}

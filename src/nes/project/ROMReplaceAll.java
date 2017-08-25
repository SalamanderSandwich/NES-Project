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
public class ROMReplaceAll {
    int[] hexToReplace;
    String originalText;
    public ROMReplaceAll(int[] hexToReplace, String originalText)
    {
        this.hexToReplace=hexToReplace;
        this.originalText=originalText;
    }
}

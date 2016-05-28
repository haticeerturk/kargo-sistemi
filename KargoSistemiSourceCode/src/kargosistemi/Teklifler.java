/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargosistemi;

/**
 *
 * @author hatice
 */
public class Teklifler {
    int aeID, tID;
    double teklif;
    
    public Teklifler(int aeID, int tID, double teklif){
        this.aeID = aeID;
        this.tID = tID;
        this.teklif = teklif;
    }
    public Teklifler(){
        
    }
}

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
public class AcikEksiltme {
    int mID, kargoID, aeID;
    double  ucret;
    String teslimAlinacakAdres, teslimEdilecekAdres, tarihBaslangic, tarihBitis, aeBitisTarih;
    
    
    
    public AcikEksiltme(int mID, int kargoID, int ucret, String teslimAlinacakAdres, String teslimEdilecekAdres, String tarihBaslangic, String tarihBitis, String aeBitisTarih){
        this.mID = mID;
        this.kargoID = kargoID;
        this.ucret = ucret;
        this.teslimAlinacakAdres = teslimAlinacakAdres;
        this.teslimEdilecekAdres = teslimEdilecekAdres;
        this.tarihBaslangic = tarihBaslangic;
        this.tarihBitis = tarihBitis;
        this.aeBitisTarih = aeBitisTarih;
    }
    public AcikEksiltme(){
        
    }
}

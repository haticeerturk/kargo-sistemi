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
public class Urun {
    String urunTipi;
    double agirlik;
    int adet,ebatX,ebatY;
    Integer mID, urunID;
    
    public Urun(Integer mID, String urunTipi, double agirlik, int ebatX, int ebatY,int adet){
        this.mID = mID;
        this.urunTipi = urunTipi;
        this.agirlik = agirlik;
        this.ebatX = ebatX;
        this.ebatY = ebatY;
        this.adet = adet;
    }
    public Urun(){
        
    }
}

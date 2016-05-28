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
public class Kargo {
    int urunID, mID;
    double agirlik;
    int ebatX, ebatY;
    
    public Kargo(){
        
    }
    
    public Kargo(int mID, int urunID, double agirlik, int ebatX, int ebatY){
        this.mID = mID;
        this.urunID = urunID;
        this.agirlik = agirlik;
        this.ebatX = ebatX;
        this.ebatY = ebatY;
    }
}

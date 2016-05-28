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
public class Musteri {
    public Integer mID;
    String ad;
    String soyad;
    String mail;
    String tel;
    String adres;
    public String pass;

    
    public Musteri(){
        
    }
    
    public Musteri(String ad, String soyad, String mail, String tel, String adres, String pass) {
        this.ad = ad;
        this.soyad = soyad;
        this.mail = mail;
        this.tel = tel;
        this.adres = adres;
        this.pass = pass;
    } 
    
    public Musteri(Integer mID, String pass) {
        this.mID = mID;
        this.pass = pass;
    }     
}

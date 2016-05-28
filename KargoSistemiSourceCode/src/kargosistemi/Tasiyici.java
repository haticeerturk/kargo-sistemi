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
public class Tasiyici {
    String ad,soyad,mail,tel,adres,tasinabilecekUTip;
    public String pass;
    public Integer tID;
    
    public Tasiyici(){
        
    }
    public Tasiyici(int tID, String pass){
        this.tID = tID;
        this.pass = pass;
    }
    public Tasiyici(String ad, String soyad, String mail, String tel, String adres, String pass, String tasinabilecekUTip){
        this.ad = ad;
        this.soyad = soyad;
        this.mail = mail;
        this.tel = tel;
        this.adres = adres;
        this.pass = pass;
        this.tasinabilecekUTip = tasinabilecekUTip;
    }
}

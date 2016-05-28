/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargosistemi;

import java.sql.ResultSet;

/**
 *
 * @author hatice
 */
public class Kaydedici {
    
    public Kaydedici(){
        
    } 
    
    DBFacade facade = new DBFacade();
    
    public void musteriEkle(Musteri musteri){
        facade.put(musteri);
    }
    public void tasiyiciEkle(Tasiyici tasiyici){
        facade.put(tasiyici);
    }
    public Object girisYap(Object obj){
        if(obj instanceof Musteri){
            Musteri mus = (Musteri) facade.get(obj, ((Musteri) obj).mID);
            if(mus == null) {
                return null;
            }
            else {
                return mus;
            }
        } else if(obj instanceof Tasiyici){
            Tasiyici tas = (Tasiyici)facade.get(obj, ((Tasiyici) obj).tID);
            if(tas == null){
                return null;
            } else{
                return tas;
            }
        }
        return  null;
    }
    public void urunBilgisiGir(Urun urun){
        facade.put(urun);
    }
    public void kargiBilgileriGir(Kargo kargo){
        facade.put(kargo);
    }
    public void acikEksiltmeBaslat(AcikEksiltme ae){
        facade.put(ae);
    }
    public ResultSet acikEksiltmeleriGoster(Object o){
        ResultSet rs;
        AcikEksiltme ae = new AcikEksiltme();
        if(o instanceof Tasiyici){
            rs = (ResultSet)facade.getR(ae, 1,((Tasiyici) o).tID);
            return rs;
        }
        else if(o instanceof Musteri){
            rs = (ResultSet)facade.getR(ae, 0,((Musteri) o).mID);
            return rs;
        }
        return null;
    }
    public void teklifVer(Teklifler t){
        facade.put(t);
    }
    public ResultSet teklifleriGoster(Teklifler teklif, int aeID){
        ResultSet rs;
        rs = (ResultSet)facade.getR(teklif, aeID);
        return rs;
    }
    public ResultSet sonTeklifleriGetir(Teklifler teklif, int aeID){
        ResultSet rs;
        rs = (ResultSet)facade.getR(teklif, aeID);
        return rs;
    }
    public Object tasiyiciGetir(int tID){
        Tasiyici tsy = new Tasiyici();
        Teklifler gelenT = new Teklifler();
        gelenT = (Teklifler)facade.get(gelenT, tID);
        return tsy = (Tasiyici)facade.get(tsy, gelenT.tID);
    }
    public void teklifSec(Object o){
        facade.put(o);
    }
    public int sonuncuGetir(Object o){
        return facade.getL(o);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import kargosistemi.AcikEksiltme;
import kargosistemi.Kargo;
import kargosistemi.Kaydedici;
import kargosistemi.Musteri;
import kargosistemi.Tasiyici;
import kargosistemi.Teklifler;
import kargosistemi.Urun;
import kargosistemi.teklifKabulu;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hatice
 */
public class test {
    Kaydedici kaydedici = new Kaydedici();
    public test() {
    }
//Yorum satırına alınanlar her kod test edildiğinde tekrardan işlem gördüklerinden olası hataları engellemek için yorum satırına alınmıştır.
    /* 
    @Test
    public void musteriKaydetTest(){
        
        Musteri yeniMusteri = new Musteri("Hatice", "ERTÜRK", "haticeerturk27@gmail.com", "05411111111", "Bursa", "1");
        kaydedici.musteriEkle(yeniMusteri);
        
        int mID = kaydedici.sonuncuGetir(yeniMusteri);
        assertEquals(21, mID);
    }*/
    
    @Test
    public void musteriGiris(){
        Musteri musteri = new Musteri(21, "1");
        musteri = (Musteri)kaydedici.girisYap(musteri);
        int id = musteri.mID;
        String pass = musteri.pass;
        assertEquals(21, id);
        assertEquals("1", pass);
    }
    /*
    @Test
    public void tasiyiciKaydet(){
        Tasiyici yeniTasiyici = new Tasiyici("Mert", "TAŞÇI", "merttasci2@gmail.com", "05411111111", "İstanbul", "1", "Katı");
        kaydedici.tasiyiciEkle(yeniTasiyici);
        int tID = kaydedici.sonuncuGetir(yeniTasiyici);
        assertEquals(9, tID);
    }*/
    
    @Test
    public void tasiyiciGiris(){
        Tasiyici tasiyici = new Tasiyici(9, "1");
        tasiyici = (Tasiyici)kaydedici.girisYap(tasiyici);
        int id = tasiyici.tID;
        String pass = tasiyici.pass;
        assertEquals(9, id);
        assertEquals("1", pass);
    }
    
    /*
    @Test
    public void kargoEklemeOlayi(){
        Urun yeniUrun = new Urun(21, "Katı", 50.0, 5, 10, 5);
        kaydedici.urunBilgisiGir(yeniUrun);
        int uID = kaydedici.sonuncuGetir(yeniUrun);
        assertEquals(38, uID);
        
        Kargo yeniKargo = new Kargo(21, uID, 250.0, 5, 50);
        kaydedici.kargiBilgileriGir(yeniKargo);
        int kID = kaydedici.sonuncuGetir(yeniKargo);
        assertEquals(21, kID);
        
        AcikEksiltme yeniAcikEksiltme = new AcikEksiltme(21, kID, 5000, "Bursa", "Ankara", "26-05-2016", "30-05-2016", "24-05-2016");
        kaydedici.acikEksiltmeBaslat(yeniAcikEksiltme);
        int aeID = kaydedici.sonuncuGetir(yeniAcikEksiltme);
        assertEquals(18, aeID);
    }*/
    /*
    @Test
    public void teklifVerme(){
        Teklifler yeniTeklif = new Teklifler(18, 9, 4500.0);
        kaydedici.teklifVer(yeniTeklif);
        int ID = kaydedici.sonuncuGetir(yeniTeklif);
        assertEquals(16, ID);
    }*/
    /*
    @Test
    public void teklifKabulu(){
        teklifKabulu teklif = new teklifKabulu(18, 16);
        kaydedici.teklifSec(teklif);
        int ID = kaydedici.sonuncuGetir(teklif);
        assertEquals(5, ID);
    }*/
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargosistemi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatice
 */
public class AcikEksiltmeMapper implements IMapper{
    String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
    private Connection baglanti;
    private Statement ifade;
    ResultSet rs;
    String sql;
    
    public AcikEksiltmeMapper(){
        DBBaglan();
    }
    
    private void DBBaglan(){
        String baglantiUrl = "jdbc:derby://localhost:1527/KargoSistemi";
        String userName = "a";
        String password = "a";
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            baglanti = DriverManager.getConnection(baglantiUrl,userName,password);
            ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void put(Object obje) {
        AcikEksiltme ae = (AcikEksiltme)obje;
        
        try {
            String sql = "insert into ACIKEKSILTME (MID, KID, UCRET, TAADRES, TEADRES, TARIHBASLANGIC, TARIHBITIS, AEBITIS) values ("+ae.mID+","+ae.kargoID+","+ae.ucret+",'"+ae.teslimAlinacakAdres+"','"+ae.teslimEdilecekAdres+"','"+ae.tarihBaslangic+"','"+ae.tarihBitis+"','"+ae.aeBitisTarih+"')";
            ifade.executeUpdate(sql);      
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
            
    @Override
    public Object get(int ID) {
        /*
        System.out.println(ID);
        try {
            if (baglanti.isClosed()) {
                DBBaglan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcikEksiltmeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        //String sql = "select * from ACIKEKSILTME where AEID="+ID;
        String sql = "select * from ACIKEKSILTME";
        
        try {
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();

                AcikEksiltme a = new AcikEksiltme();
                a.aeID = rs.getInt("AEID");
                a.mID = rs.getInt("MID");
                a.kargoID = rs.getInt("KID");
                a.ucret = rs.getInt("UCRET");
                System.out.println(a.ucret);
                a.teslimAlinacakAdres = rs.getString("TAADRES");
                a.teslimEdilecekAdres = rs.getString("TEADRES");
                a.tarihBaslangic = rs.getString("TARIHBASLANGIC");
                a.tarihBitis = rs.getString("TARIHBITIS");
                a.aeBitisTarih = rs.getString("AEBITIS");
                return a;
            }
            else return null;
        } catch (SQLException ex) {
            Logger.getLogger(AcikEksiltmeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return null; 
    }
    
    @Override
    public ResultSet getR(int ID, int islemTipi) {
        System.out.println(ID);
        try {
            if (baglanti.isClosed()) {
                DBBaglan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcikEksiltmeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(islemTipi == 1) {
        //String sql = "select * from ACIKEKSILTME where AEID="+ID;//su acık eksiltmeyi su teklif kazandi.
            sql = "select AEID, UCRET, TAADRES, TEADRES, TARIHBASLANGIC, TARIHBITIS, AEBITIS from ACIKEKSILTME as ae where AEBITIS > '" +timeStamp+ "' and ae.KID IN (select k.KID from kargo as k where k.UID IN (select u.UID from URUN as u where u.URUNTIPI IN (select t.TUTIP from TASIYICI as t where t.TID = "+ ID +")))";
        }else if(islemTipi == 2){
            sql = "select AEID, UCRET, TAADRES, TEADRES, TARIHBASLANGIC, TARIHBITIS, AEBITIS from ACIKEKSILTME where MID="+ID+" and AEBITIS > '" +timeStamp+ "'";
        }
        
        
        try {
            rs = ifade.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AcikEksiltmeMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;   
    }

    @Override
    public int getL(Object o) {
        AcikEksiltme ae = (AcikEksiltme)o;
        try {
            String sql = "select AEID from ACIKEKSILTME where KID="+ae.kargoID+" order by AEID DESC FETCH FIRST 1 ROWS ONLY";
            
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();
                return rs.getInt("AEID");
            }
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UrunMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hatice
 */
public class MusteriMapper implements IMapper{
    private Connection baglanti;
    private Statement ifade;
    ResultSet rs;
    
    public MusteriMapper(){
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
    public Object get(int ID) {
        
        try {
            if (baglanti.isClosed()) {
                DBBaglan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusteriMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        String sql = "select * from MUSTERI where MID="+ID;
        
        try {
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();

                Musteri a = new Musteri();
                a.mID = rs.getInt("MID");
                a.ad = rs.getString("MAD");
                a.soyad = rs.getString("MSOYAD");
                a.mail = rs.getString("MMAIL");
                a.tel = rs.getString("MTEL");
                a.adres = rs.getString("MADRES");
                a.pass = rs.getString("MPAROLA");
                return a;
            }
            else return null;
        } catch (SQLException ex) {
            //Logger.getLogger(MusteriMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void put(Object obje) {
        Musteri a = (Musteri)obje;
        
        try {
            String sql = "insert into MUSTERI (MAD, MSOYAD, MMAIL, MTEL, MADRES, MPAROLA) values ('"+a.ad+"','"+a.soyad+"','"+a.mail+"','"+a.tel+"','"+a.adres+"','"+a.pass+"')";
            ifade.executeUpdate(sql);  
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public ResultSet getR(int ID, int islemTipi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getL(Object o) {
        Musteri m = (Musteri)o;
        try {
            String sql = "select MID from MUSTERI where MMAIL='"+m.mail+"'order by MID DESC FETCH FIRST 1 ROWS ONLY";
            
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();
                return rs.getInt("MID");
            }
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(MusteriMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

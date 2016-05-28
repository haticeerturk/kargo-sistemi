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
public class TasiyiciMapper implements IMapper{
    private Connection baglanti;
    private Statement ifade;
    ResultSet rs;
    
    public TasiyiciMapper(){
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
        Tasiyici a = (Tasiyici)obje;
        
        try {
            String sql = "insert into TASIYICI (TAD, TSOYAD, TMAIL, TTEL, TADRES, TPAROLA, TUTIP) values ('"+a.ad+"','"+a.soyad+"','"+a.mail+"','"+a.tel+"','"+a.adres+"','"+a.pass+"','"+a.tasinabilecekUTip+"')";
            ifade.executeUpdate(sql);        
            
        } catch (Exception e) {
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
      
        String sql = "select * from TASIYICI where TID="+ID;
        
        try {
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();

                Tasiyici a = new Tasiyici();
                a.tID = rs.getInt("TID");
                a.ad = rs.getString("TAD");
                a.soyad = rs.getString("TSOYAD");
                a.mail = rs.getString("TMAIL");
                a.tel = rs.getString("TTEL");
                a.adres = rs.getString("TADRES");
                a.pass = rs.getString("TPAROLA");
                a.tasinabilecekUTip = rs.getString("TUTIP");
                return a;
            }
            else return null;
        } catch (SQLException ex) {
            Logger.getLogger(TasiyiciMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getR(int ID, int islemTİpi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getL(Object o) {
        Tasiyici t = (Tasiyici)o;
        try {
            String sql = "select TID from TASIYICI where TMAIL='"+t.mail+"'order by TID DESC FETCH FIRST 1 ROWS ONLY";
            
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();
                return rs.getInt("TID");
            }
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(MusteriMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }   
}

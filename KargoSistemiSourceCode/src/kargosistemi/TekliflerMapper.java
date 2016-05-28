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
public class TekliflerMapper implements IMapper{
    private Connection baglanti;
    private Statement ifade;
    ResultSet rs;
    
    public TekliflerMapper(){
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
        Teklifler t = (Teklifler)obje;
        
        try {
            String sql = "insert into TEKLIFLER (AEID, TID, TEKLIF) values ("+t.aeID+","+t.tID+","+t.teklif+")";
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
            Logger.getLogger(TekliflerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        String sql = "select * from TEKLIFLER where TEID="+ID;
        
        try {
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();

                Teklifler a = new Teklifler();
                a.aeID = rs.getInt("AEID");
                a.tID = rs.getInt("TID");
                a.teklif = rs.getInt("TEKLIF");
                return a;
            }
            else return null;
        } catch (SQLException ex) {
            Logger.getLogger(TekliflerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getR(int ID, int islemTipi) {
        
        try {
            if (baglanti.isClosed()) {
                DBBaglan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TekliflerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        String sql = "select TEID,TEKLIF from TEKLIFLER where AEID="+ID+" order by TEKLIF ASC";
        
        
        try {
            rs = ifade.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(TekliflerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;   
    }

    @Override
    public int getL(Object o) {
        Teklifler t = (Teklifler)o;
        
        try {
            String sql = "select TEID from TEKLIFLER where TID="+t.tID+" order by TEID DESC FETCH FIRST 1 ROWS ONLY";
            
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();
                return rs.getInt("TEID");
            }
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UrunMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

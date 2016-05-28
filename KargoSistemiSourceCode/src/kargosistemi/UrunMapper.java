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
public class UrunMapper implements IMapper{
    private Connection baglanti;
    private Statement ifade;
    ResultSet rs;
    
    public UrunMapper(){
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
        Urun u = (Urun)obje;
        
        try {
            String sql = "insert into URUN (MID, URUNTIPI, AGIRLIK, EBATX, EBATY, ADET) values ("+u.mID+",'"+u.urunTipi+"',"+u.agirlik+","+u.ebatX+","+u.ebatY+","+u.adet+")";
            ifade.executeUpdate(sql);      
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public Object get(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getR(int ID, int islemTipi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public int getL(Object o) {
        Urun u = (Urun) o; 
        try { 
            String sql = "select UID from URUN where MID="+u.mID+" order by UID DESC FETCH FIRST 1 ROWS ONLY";
            
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();
                return rs.getInt("UID");
            }
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UrunMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
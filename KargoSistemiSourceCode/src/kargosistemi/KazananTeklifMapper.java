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
public class KazananTeklifMapper implements IMapper{
    private Connection baglanti;
    private Statement ifade;
    ResultSet rs;
    String sql;
    
    public KazananTeklifMapper(){
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
        teklifKabulu tk = (teklifKabulu)obje;
        
        try {
            String sql = "insert into KTEKLIF (AEID, TEID) values ("+tk.aeID+","+tk.teID+")";
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
    public ResultSet getR(int ID, int iT) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getL(Object o) {
        teklifKabulu tk = (teklifKabulu)o;
        try {
            String sql = "select KTID from KTEKLIF where AEID="+tk.aeID+" order by KTID DESC FETCH FIRST 1 ROWS ONLY";
            
            rs = ifade.executeQuery(sql);
            if(rs != null){
                rs.next();
                return rs.getInt("KTID");
            }
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UrunMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}

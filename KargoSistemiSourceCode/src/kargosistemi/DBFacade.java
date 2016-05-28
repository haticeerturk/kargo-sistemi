/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kargosistemi;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hatice
 */
public class DBFacade {
    HashMap<Integer, IMapper> mapper = new HashMap<Integer,IMapper>();
    
    IMapper mp;
    
    
    public DBFacade() {
        mapper.put(1, new MusteriMapper());
        mapper.put(2, new TasiyiciMapper());
        mapper.put(3, new UrunMapper());
        mapper.put(4, new KargoMapper());
        mapper.put(5, new AcikEksiltmeMapper());
        mapper.put(6, new TekliflerMapper());
        mapper.put(7, new KazananTeklifMapper());
    }
    
    public IMapper getMapper(Object o){
        if(o instanceof Musteri){
            return mapper.get(1);
        }
        else if(o instanceof Tasiyici){
            return mapper.get(2);
        }
        else if(o instanceof Urun){
            return mapper.get(3);
        }
        else if(o instanceof Kargo){
            return mapper.get(4);
        }
        else if(o instanceof AcikEksiltme){
            return mapper.get(5);
        } 
        else if(o instanceof Teklifler){
            return mapper.get(6);
        }
        return mapper.get(7);
        
    }
    
    public ResultSet getR(Object o, int nedir, int ID){
        mp = getMapper(o);
        if(o instanceof AcikEksiltme) { 
            if(nedir == 0) {
                
               return mp.getR(ID, 2); 
            }
            else if(nedir == 1) {
               return mp.getR(ID, 1); 
            }
        }   
        return null;        
    }
    
    public ResultSet getR(Object o, int ID){
        mp = getMapper(o);
        if(o instanceof Tasiyici) return mp.getR(ID, 1);
        else if(o instanceof Musteri) { return mp.getR(ID, 2); }
        else if(o instanceof Teklifler) return mp.getR(ID, 1);
        return null;        
    }
    
    public Object get(Object o,int ID){
        mp = getMapper(o);
        return mp.get(ID);
    }
    
    public void put(Object o){
        mp = getMapper(o);  
        mp.put(o);      
    }
    public int getL(Object o){
        mp = getMapper(o);
        return mp.getL(o);
    }
}

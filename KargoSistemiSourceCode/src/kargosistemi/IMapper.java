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
public interface IMapper {
    public void put(Object obje);
    public Object get(int ID);
    public ResultSet getR(int ID, int iT); // getResultSet
    public int getL(Object obje); // getLastData
}

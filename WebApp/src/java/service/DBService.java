/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author Nikolay
 */
@Stateless
public class DBService {
    
    @Resource(name = "mysql")
    private DataSource ds;
    
    public void storeData(Data data){
        String sql = "INSERT INTO dataStorage(requestDate, ip) VALUES (?,?)";
        try{
            try(Connection connection = ds.getConnection();
                    PreparedStatement ps = connection.prepareStatement(sql);){
                ps.setTimestamp(1, data.getTime());
                ps.setString(2, data.getIp());
                ps.executeUpdate();
               
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Data getData(){
        String sql = "SELECT * FROM dataStorage ORDER BY data_id DESC LIMIT 1;";
        Data data = new Data();
        try{
            try(Connection connection = ds.getConnection();
                    Statement statement = connection.createStatement();
                    ResultSet rs = statement.executeQuery(sql)){
                while (rs.next()){
                    data.setTime(rs.getTimestamp("requestDate"));
                    data.setIp(rs.getString("ip"));
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
}

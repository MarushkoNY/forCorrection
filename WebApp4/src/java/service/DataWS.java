/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Nikolay
 */
@WebService(serviceName = "DataWSImplService", portName = "DataWSImplPort", endpointInterface = "service.DataWSImpl", targetNamespace = "http://service/", wsdlLocation = "WEB-INF/wsdl/DataWS/WS.wsdl")
public class DataWS {

    public service.Data getData() {
          Context ctx = null;
        Data data = new Data();
        String query = "SELECT * FROM datastorage";
        DataSource ds = null;
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("mysql");
            try (Connection con = ds.getConnection();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(query);){
            while (rs.next()){
                data.setIp(rs.getString("ip"));
                data.setTime(rs.getTimestamp("requestDate"));
            }
            }
        } catch (Exception exx){
            exx.printStackTrace();
        }
        return data;
    }
    
    
     public static void storeData(Data data){
        Context ctx = null;
        DataSource ds = null;
        String query = "INSERT INTO dataStorage(requestDate, ip) VALUES (?,?);";
        try {
            ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("mysql");
            try (Connection connection = ds.getConnection();
                    PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setTimestamp(1, data.getTime());
                ps.setString(2, data.getIp());
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}

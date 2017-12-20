/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Nikolay
 */
@WebService(endpointInterface = "service.DataWS",
        portName = "GetDataPort",
        serviceName = "GetDataService")
public class DataWSImpl implements DataWS{
    
    @EJB
    DBService service;
    
    @Override
    public Data getData(){
        Data data = service.getData();
        return data;
    }
    
    public void storeData(Data data){
        service.storeData(data);
    }
    
    

}

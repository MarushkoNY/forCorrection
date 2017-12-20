/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import beans.BeanProducer;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;
import util.ServiceDef;

/**
 *
 * @author Nikolay
 */
@Stateless
public class DataService {

    
    
    public Data getData(){
        DataWS port = new GetDataService().getGetDataPort();
        Data data = port.getData();
        return data;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import clientService.DataWS;
import clientService.Data;
import clientService.DataWSImplService;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;
/**
 *
 * @author Nikolay
 */
@Stateless
public class DataWSClient {
    
    @WebServiceRef(wsdlLocation = "file:C:/Users/Nikolay/Desktop/WS.wsdl")
    private DataWSImplService service;
    
        public  Data getData(){
            DataWS port = service.getDataWSImplPort();
            Data data = port.getData();
            return data;
        }
    
}

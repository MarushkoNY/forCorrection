/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Data;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Nikolay
 */

@WebService
public interface DataWS {
    
    
    @WebMethod(operationName = "getData")
    public Data getData();
    
    public void storeData(Data data);
   
    
}

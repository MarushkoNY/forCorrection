/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Nikolay
 */
public class JAXBcfg {
    
    private static JAXBContext ctx;
    
    static {
        try {
            ctx = JAXBContext.newInstance(GetDataServiceConfig.class);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    
    
//   public void marsh(GetDataServiceConfig cfg){
//        try {
//            Marshaller marsh = ctx.createMarshaller();
//            marsh.marshal(cfg, new File("C:\\Users\\Nikolay\\Documents\\NetBeansProjects\\WebApp8\\src\\java\\util\\GetDataService.xsd"));
//            
//        } catch (JAXBException ex) {
//            Logger.getLogger(JAXBcfg.class.getName()).log(Level.SEVERE, null, ex);
//        }
//   }
    
    public GetDataServiceConfig unmarshall(){
        GetDataServiceConfig cfg = null;
        
        try {
            Unmarshaller unm = ctx.createUnmarshaller();
            cfg = (GetDataServiceConfig) unm.unmarshal(new File("C:\\Users\\Nikolay\\Documents\\NetBeansProjects\\WebApp8\\src\\java\\util\\GetDataService.xsd"));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        
        return cfg;
    }
    
//    public static void main(String[] args) {
////        GetDataServiceConfig cfg = new GetDataServiceConfig();
////        cfg.setConnectionTimeout(1000);
////        cfg.setEndpointLocation("http://localhost:7001/GetDataService");
////        cfg.setRecieveTimeout(1000);
////        
////        new JAXBcfg().marsh(cfg);
//        GetDataServiceConfig cfg = new JAXBcfg().unmarshall();
//        System.out.println(cfg.getConnectionTimeout());
//        System.out.println(cfg.getEndpointLocation());
        
    
}

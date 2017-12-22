/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import cfg2.GetDataConfig;
import java.io.File;
import java.util.Map;
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
            ctx = JAXBContext.newInstance(GetDataConfig.class);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    
    public void marshall(GetDataConfig cfg){
        try {
            Marshaller mrs = ctx.createMarshaller();
            mrs.marshal(cfg, new File("classpath:user_projects\\domains\\mydomain\\config\\ApplicationConfig\\GetDataService11.xml"));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
    
     public GetDataConfig unmarshall(){
        GetDataConfig cfg = null;
        
        try {
            Unmarshaller unm = ctx.createUnmarshaller();
            cfg = (GetDataConfig) unm.unmarshal(new File("C:\\Users\\Nikolay\\Desktop\\wls12130\\user_projects\\domains\\mydomain\\config\\ApplicationConfig\\GetDataService.xml"));
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        
        return cfg;
    }
     
     
     
     public static void main(String[] args) {
//       GetDataConfig cfg  = new JAXBcfg().unmarshall();
//         System.out.println(cfg.getConnectionTimeout());
//         System.out.println(cfg.getEndpointLocation());
         
//           Map<String, String> env = System.getenv();
//           for (Map.Entry<String, String> s : env.entrySet()){
//               System.out.println(s.getKey() + " = " + s.getValue());
//           }
         GetDataConfig cfg = new GetDataConfig();
         cfg.setConnectionTimeout(1000);
         cfg.setEndpointLocation("s22211111122ss");
         cfg.setRecieveTimeout(1000);
         
         new JAXBcfg().marshall(cfg);
    }
//  
}

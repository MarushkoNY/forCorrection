/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static com.sun.xml.internal.ws.developer.JAXWSProperties.CONNECT_TIMEOUT;
import static com.sun.xml.internal.ws.developer.JAXWSProperties.REQUEST_TIMEOUT;
import static com.sun.xml.internal.ws.developer.JAXWSProperties.WSENDPOINT;
import com.sun.xml.internal.ws.developer.WSBindingProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.xml.ws.BindingProvider;
import WSGen.GetDataService;
import cfg2.GetDataConfig;

/**
 *
 * @author Nikolay
 */
public class InitParams {
    
    public void init() throws FileNotFoundException, IOException{
            
        GetDataConfig cfg = new JAXBcfg().unmarshall();
        
        
        BindingProvider bp = (BindingProvider) new GetDataService().getGetDataPort();
        Map<String,Object> ctx = bp.getRequestContext();
        ctx.put(CONNECT_TIMEOUT,  cfg.getConnectionTimeout());
        ctx.put(REQUEST_TIMEOUT, cfg.getRecieveTimeout());
        ctx.put(WSENDPOINT, cfg.getEndpointLocation());
        
        
    }

    
    
    
    
    
}


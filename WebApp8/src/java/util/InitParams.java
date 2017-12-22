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
import service.GetDataService;

/**
 *
 * @author Nikolay
 */
public class InitParams {
    
    public void init() throws FileNotFoundException, IOException{

        URL url = getClass().getResource("GetDataService.xml");
        FileReader fr = new FileReader(url.getPath());
        Scanner scan = new Scanner(fr);
        String parameters = "";
        int c;
        while (scan.hasNextLine()){
            parameters += scan.nextLine();
        }
        Map<String, String> values = new HashMap<>();
        String[] mas = parameters.split(" ");
        for (int i = 0; i <= mas.length-1; i+=2){
            values.put(mas[i], mas[i+1]);
        }
        BindingProvider bp = (BindingProvider) new GetDataService().getGetDataPort();
        Map<String,Object> ctx = bp.getRequestContext();
        ctx.put(CONNECT_TIMEOUT,  Integer.parseInt(values.get("connectionTimeout")));
        ctx.put(REQUEST_TIMEOUT, Integer.parseInt(values.get("recieveTimeout")));
        ctx.put(WSENDPOINT, values.get("enpointLocation"));
        
        
    }

    
    
    
    
    
}


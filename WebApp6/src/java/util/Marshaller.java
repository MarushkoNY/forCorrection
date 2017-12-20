/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import clientService.Data;

/**
 *
 * @author Nikolay
 */
public class Marshaller {
    
    private static JAXBContext ctx;
    
    
    public static String marshall(Data data) {
        if (ctx == null){
            try{
            ctx = JAXBContext.newInstance(Data.class);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        String message="";
        try{
        File file = new File("C:/Users/Nikolay/Desktop/data.xml");
        
        javax.xml.bind.Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(data, file);
        
        FileReader reader = new FileReader(file);
        
        int c = 0;
        while ((c = reader.read()) != -1){
            message +=(char)c; 
        }
        } catch (Exception ex){
            System.out.println("Marshalling exception");
            ex.printStackTrace();
        }
        
        
        return message;
    }
}

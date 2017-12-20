/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import service.Data;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Nikolay
 */
public class Unmarshaller {

    private static JAXBContext ctx;

    static {
        try {
            ctx = JAXBContext.newInstance(Data.class);
        } catch (JAXBException ex) {
            Logger.getLogger(Unmarshaller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }

    public static Data unmarshall(String xmlString) {
        Data data = null;
        try {
            javax.xml.bind.Unmarshaller unmarshaller = ctx.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            data = (Data) unmarshaller.unmarshal(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
}

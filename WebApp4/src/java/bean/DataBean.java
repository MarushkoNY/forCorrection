/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Nikolay
 */
import service.Data;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import service.DataWS;
import service.DataWSImpl;
import util.Unmarshaller;

/**
 *
 * @author Nikolay
 */
@MessageDriven(mappedName = "NewQueue")
public class DataBean implements MessageListener{
    
    
    public void onMessage(Message inputMessage){
        
        Connection connection = null;
        Session session = null;
        TextMessage message = null;
        String result = null;
        try{
            
            
            
            message = (TextMessage) inputMessage;
            result = message.getText();
            System.out.println(result);
            Data data = Unmarshaller.unmarshall(result);
            DataWS.storeData(data);
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}


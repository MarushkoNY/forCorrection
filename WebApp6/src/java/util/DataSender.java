/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import clientService.Data;
import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.naming.InitialContext;

/**
 *
 * @author Nikolay
 */
@Stateless
public class DataSender {
   
    @Resource(mappedName = "NewConnectionFactory")
    ConnectionFactory factory;
    
    @Resource(mappedName = "NewQueue")
    Queue queue;
    
    public void sendData(Data data){
        
        
        String sMessage = Marshaller.marshall(data);
        Connection connection;
        Session session;
        try{
//            InitialContext ctx = new InitialContext();
//            ConnectionFactory factory = (ConnectionFactory) ctx.lookup("NewConnectionFactory");
//            Queue queue = (Queue) ctx.lookup("NewQueue");
            
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            message.setText(sMessage);
            producer.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

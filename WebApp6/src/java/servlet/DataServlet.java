/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clientService.Data;
import javax.ejb.EJB;
import util.DataSender;
import util.DataWSClient;

/**
 *
 * @author Nikolay
 */
@WebServlet(name = "DataServlet", urlPatterns = {"/storeData", "/getData"})
public class DataServlet extends HttpServlet {

    @EJB
    DataSender sender;
    
    @EJB
    DataWSClient dataClient;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        String ip = req.getRemoteHost();
        Data data = new Data();
        data.setTime(time);
        data.setIp(ip);
        sender.sendData(data);
        
        PrintWriter out = resp.getWriter();
        out.println("Your request's time and IP address was recorded!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          Data data = dataClient.getData();
          PrintWriter out = resp.getWriter();
          out.println("Last request's date and time: " + data.getTime());
          out.println("Last request's IP address: " + data.getIp());

    }

        
}

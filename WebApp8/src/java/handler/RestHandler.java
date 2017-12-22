/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import beans.BeanProducer;
import java.io.IOException;
import java.net.URI;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import service.Data;
import service.Service;
import util.InitParams;
import util.ServiceDef;
import util.Validator;

/**
 *
 * @author Nikolay
 */

@Stateless
@Path("/")
public class RestHandler {
    
    private static boolean isInitializated = false;
    
    @Inject @Any 
    private Instance<Service> services;
    
    
    @POST
    @Path("/Store")
    @Produces("text/html")
    public Response storeData(@Context HttpServletRequest req, @FormParam("mode")String mode){
        int imode;
        if((imode = Validator.validate(mode))==0){
            return Response.ok().entity("Enter the proper values!").build();
        }
        Data data = new Data();
        data.setIp(req.getRemoteAddr());
        data.setTime(new Timestamp(System.currentTimeMillis()));
        resolveService(imode).storeData(data);
        String resp = "Your IP and request time was added to server!";
        return Response.ok().entity(resp).build();
    }
    
    @GET
    @Path("/GetData")
    @Produces("text/html")
    public  Response getData(@QueryParam("mode") String mode) throws IOException{
        int imode;
        if ((imode = Validator.validate(mode)) == 0){
            return Response.ok().entity("Enter the proper values!").build();
        }
            
        Data data = resolveService(imode).getData();
        String ip = data.getIp();
        Timestamp time = data.getTime();
        
        if (isInitializated == true){
            new InitParams().init();
        }
        
        return Response.ok().entity(ip + " " + time).build();
    }
    
    private Service resolveService(int mode) {
        Service ret = null;
        for (Service service : services) {
            ServiceDef def = getDefAnnotation(service.getClass());
            if (def != null) {
                if (def.mode() == mode) {
                    ret = service;
                    break;
                }
            }
        }
        return ret;
    }
    
    private ServiceDef getDefAnnotation(Class clazz) {
        return (ServiceDef) clazz.getAnnotation(ServiceDef.class);
    }
    
//    @POST
//    @Path("/Mode")
//    @Produces("text/html")
//    public Response chooseMode(@FormParam("mode")String mode) throws Exception{
//        if ()
//         URI uri = UriBuilder.fromUri("http://localhost:7001/").build();
//        return Response.temporaryRedirect(uri).build();
//    }
    
    
    
}


package service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DataWS", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DataWS {


    /**
     * 
     * @return
     *     returns service.Data
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getData", targetNamespace = "http://service/", className = "service.GetData")
    @ResponseWrapper(localName = "getDataResponse", targetNamespace = "http://service/", className = "service.GetDataResponse")
    @Action(input = "http://service/DataWS/getDataRequest", output = "http://service/DataWS/getDataResponse")
    public Data getData();

}

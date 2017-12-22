/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nikolay
 */
@XmlRootElement
public class GetDataServiceConfig {
    
    
    private int connectionTimeout;
    
    private int recieveTimeout;
    
    private String endpointLocation;

    
    
    public int getConnectionTimeout() {
        return connectionTimeout;
    }
    @XmlElement
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getRecieveTimeout() {
        return recieveTimeout;
    }
    @XmlElement
    public void setRecieveTimeout(int recieveTimeout) {
        this.recieveTimeout = recieveTimeout;
    }

    public String getEndpointLocation() {
        return endpointLocation;
    }
    @XmlElement
    public void setEndpointLocation(String endpointLocation) {
        this.endpointLocation = endpointLocation;
    }
    
    
    
}

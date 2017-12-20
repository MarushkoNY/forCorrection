/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nikolay
 */
@XmlRootElement
public class Data {
    private int id;
    
    private Timestamp time;
    
    private String ip;
    
    public Data(){}

    public Data(Timestamp time, String ip) {
        this.time = time;
        this.ip = ip;
    }

    public int getId() {
        return id;
    }
    
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    @XmlElement
    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }
    
    @XmlElement
    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
    
}

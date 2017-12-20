
package service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import entity.Data;

@XmlRootElement(name = "getDataResponse", namespace = "http://service/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataResponse", namespace = "http://service/")
public class GetDataResponse {

    @XmlElement(name = "return", namespace = "")
    private Data _return;

    /**
     * 
     * @return
     *     returns Data
     */
    public Data getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Data _return) {
        this._return = _return;
    }

}

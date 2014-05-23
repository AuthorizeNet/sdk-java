
package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMerchantInfoResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMerchantInfoResponseData">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.authorize.net/ANetApiWS/}BaseResponseData">
 *       &lt;sequence>
 *         &lt;element name="ServiceStatusList" type="{http://api.authorize.net/ANetApiWS/}ArrayOfSERVICESTATUS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMerchantInfoResponseData", propOrder = {
    "serviceStatusList"
})
public class GetMerchantInfoResponseData
    extends BaseResponseData
{

    @XmlElement(name = "ServiceStatusList")
    protected ArrayOfSERVICESTATUS serviceStatusList;

    /**
     * Gets the value of the serviceStatusList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSERVICESTATUS }
     *     
     */
    public ArrayOfSERVICESTATUS getServiceStatusList() {
        return serviceStatusList;
    }

    /**
     * Sets the value of the serviceStatusList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSERVICESTATUS }
     *     
     */
    public void setServiceStatusList(ArrayOfSERVICESTATUS value) {
        this.serviceStatusList = value;
    }

}
